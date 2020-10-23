package com.optivision.webapp.product.repository;

import com.optivision.webapp.product.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Producto, Long> {

    public Producto getProductoByTipoProductoLikeAndTipoMarcoLikeAndColorLike(String marcoType, String tipoMarco, String color);
    public Producto getProductoByTipoProductoLike(String tipoProductoType);
    public Producto getProductoByLiquidoLikeAndMililitrosLiquidoIs(String liquido, int ml);
    public Producto getProductoByTipoProductoLikeAndMaterial(String estucheType, String estucheMaterial);
    public List<Producto> getAllByTipoProductoLikeAndMaterialLike(String tipoProductoType, String material);
}
