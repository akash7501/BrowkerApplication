package com.WithBroker.BrokerWebApplication.controller;




import com.WithBroker.BrokerWebApplication.entity.*;
import com.WithBroker.BrokerWebApplication.entity.PropertyEntity;
//import com.WithBroker.BrokerWebApplication.service.PropertyService;
import com.WithBroker.BrokerWebApplication.repo.PropertyRepo;
import com.WithBroker.BrokerWebApplication.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.readAllBytes;
//import static sun.awt.image.MultiResolutionCachedImage.map;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService ps;

    @PostMapping("/createproperty")
    public PropertyEntity createPropertyDetails(@RequestPart("propertyEntity") PropertyEntity propertyEntity, @RequestPart("file") MultipartFile multipartFile) throws IOException {
        String fileName=multipartFile.getOriginalFilename();
        String jsonpropertry=propertyEntity.getName();
        System.out.println("fileName::"  + fileName  + "property ::" + jsonpropertry);
        return ps.createPropertyService(propertyEntity,multipartFile);
   // return propertyEntity;
    }
    @PostMapping("/test")
    public String test(@RequestPart("propertyEntity") PropertyEntity propertyEntity, @RequestPart("file") MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String name = propertyEntity.getName();
        return fileName + name;
    }

    @Autowired
    PropertyRepo propertyRepo;
    @GetMapping("/do/{id}")
    public ResponseEntity<byte[]> getPropertyImage(@PathVariable Long id) {
        Optional<PropertyEntity> property = propertyRepo.findById(id);

        byte[] image = property.get().getPropertyImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        //headers.setContentType(MediaType.MULTIPART_MIXED);
        return new ResponseEntity<>(image, headers, HttpStatus.OK) ;

    }



    @GetMapping("/allPropertyDetails")
    public List<PropertyEntity> getPropertyDetails()
    {
        return ps.findAllPropertyDetails();

    }

    @PutMapping("/{id}")
    public void updatePropertyDetails()
    {

    }
    @DeleteMapping("/{id}")
    public  String deletePropertyDetails(@PathVariable Long id) {
        ps.deleteProperty(id);
        return "Property Deleted";
    }

    @GetMapping("/{id}")
    public Optional<PropertyEntity> searchById(@PathVariable Long id)
    {
        return ps.propertySearch(id);

    }

    @GetMapping("/search")
    public List<PropertyEntity> searchByName(@RequestParam String name)
    {
        return ps.searchName(name);
    }


     // api to search by any parameter and get the images of that location
    @GetMapping("/searchByAnything")
    public ResponseBody searchByField(@RequestParam(required = false)  Long id,
                                              @RequestParam(required = false)  String config,
                                              @RequestParam(required = false) String location)
    {
        return (ResponseBody) ps.searchByAnyAttribute(id,config,location);
    }

}




