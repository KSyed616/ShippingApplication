package com.cps714.objects.users;

import lombok.Data;

import jakarta.persistence.*;

import java.math.BigDecimal;

//Entity file for CarrierInformation (Unused)
@Data
@Entity
@Table(name = "CarrierInformation")
public class CarrierInformation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarrierID")
    private Integer carrierID;

    @Column(name = "CarrierName")
    private String carrierName;

    @Column(name = "ShippingMethod")
    private String shippingMethod;

    @Column(name = "Cost")
    private BigDecimal cost;

    @Column(name = "EstimatedDeliveryTime")
    private Integer estimatedDeliveryTime;

    @Column(name = "ContactPhone")
    private String contactPhone;
}
