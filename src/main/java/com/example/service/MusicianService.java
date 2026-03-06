package com.example.service;

import com.example.model.Musician;
import com.example.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class MusicianService {
    @Autowired
    MusicianRepository musicianRepository;

    public void addMusician(@RequestBody Musician musician) {
        musicianRepository.save(musician);
    }

    public List<Musician> listMusician() {
        return musicianRepository.findAll();
    }

    public Optional<Musician> findOneMusician(@PathVariable int id) {
        return musicianRepository.findById(id);
    }

    public Musician updateMusician(@PathVariable int id, @RequestBody Musician newMusician) {
        Optional<Musician> oldMusician = musicianRepository.findById(id);
        oldMusician.get().setName(newMusician.getName());
        musicianRepository.save(oldMusician.get());
        return oldMusician.get();
    }

    public void deleteMusician(@PathVariable int id) {
        musicianRepository.deleteById(id);
    }
}
