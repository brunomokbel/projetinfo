package com.esme.spring.faircorp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private  Integer Floor;

    @NotNull
    private String name;
    @OneToMany(mappedBy = "room")
    private List<Light> lights ;
    @ManyToOne
    private Building building;


    public Long getId() {
        return this.id;
    }
    public Room(){

    }
    public Room(Integer floor, String name,List<Light>lights, Building building) {
        this.Floor = floor;
        this.name = name;
        this.lights=lights;
        this.building=building;

}
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getFloor() {
        return Floor;
    }

    public List<Light> getLights() {
        return lights;
    }

    public Building getBuilding() {
        return building;
    }

    public void setFloor(Integer Floor) {
        this.Floor = Floor;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }
    public void setBuilding(Building building){this.building=building;}
}
