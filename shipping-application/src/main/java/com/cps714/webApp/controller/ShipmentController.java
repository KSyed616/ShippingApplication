package com.cps714.webApp.controller;

import com.cps714.objects.shipments.Shipments;
import com.cps714.objects.users.Customer;
import com.cps714.repository.AccountRepository;
import com.cps714.repository.CustomerRepository;
import com.cps714.repository.ShipmentRepository;
import com.cps714.webApp.models.SessionUser;
import com.cps714.webApp.service.RegisterService;
import com.cps714.webApp.service.ShipmentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
    public String shipment(Model model) {
        return "shipment";
    }

    @PostMapping("/createShipment")
    public String shipment(Model model, Shipments shipments){
        //saving the shipment information in to the shipments database
       shipments.setPickupDate("November 25th 2023");
       shipments.setStatus("Pending");
       shipments.setDeliveryDate("T.B.D");

       shipmentRepository.save(shipments);
       //model.addAttribute("sessionUser", user);
       //Customer customer = customerRepository.findByEmail(user.getEmail());

       //shipments.setCustomer(customer.getCustomerID());
       return "shipment";
    }
}
