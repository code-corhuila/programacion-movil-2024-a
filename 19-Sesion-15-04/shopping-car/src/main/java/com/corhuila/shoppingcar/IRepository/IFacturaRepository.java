package com.corhuila.shoppingcar.IRepository;

import com.corhuila.shoppingcar.Dto.IFacturaDto;
import com.corhuila.shoppingcar.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Long> {

    @Query(value = "SELECT  " +
            " f.id, " +
            " f.fecha, " +
            " f.total_bruto totalBruto, " +
            " f.total_neto totalNeto, " +
            " f.total_descuento totalDescuento, " +
            " f.total_iva totalIva, " +
            "    c.nombre cliente, " +
            "    c.id clienteId " +
            "FROM  " +
            " cliente c " +
            "    INNER JOIN factura f ON f.cliente_id = c.id", nativeQuery = true)
    List<IFacturaDto> getList();
}
