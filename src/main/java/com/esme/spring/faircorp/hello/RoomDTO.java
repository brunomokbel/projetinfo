package com.esme.spring.faircorp.hello;

import com.esme.spring.faircorp.model.Building;
import com.esme.spring.faircorp.model.Light;
import com.esme.spring.faircorp.model.Room;

import java.util.List;

public class RoomDTO {
    private  Long id ;
    private  Integer floor;
    private String name;
    private List<Light> lights ;
    private Building building;


    public RoomDTO() {
    }


    public RoomDTO(Room room) {
        this.id = room.getId();
        this.floor = room.getFloor();
        this.lights=room.getLights();
        this.name=room.getName();
        this.building=room.getBuilding();


    }
    public String getName(){return name;}
    public Long getId() {
        return id;
    }

    public Integer getFloor() {
        return floor;
    }
    public List<Light> getLights() {
        return lights;
    }
    public Building getBuilding(){return building;}


}
