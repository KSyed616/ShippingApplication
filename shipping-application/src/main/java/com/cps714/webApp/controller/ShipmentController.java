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

//Controller for Shipment page
@Data
@Controller
//Defining the session user that is used in all files
@SessionAttributes({"sessionUser"})
public class ShipmentController {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private ShipmentService shipmentService;

    //Method to get sessionUser
    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(){
        return new SessionUser();
    }

    //Method for /shipment mapping
    @GetMapping("/shipment")
    public String shipment(Model model, SessionUser user) {
        //Retrieves all the shipments that are under the customers name
        Customer customer = customerRepository.findByCustomerID(user.getId());
        List <Shipments> allShipments = shipmentRepository.findByCustomerCustomerID(customer.getCustomerID());
        //Defining model that Thymeleaf syntax will pickup to display on the frontend
        model.addAttribute("shipments", allShipments);
        return "shipment";
    }

    //Method to define mapping for createShipment post mapping
    @PostMapping("/createShipment")
    public String creatShipment(Model model, Shipments shipments, SessionUser user){
        //saving the shipment information in to the shipments database
       shipments.setPickupDate("November 25th 2023");
       shipments.setStatus("Pending");
       shipments.setDeliveryDate("T.B.D");

       //Defining session user
       model.addAttribute("sessionUser", user);

       Customer customer = customerRepository.findByEmail(user.getEmail());

       //Setting customer for shipment
       shipments.setCustomer(customer);

       //Retrieving shipments for a user
       List <Shipments> allShipments = shipmentRepository.findByCustomerCustomerID(customer.getCustomerID());
       model.addAttribute("shipments", allShipments);
       //Saving created shipment to repository
       shipmentRepository.save(shipments);

       return "redirect:shipment";
    }

    //Method to define mapping for processShipment with path variable of shipmentID
    @GetMapping("/processShipment/{shipmentID}")
    public String processShipment(Model model, @PathVariable("shipmentID") Integer shipmentID, SessionUser user){
        //Using shipmentID from path variable to retrieve the shipment
        Shipments shipment = shipmentRepository.findByShipmentID(shipmentID);
        //Processing Shipment
        Shipments shippedShippment = shipmentService.processShipment(shipment);
        //Changing the parameters inside table for tracking and status
        shipmentRepository.setTrackingIdByShipmentId(shipment.getShipmentTracking(), shipment.getShipmentID());
        shipmentRepository.setStatusByShipmentId(shippedShippment.getStatus(), shipment.getShipmentID());
        
        Customer customer = customerRepository.findByEmail(user.getEmail());
        List <Shipments> allShipments = shipmentRepository.findByCustomerCustomerID(customer.getCustomerID());
        model.addAttribute("shipments", allShipments);

        return "redirect:/shipment";
    }
}
