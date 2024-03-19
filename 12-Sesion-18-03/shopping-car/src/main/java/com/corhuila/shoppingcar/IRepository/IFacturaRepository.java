package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Long> {
}
