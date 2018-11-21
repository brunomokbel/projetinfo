package com.esme.spring.faircorp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    @OneToMany(mappedBy = "building")
    private  List<Room> rooms;
    @NotNull

    private String name;
    public Building() {

    }

    public Building(String name,List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
