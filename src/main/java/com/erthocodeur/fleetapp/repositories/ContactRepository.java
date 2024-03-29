package com.erthocodeur.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erthocodeur.fleetapp.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
