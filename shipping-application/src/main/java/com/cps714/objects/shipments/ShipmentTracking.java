package com.cps714.objects.shipments;

import lombok.Data;

import jakarta.persistence.*;

import java.time.LocalDate;

//Shipment Tracking entity
@Data
@Entity
@Table(name = "ShipmentTracking")
public class ShipmentTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrackingID")
    private Integer trackingID;

    @ManyToOne
    @JoinColumn(name = "ShipmentID")
    private Shipments shipment;

    @Column(name = "Status")
    private String status;

    @Column(name = "UpdateTime")
    private LocalDate updateTime;

    @Column(name = "ETA")
    private LocalDate eta;
}
