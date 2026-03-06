package com.example.repository;

import com.example.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Integer> {
}
