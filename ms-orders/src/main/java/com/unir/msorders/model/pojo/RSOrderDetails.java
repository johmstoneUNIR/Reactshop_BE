package com.unir.msorders.model.pojo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orderdetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RSOrderDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long odid;

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    private RSOrders rsorder;

    @Column(name = "productid")
    private String productid;

    @Column(name = "qty")
    private float qty;

    @Column(name = "subtotal")
    private float subtotal;

    @Column(name = "iva")
    private float iva;
}
