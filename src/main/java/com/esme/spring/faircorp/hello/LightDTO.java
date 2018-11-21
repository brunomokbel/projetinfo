package com.esme.spring.faircorp.hello;

import com.esme.spring.faircorp.model.Light;
import com.esme.spring.faircorp.model.LightDAO;
import com.esme.spring.faircorp.model.Status;

public class LightDTO  {
    private  Long id ;
    private  Integer level;
    private  Status status;

    public LightDTO() {
    }


    public LightDTO(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }
}

