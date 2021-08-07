package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entity.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
