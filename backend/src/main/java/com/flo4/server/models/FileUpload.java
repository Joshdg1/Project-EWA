package com.flo4.server.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "file_upload")
public class FileUpload {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;
//
//    public FileUpload(){}
//
//    public FileUpload(String id, String name, String type, byte[] data, User user_id) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        this.data = data;
//        this.user_id = user_id;
//    }

}
