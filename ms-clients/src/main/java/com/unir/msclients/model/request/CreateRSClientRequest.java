package com.unir.msclients.model.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRSClientRequest {
    
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
}
