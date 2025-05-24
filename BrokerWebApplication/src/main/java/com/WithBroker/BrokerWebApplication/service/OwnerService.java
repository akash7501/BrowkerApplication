package com.WithBroker.BrokerWebApplication.service;


import com.WithBroker.BrokerWebApplication.entity.OwnerEntity;
import com.WithBroker.BrokerWebApplication.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepo ownerRepo;


    public OwnerEntity createOwnerDetails(OwnerEntity owner) {
        return ownerRepo.save(owner);
    }


    public String deleteOwnerDetails(Long id) {
         Optional<OwnerEntity> opt = ownerRepo.findById(id);
        if (opt.isPresent()) {
            ownerRepo.deleteById(id);
            return "owner has been deleted";

        } else {
            return "id not found";
        }
    }


    public List<OwnerEntity> findallOnwerDetails() {
        return ownerRepo.findAll();
    }

    @Cacheable("owner")  // implementing cache
    public Optional<OwnerEntity> fBID(Long id) {
        return ownerRepo.findById(id);
    }

 /*   public void updateOwnerDetails(OwnerEntity ow, Long id) {
        Optional<OwnerEntity> opt = ownerRepo.findById(id);
        if(opt.isPresent())
        {
            OwnerEntity oe = opt.get();
            if(oe.getName()!=null) {
                opt.setName(ow.getName());
        }
            ownerRepo.save(opt);

    }
        return ow;
}*/
}

