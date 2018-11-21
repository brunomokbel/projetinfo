package com.esme.spring.faircorp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Light {
    // (1)


    // (2)
    @Id
    @GeneratedValue
    private Long id;

    // (3)
    @NotNull
    private Integer level;

    // (4)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @ManyToOne
    private Room room;

    public Light() {

    }

    public Light(Room room,Integer level, Status status) {
        this.level = level;
        this.status = status;
        this.room=room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

