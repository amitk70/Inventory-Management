package com.microservices.order_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long id;
    private String orderNumber;
    private String code;
    private BigDecimal price;
    private Integer quantity;
}
