package com.cps714.objects.shipments;

import lombok.Data;

import jakarta.persistence.*;

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
    private Shipment shipment;

    @Column(name = "Status")
    private String status;

    @Column(name = "UpdateTime")
    private Timestamp updateTime;

    @Column(name = "ETA")
    private Timestamp eta;
}
