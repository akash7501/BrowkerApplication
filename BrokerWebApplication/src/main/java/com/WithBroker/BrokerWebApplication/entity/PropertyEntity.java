package com.WithBroker.BrokerWebApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class PropertyEntity {
    @Id
    Long id;

    String name;
    String config;
    String aminities;
    Double salePrice;
    Double renalPrice;
    Long PropertyAge;
    Double carpet_area;

    public byte[] getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(byte[] propertyImage) {
        this.propertyImage = propertyImage;
    }

    @Lob
    byte[] propertyImage;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        config = config;
    }

    public String getAminities() {
        return aminities;
    }

    public void setAminities(String aminities) {
        this.aminities = aminities;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getRenalPrice() {
        return renalPrice;
    }

    public void setRenalPrice(Double renalPrice) {
        this.renalPrice = renalPrice;
    }

    public Long getPropertyAge() {
        return PropertyAge;
    }

    public void setPropertyAge(Long propertyAge) {
        PropertyAge = propertyAge;
    }

    public Double getCarpet_area() {
        return carpet_area;
    }

    public void setCarpet_area(Double carpet_area) {
        this.carpet_area = carpet_area;
    }


}
