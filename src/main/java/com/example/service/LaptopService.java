package com.example.service;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    LaptopRepository lr;
    public void addlaptop(@RequestBody Laptop lp)
    {        //list.add("Dhoni");
        lr.save(lp);
    }
    public List<Laptop> listLaptop()
    {
        return lr.findAll();
    }
    public Optional<Laptop> findOneLaptop(@PathVariable int index)
    {
        return lr.findById(index);
    }
    public Laptop updateLaptop(@PathVariable int index, @RequestBody Laptop newLaptop)
    {
        Optional<Laptop> oldLaptop=lr.findById(index);
        oldLaptop.get().setName(newLaptop.getName());
        oldLaptop.get().setBrand(newLaptop.getBrand());
        oldLaptop.get().setPrice(newLaptop.getPrice());
        oldLaptop.get().setRAM(newLaptop.getRAM());
        lr.save(oldLaptop.get());
        return oldLaptop.get();
    }
    public void deleteLaptop(@PathVariable int index)
    {
        lr.deleteById(index);
    }
    public List<Laptop> findByBrand(@PathVariable String brand)
    {
        return lr.findByBrand(brand);
    }

}
