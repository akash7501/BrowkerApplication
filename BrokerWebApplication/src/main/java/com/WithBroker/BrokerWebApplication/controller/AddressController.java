package com.WithBroker.BrokerWebApplication.controller;

import com.WithBroker.BrokerWebApplication.entity.AddressEntity;
import com.WithBroker.BrokerWebApplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

@Autowired
    AddressService addressService;
    @PostMapping("/Address")
    public String CreateAddressDetails(@RequestBody AddressEntity addressEntity)
    {
         addressService.createAddress(addressEntity);
         return "addres added succefull";
    }

}
