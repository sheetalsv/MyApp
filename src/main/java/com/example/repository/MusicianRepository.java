package com.example.repository;

import com.example.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicianRepository extends JpaRepository<Musician, Integer> {
}
