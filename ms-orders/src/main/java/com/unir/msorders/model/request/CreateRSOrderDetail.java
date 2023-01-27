package com.unir.msorders.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRSOrderDetail {
    public String productid;
    private float qty;
    private float subtotal;
    private float iva;
}
