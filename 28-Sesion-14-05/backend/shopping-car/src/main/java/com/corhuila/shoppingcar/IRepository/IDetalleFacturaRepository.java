package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Document.DetalleFactura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleFacturaRepository extends MongoRepository<DetalleFactura, String> {
}
