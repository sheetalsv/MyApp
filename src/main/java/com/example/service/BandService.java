package com.example.service;

import com.example.model.Band;
import com.example.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    @Autowired
    BandRepository bandRepository;

    public void addBand(@RequestBody Band band) {
        bandRepository.save(band);
    }

    public List<Band> listBand() {
        return bandRepository.findAll();
    }

    public Optional<Band> findOneBand(@PathVariable int id) {
        return bandRepository.findById(id);
    }

    public Band updateBand(@PathVariable int id, @RequestBody Band newBand) {
        Optional<Band> oldBand = bandRepository.findById(id);
        oldBand.get().setName(newBand.getName());
        bandRepository.save(oldBand.get());
        return oldBand.get();
    }

    public void deleteBand(@PathVariable int id) {
        bandRepository.deleteById(id);
    }
}
