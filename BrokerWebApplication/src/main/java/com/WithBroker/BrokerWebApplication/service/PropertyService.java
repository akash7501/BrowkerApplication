package com.WithBroker.BrokerWebApplication.service;

import com.WithBroker.BrokerWebApplication.entity.PropertyEntity;
import com.WithBroker.BrokerWebApplication.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.WithBroker.BrokerWebApplication.entity.PropertyEntity.*;

import static java.nio.file.Paths.get;

@Service
public class PropertyService {

    @Autowired
    PropertyRepo ps;

    public PropertyEntity createPropertyService(PropertyEntity propertyEntity,MultipartFile multipartFile) throws IOException {

       String fileName = multipartFile.getOriginalFilename();
        byte[] data = multipartFile.getBytes();
        PropertyEntity i = new PropertyEntity();
        i.setPropertyImage(data);
        i.setId(propertyEntity.getId());
        i.setName(propertyEntity.getName());
        i.setConfig(propertyEntity.getConfig());
        i.setAminities(propertyEntity.getAminities());
        i.setSalePrice(propertyEntity.getSalePrice());
        i.setPropertyAge(propertyEntity.getPropertyAge());
        i.setCarpet_area(propertyEntity.getCarpet_area());
        return  ps.save(i);



    }

    public Optional<PropertyEntity> propertySearch(Long propertySearchName) {
       return ps.findById(propertySearchName);
    }


    public List<PropertyEntity> findAllPropertyDetails() {
         return ps.findAll();
    }

    public void deleteProperty(Long id) {
        Optional<?>  opt = ps.findById(id);
        if(opt.isPresent())
        {
            ps.deleteById(id);
        }

    }


    public List<PropertyEntity> searchName(String name) {
        return ps.findByName(name);
    }



    public List<PropertyEntity> searchByAnyAttribute(Long id, String config, String location) {
//        Optional<PropertyEntity> opt = ps.findById(id);
//        ByteArrayResource resource = null;
//        if (opt.isPresent()) {
//            PropertyEntity oe = opt.get();
//            byte[] imageData = oe.getPropertyImage();
//            resource = new ByteArrayResource(imageData);
//
//        }
//        return (List<PropertyEntity>) ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=image.jpg")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource) + ps.finByAny(id, config, location);
return null
        ;

    }

    public void uploadImage(Long id, MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        PropertyEntity pe = new PropertyEntity();
        byte[] data= multipartFile.getBytes();
        Optional<PropertyEntity> opt = ps.findById(id);
            if(opt.isPresent()){opt.get();pe.setPropertyImage(data);}
        PropertyEntity i = new PropertyEntity();
        i.setPropertyImage(data);
    }
}
