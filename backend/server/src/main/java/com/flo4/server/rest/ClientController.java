package com.flo4.server.rest;

import com.flo4.server.Exceptions.NotFoundException;
import com.flo4.server.models.Client;
import com.flo4.server.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("clients")
@CrossOrigin(origins = "http://localhost:8081")
public class ClientController {

    @Autowired
    EntityRepository<Client> clientEntityRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Client> getAllClients() {
        return this.clientEntityRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Client> findOneClient(@PathVariable() int id) {
        Client client = this.clientEntityRepository.findById(id);
        if (client == null) {
            throw new NotFoundException(String.format("Client with id %d was not found!", id));
        }

        return ResponseEntity.ok().body(client);
    }

    @Transactional
    @PostMapping(path = "add", produces = "application/json")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {

        Client newClient = this.clientEntityRepository.save(client);


        return ResponseEntity.ok().body(newClient);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Client> deleteClient(@PathVariable int id) {
        Client client = this.clientEntityRepository.findById(id);

        if (client == null) {
            throw new NotFoundException(String.format("Client with id %d was not found!", id));
        }
        this.clientEntityRepository.deleteById(id);

        return ResponseEntity.ok().body(client);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
        Client updateClient = this.clientEntityRepository.update(client, id);

        if (updateClient == null) {
            throw new NotFoundException(String.format("Client with id %d was not found!", id));
        }

        return ResponseEntity.ok().body(updateClient);
    }
}

