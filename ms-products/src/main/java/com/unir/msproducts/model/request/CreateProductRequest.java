package com.unir.msproducts.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    
    private String name;
    private Float price;
    private String imageurl;
    private boolean isvisible;
}
