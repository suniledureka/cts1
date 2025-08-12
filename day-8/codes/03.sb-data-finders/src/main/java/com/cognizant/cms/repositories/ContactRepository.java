package com.cognizant.cms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.entities.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Integer> {

	Optional<Contact> findByContactName(String cname);

	Contact findByContactNumber(String cno);
	
	Optional<Contact> findByContactNameAndContactNumber(String cname, String cno);
	
	List<Contact> findByContactNameOrContactNumber(String cname, String cno);
	
	//@Query("select contactName from com.cognizant.cms.entities.Contact") //HQL - Hibernate Query Language
	//@Query(value = "select contactName from com.cognizant.cms.entities.Contact") //HQL - Hibernate Query Language
	@Query(value = "select CONTACT_NAME from CONTACT_MASTER", nativeQuery = true) //native query
	List<String> findAllContactName();
	
	//@Query("from com.cognizant.cms.entities.Contact where contactName=?1") //positional parameters
	//@Query("from com.cognizant.cms.entities.Contact where contactName=:cname") //named parameters
	//@Query("select ct from com.cognizant.cms.entities.Contact ct where contactName = :cname")
	@Query(value = "select * from CONTACT_MASTER where CONTACT_NAME=:cname", nativeQuery = true) //SQL - native query
	Optional<Contact> findByCntName(String cname);
	
	@Query("select ct from com.cognizant.cms.entities.Contact ct where contactName LIKE :cnameLike%")
	List<Contact> findContactsWhereNamesWith(String cnameLike);
}
