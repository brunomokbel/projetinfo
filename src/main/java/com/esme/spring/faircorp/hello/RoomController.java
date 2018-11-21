package com.esme.spring.faircorp.hello;

import com.esme.spring.faircorp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController  // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {
    @Autowired
    private LightDAO lightDao; // (4)
    @Autowired
    private RoomDao roomDao;



    @GetMapping // (5)
    public List<RoomDTO> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{room_id}")
    public RoomDTO findById(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> new RoomDTO(room)).orElse(null);
    }

    @PutMapping(path = "/{room_id}/switchLight")
    public RoomDTO switchStatus(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Light light:room.getLights())
              {if (light.getStatus()== Status.ON){
                    light.setStatus(Status.OFF);
              }
            else {
                light.setStatus(Status.ON);
              }
        };
        return new RoomDTO(room);
    }

    @PostMapping
    public RoomDTO create(@RequestBody RoomDTO dto) {
        Room room = null;
        if (dto.getId() != null) {
            room = roomDao.findById(dto.getId()).orElse(null);
        }

        if (room == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName(),dto.getLights(),dto.getBuilding()));
        } else {
            room.setFloor(dto.getFloor());
            room.setName(dto.getName());
            roomDao.save(room);
        }

        return new RoomDTO(room);
    }

    @DeleteMapping(path = "/{room_id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}
