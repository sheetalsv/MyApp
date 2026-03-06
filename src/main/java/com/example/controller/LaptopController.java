package com.example.controller;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Laptop;
import com.example.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // it exposes data and service in the form of JSON/XML
@RequestMapping("/laptop")
@CrossOrigin("*")
public class LaptopController {
    @Autowired
    LaptopService lr;
    @PostMapping("/add")
    public void add(@RequestBody Laptop lp)
    {        //list.add("Surya");
        lr.addlaptop(lp);
    }
    @GetMapping("/list")
    public List<Laptop> list()
    {
        return lr.listLaptop();
    }
    @GetMapping("/findOne/{index}")
    public ResponseEntity<Laptop> findOne(@PathVariable int index)
    {
        Laptop lt=lr.findOneLaptop(index).orElseThrow(()->new ResourceNotFoundException("Laptop id not found: "+index));
        return ResponseEntity.ok().body(lt);
    }
    @PutMapping("/update/{index}")
    public ResponseEntity<Laptop> update(@PathVariable int index,@RequestBody Laptop newLaptop)
    {
        Laptop oldLaptop=lr.findOneLaptop(index).orElseThrow(()->new ResourceNotFoundException("Laptop id not found: "+index));
        lr.updateLaptop(index,newLaptop);
        return ResponseEntity.ok().body(oldLaptop);
    }
    @DeleteMapping("/delete/{index}")
    public void delete(@PathVariable int index)
    {

        lr.deleteLaptop(index);
    }
    @GetMapping("/findByBrand/{brand}")
    public List<Laptop> findByBrandName(@PathVariable String brand)
    {
        return lr.findByBrand(brand);
    }
}