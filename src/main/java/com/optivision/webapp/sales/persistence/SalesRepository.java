package com.optivision.webapp.sales.persistence;


import com.optivision.webapp.sales.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<SaleEntity, Long> {

    public List<SaleEntity> getAllByFechaCreacionIs(LocalDate specificDate);
    public SaleEntity getByEstadoVentaIs(String estadoVenta);
    public List<SaleEntity> getAllByFechaCreacionIs(LocalDate initialDate, LocalDate endDate);
}
