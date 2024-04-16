package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
}
