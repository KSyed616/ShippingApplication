package com.cps714.objects.shipments;



import com.cps714.objects.users.Customer;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Shipments")
public class Shipments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipmentID")
    private Integer shipmentID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "PickupLocation")
    private String pickupLocation;

    @Column(name = "DeliveryLocation")
    private String deliveryLocation;

    @Column(name = "PickupDate")
    private String pickupDate;

    @Column(name = "DeliveryDate")
    private String deliveryDate;

    @Column(name = "ShippingMethod")
    private String shippingMethod;

    @Column(name = "Status")
    private String status;

    @Column(name = "TrackingID")
    Integer shipmentTracking;

}
