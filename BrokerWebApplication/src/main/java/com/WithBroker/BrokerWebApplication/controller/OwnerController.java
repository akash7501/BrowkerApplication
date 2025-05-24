package com.WithBroker.BrokerWebApplication.controller;

import com.WithBroker.BrokerWebApplication.entity.OwnerEntity;
import com.WithBroker.BrokerWebApplication.service.CacheInspectionService;
import com.WithBroker.BrokerWebApplication.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping("/createOwner")
    public OwnerEntity createOwnerDetails(@RequestBody OwnerEntity owner)
    {
    return ownerService.createOwnerDetails(owner);
    }

    @DeleteMapping("/{id}")
    public String deleteOnwerEntity(@PathVariable Long id)
    {
        return ownerService.deleteOwnerDetails(id);
    }

    @GetMapping("/getAllDetails")
    public  List<OwnerEntity> getAllOwnerDetails()
    {
        return ownerService.findallOnwerDetails();
    }
    /*@PutMapping("/{id}")
    public OwnerEntity updateOnwerDetials(@RequestBody OwnerEntity ow,@PathVariable Long id)

    {
        ownerService.updateOwnerDetails( ow,id);
    }*/

    @GetMapping("/{findbyId}")
    public Optional<OwnerEntity> getbyId(@PathVariable Long findbyId)
    {
         return ownerService.fBID(findbyId);
    }


    @Autowired
    CacheInspectionService cacheInspectionService;
    @GetMapping("/gecache")
    public List<OwnerEntity> getCacheData()
    {
       return  cacheInspectionService.printCacheData("owner");
    }




}
