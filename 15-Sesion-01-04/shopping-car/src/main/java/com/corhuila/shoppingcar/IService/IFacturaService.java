package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Document.Factura;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {
    List<Factura> findAll(); // Devuelve una lista de facturas
    Optional<Factura> findById(String id); // Devuelve un factura por su id
    Factura save(Factura factura); // Guarda un factura
    void update(Factura factura, String id); // Actualiza un factura
    void delete(String id); // Elimina un factura
}
