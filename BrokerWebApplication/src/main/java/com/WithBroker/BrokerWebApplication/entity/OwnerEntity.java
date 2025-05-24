package com.WithBroker.BrokerWebApplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class OwnerEntity {

    @Id
    Long id;
    String name;
    String email;
    Long contact;
    @OneToOne
    AddressEntity address;

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
    }

    @OneToMany
    List<PropertyEntity> properties;
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
