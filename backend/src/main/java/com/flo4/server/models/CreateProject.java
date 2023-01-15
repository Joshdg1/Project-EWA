package com.flo4.server.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CreateProject {
    private String name;

    private int id;
    private String description;
    private int client_id;
    private Date start_date;
    private Date end_date;
    private List<Integer> programmer_ids;

    public CreateProject(int id, String name, String description, Integer client_id, Date start_date, Date end_date, List<Integer> programmer_ids) {
        this.name = name;
        this.description = description;
        this.client_id = client_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.programmer_ids = programmer_ids;
        this.id = id;
    }
}
