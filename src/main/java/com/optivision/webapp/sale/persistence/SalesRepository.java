package com.optivision.webapp.sale.persistence;


import com.optivision.webapp.sale.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<SaleEntity, Long> {

    public List<SaleEntity> getAllByFechaCreacionIs(Date specificDate);
    public SaleEntity getByEstadoVentaIs(String estadoVenta);
    //public List<SaleEntity> getAllByFechaCreacionIs(LocalDate initialDate, LocalDate endDate);
}
