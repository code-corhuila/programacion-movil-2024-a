package com.corhuila.shoppingcar.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IFacturaDto {
    Long getId();
    LocalDateTime getFecha();
    BigDecimal getTotalBruto();
    BigDecimal getTotalNeto();
    BigDecimal getTotalDescuento();
    BigDecimal getTotalIva();
    String getCliente();
    Long getIdCliente();
}
