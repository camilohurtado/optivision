package com.optivision.webapp.product.service;

import com.optivision.webapp.commons.Util;
import com.optivision.webapp.product.dto.Product;
import com.optivision.webapp.product.enumerator.ProductType;
import com.optivision.webapp.product.exception.InvalidMaterialException;
import com.optivision.webapp.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productoRepository;

    public List<Product> getAllProducts() {
        return productoRepository.findAll()
                .stream()
                .map(producto -> producto.toDto())
                .collect(Collectors.toList());
    }

    public Product getProductById(Long id) {
        return productoRepository.
                getOne(id)
                .toDto();
    }

    public List<Product> getByGlassesByMaterial(String material) throws Exception {
        if (Util.isValid(material)) {
            return productoRepository
                    .getAllByTipoProductoLikeAndMaterialLike(ProductType.MARCO.getValue(), material)
                    .stream()
                    .map(producto -> producto.toDto())
                    .collect(Collectors.toList());
        } else {
            throw new InvalidMaterialException("GlassFrameMaterial no existente. Por favor ingrese un tipo de material valido");
        }
    }

    public Product searchMarcoFromSale(String tipoMarco, String color) {
        if(Util.isValid(tipoMarco)){
            return productoRepository
                    .getProductoByTipoProductoLikeAndTipoMarcoLikeAndColorLike(ProductType.MARCO.getValue(), tipoMarco, color)
                    .toDto();
        }else {
            throw new InvalidMaterialException("Tipo de marco no valido. Por favor ingrese un tipo de material valido");
        }
    }

    public Product searchEstuchesFromSale(String material) throws Exception {
        if(Util.materialCaseIsValid(material)){
            return productoRepository
                    .getProductoByTipoProductoLikeAndMaterial(ProductType.ESTUCHE.getValue(), material)
                    .toDto();
        }else{
            throw new Exception("Material de estuches no valido o no existente.");
        }
    }
}
