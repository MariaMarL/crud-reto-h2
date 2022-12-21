package com.example.crudh2reto.repository;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.model.ReportOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {

    @Query(value = "SELECT m.fecha,c.nombre as cliente, m.numerocuenta, " +
            "c.tipocuenta, c.saldoInicial, c.estado, m.valor as movimiento, " +
            "m.saldo as saldodisponible " +
            "FROM CLIENTE c " +
            "INNER JOIN CUENTA cu ON cu.clienteid = c.clienteid " +
            "INNER JOIN MOVIMIENTOS m ON m.cuentaid = c.cuentaid " +
            "WHERE c.clienteid = :clienteid " +
            "AND m.fecha between :fechainicial AND :fechafinal",
            nativeQuery = true)

    List<ReportOnly> reporte(@Param(value = "clienteid") int clienteid,
                             @Param(value = "fechainicial") Date fechainicial,
                             @Param(value = "fechafinal") Date fechafinal);
}
