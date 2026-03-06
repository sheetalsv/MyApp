package com.example.controller;

import com.example.model.Band;
import com.example.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/band")
public class BandController {
    @Autowired
    BandService bandService;

    @PostMapping("/add")
    public void add(@RequestBody Band band) {
        bandService.addBand(band);
    }

    @GetMapping("/list")
    public List<Band> list() {
        return bandService.listBand();
    }

    @GetMapping("/findOne/{id}")
    public Optional<Band> findOne(@PathVariable int id) {
        return bandService.findOneBand(id);
    }

    @PutMapping("/update/{id}")
    public Band update(@PathVariable int id, @RequestBody Band newBand) {
        return bandService.updateBand(id, newBand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        bandService.deleteBand(id);
    }
}
