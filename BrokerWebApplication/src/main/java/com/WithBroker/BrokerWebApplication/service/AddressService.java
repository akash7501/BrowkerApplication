package com.WithBroker.BrokerWebApplication.service;

import com.WithBroker.BrokerWebApplication.entity.AddressEntity;
import com.WithBroker.BrokerWebApplication.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    public AddressEntity createAddress(AddressEntity addressEntity)
    {
        return addressRepo.save(addressEntity);
    }

}
