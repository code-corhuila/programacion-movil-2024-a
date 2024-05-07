package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Document.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {

}
