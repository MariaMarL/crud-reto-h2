package com.example.crudh2reto.repository;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.model.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
}
