package com.example.controller;

import com.example.model.Musician;
import com.example.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musician")
public class MusicianController {
    @Autowired
    MusicianService musicianService;

    @PostMapping("/add")
    public void add(@RequestBody Musician musician) {
        musicianService.addMusician(musician);
    }

    @GetMapping("/list")
    public List<Musician> list() {
        return musicianService.listMusician();
    }

    @GetMapping("/findOne/{id}")
    public Optional<Musician> findOne(@PathVariable int id) {
        return musicianService.findOneMusician(id);
    }

    @PutMapping("/update/{id}")
    public Musician update(@PathVariable int id, @RequestBody Musician newMusician) {
        return musicianService.updateMusician(id, newMusician);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        musicianService.deleteMusician(id);
    }
}
