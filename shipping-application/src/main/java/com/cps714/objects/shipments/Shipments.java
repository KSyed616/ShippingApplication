package com.cps714.objects.shipments;



import com.cps714.objects.users.Customer;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Shipments")
public class Shipment {

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
}
