package com.cognizant.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.data.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
