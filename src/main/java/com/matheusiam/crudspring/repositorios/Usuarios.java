package com.matheusiam.crudspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusiam.crudspring.entities.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Integer>{

}
