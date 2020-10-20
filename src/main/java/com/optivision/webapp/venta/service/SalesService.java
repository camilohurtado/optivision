package com.optivision.webapp.sales.service;

import com.optivision.webapp.sales.dto.Sale;
import com.optivision.webapp.sales.entity.SaleEntity;
import com.optivision.webapp.sales.exception.InvalidSaleDataException;
import com.optivision.webapp.sales.persistence.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;

    /**
     * Method that is intended to make a sale operation. It
     * receives a Sale DTO that it has the info from UI arrangement
     * and in this stage all logic is going to be made so a Sale can
     * be stored in persistence layer. Initally a Sale is stored as
     * an Open Sale, because it is not complete until products are
     * delivered to client.
     *
     * @param sale - Sale
     */
    public Sale doSale(Sale sale) throws InvalidSaleDataException {
        if(sale != null){
            SaleEntity toSave = sale.toEntity();
            return salesRepository.save(toSave).toDto();
        }else{
            throw new InvalidSaleDataException("Sale data should not be null");
        }
    }

    /**
     * Get all the sales that belongs to a respective
     * date passed in as parameter.
     * @param date
     * @return
     */
    public List<Sale> getSalesByDate(LocalDate date){
        return salesRepository.getAllByFechaCreacionIs(Date.valueOf(date))
                .stream()
                .map(saleEntity -> saleEntity.toDto())
                .collect(Collectors.toList());
    }
}
