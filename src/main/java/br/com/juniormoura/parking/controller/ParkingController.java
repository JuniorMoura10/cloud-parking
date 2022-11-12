package br.com.juniormoura.parking.controller;

import br.com.juniormoura.parking.controller.dto.ParkingDTO;
import br.com.juniormoura.parking.controller.mapper.ParkingMapper;
import br.com.juniormoura.parking.model.Parking;
import br.com.juniormoura.parking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDtoList(parkingList);
        return result;
    }
}
