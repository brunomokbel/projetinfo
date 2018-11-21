package com.esme.spring.faircorp.hello;

import com.esme.spring.faircorp.model.Building;
import com.esme.spring.faircorp.model.Light;
import com.esme.spring.faircorp.model.Room;

import java.util.List;

public class BuildingDTO {
    private  Long id ;

    private String name;
    private List<Room> rooms ;


    public BuildingDTO() {
    }


    public BuildingDTO(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.rooms=building.getRooms();


    }
    public String getName(){return name;}
    public Long getId() {
        return id;
    }


    public List<Room> getRooms() {
        return rooms;
    }
}
