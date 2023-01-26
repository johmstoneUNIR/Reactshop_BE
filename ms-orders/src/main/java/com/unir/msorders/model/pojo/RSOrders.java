package com.unir.msorders.model.pojo;

import java.time.LocalDate;

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
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class RSOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderid;

    @ManyToOne
    @JoinColumn(name = "clientid", referencedColumnName = "clientid")
    private RSClient clientid;

    @Column(name = "paymentmethod")
    private String paymentmethod;

    @Column(name = "paidflag")
    private boolean paidflag;

    // @Column(name = "creationdate")
    // private LocalDate creationdate;
}
