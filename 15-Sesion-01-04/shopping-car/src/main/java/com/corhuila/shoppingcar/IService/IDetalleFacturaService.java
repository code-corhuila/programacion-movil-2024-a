package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Document.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface IDetalleFacturaService {
    List<DetalleFactura> findAll(); // Devuelve una lista de detalleFacturas
    Optional<DetalleFactura> findById(String id); // Devuelve un detalleFactura por su id
    DetalleFactura save(DetalleFactura detalleFactura); // Guarda un detalleFactura
    void update(DetalleFactura detalleFactura, String id); // Actualiza un detalleFactura
    void delete(String id); // Elimina un detalleFactura
}
