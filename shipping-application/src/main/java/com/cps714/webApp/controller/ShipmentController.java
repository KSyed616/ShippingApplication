package com.cps714.webApp.controller;

import com.cps714.objects.shipments.Shipments;
import com.cps714.objects.users.Customer;
import com.cps714.repository.CustomerRepository;
import com.cps714.repository.ShipmentRepository;
import com.cps714.webApp.models.SessionUser;
import com.cps714.webApp.service.ShipmentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Controller
@SessionAttributes({"sessionUser"})
public class ShipmentController {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private ShipmentService shipmentService;

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    @GetMapping("/shipment")
    public String shipment(Model model, SessionUser user) {
        Customer customer = customerRepository.findByEmail(user.getEmail());
        List <Shipments> allShipments = shipmentRepository.findByCustomerCustomerID(customer.getCustomerID());
        model.addAttribute("shipments", allShipments);
        return "shipment";
    }

    @PostMapping("/createShipment")
    public String creatShipment(Model model, Shipments shipments, SessionUser user){
        //saving the shipment information in to the shipments database
       shipments.setPickupDate("November 25th 2023");
       shipments.setStatus("Pending");
       shipments.setDeliveryDate("T.B.D");

       model.addAttribute("sessionUser", user);
       Customer customer = customerRepository.findByEmail(user.getEmail());

       shipments.setCustomer(customer);

       List <Shipments> allShipments = shipmentRepository.findByCustomerCustomerID(customer.getCustomerID());
       model.addAttribute("shipments", allShipments);

       shipmentRepository.save(shipments);

       return "redirect:shipment";
    }

    @GetMapping("/processShipment/{shipmentID}")
    public String processShipment(Model model, @PathVariable("shipmentID") Integer shipmentID, SessionUser user){

        Shipments shipment = shipmentRepository.findByShipmentID(shipmentID);
        Shipments shippedShippment = shipmentService.processShipment(shipment);
        shipmentRepository.setTrackingIdByShipmentId(shipment.getShipmentTracking(), shipment.getShipmentID());

        Customer customer = customerRepository.findByEmail(user.getEmail());
        List <Shipments> allShipments = shipmentRepository.findByCustomerCustomerID(customer.getCustomerID());
        model.addAttribute("shipments", allShipments);

        return "redirect:/shipment";
    }
}
