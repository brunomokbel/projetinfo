package com.esme.spring.faircorp.hello;

import com.esme.spring.faircorp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController  // (1)
@RequestMapping("/api/buildings") // (2)
@Transactional // (3)
public class BuildingController {
    @Autowired
    private LightDAO lightDao; // (4)
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private BuildingDao buildingDao;



    @GetMapping // (5)
    public List<RoomDTO> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{building_id}")
    public BuildingDTO findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(building -> new BuildingDTO(building)).orElse(null);
    }

    @PostMapping
    public BuildingDTO create(@RequestBody BuildingDTO dto) {
        Building building = null;
        if (dto.getId() != null) {
            building = buildingDao.findById(dto.getId()).orElse(null);
        }

        if (building == null) {
            building = buildingDao.save(new Building(dto.getName(), dto.getRooms()));
        } else {
            building.setName(dto.getName());
            building.setRooms(dto.getRooms());
            buildingDao.save(building);
        }

        return new BuildingDTO(building);
    }

    @DeleteMapping(path = "/{building_id}")
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }

}
