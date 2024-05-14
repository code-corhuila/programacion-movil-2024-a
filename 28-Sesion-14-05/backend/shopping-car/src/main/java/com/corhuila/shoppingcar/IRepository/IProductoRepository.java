package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Document.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends MongoRepository<Producto, String> {
}
