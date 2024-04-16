package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Entity.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface IDetalleFacturaService {
    List<DetalleFactura> findAll(); // Devuelve una lista de detalleFacturas
    Optional<DetalleFactura> findById(Long id); // Devuelve un detalleFactura por su id
    DetalleFactura save(DetalleFactura detalleFactura); // Guarda un detalleFactura
    void update(DetalleFactura detalleFactura, Long id); // Actualiza un detalleFactura
    void delete(Long id); // Elimina un detalleFactura
}
