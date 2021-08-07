package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

}
