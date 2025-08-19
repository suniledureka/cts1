package com.cognizant.data;

import java.nio.file.Path;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.data.entities.Address;
import com.cognizant.data.entities.Employee;
import com.cognizant.data.repositories.AddressRepository;
import com.cognizant.data.repositories.EmployeeRepository;

@SpringBootApplication
@RestController
@RequestMapping(path = "/api/v1/ems")
public class SbDataOtoApplication{
	private EmployeeRepository employeeRepo;
	private AddressRepository addressRepo;
	
	
	public SbDataOtoApplication(EmployeeRepository employeeRep, AddressRepository addressRepo) {
		super();
		this.employeeRepo = employeeRep;
		this.addressRepo = addressRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SbDataOtoApplication.class, args);
	}

	@PostMapping
	public ResponseEntity<?> saveEmployeeAndaddress(@RequestBody Employee emp) {
		Employee savedEmployee = employeeRepo.save(emp);
		if(savedEmployee != null) {
			return new ResponseEntity<String>("employee saved", HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest().build();
		/*
		Optional<Employee> optEmp = employeeRepo.findById(1);
		boolean isPresent = optEmp.isPresent();
		if(isPresent) {
			emp = optEmp.get();
			System.out.println(emp.getEmployeeId() + " - " + emp.getEmployeeName());
			System.out.println(emp.getEmployeeAddress().getAdddressId()+" - "+ emp.getEmployeeAddress().getStreet());
			
			System.out.println(emp);
		}
	
		employeeRepo.deleteById(2);
		*/
	}

	@GetMapping
	public ResponseEntity<?> getEmployeeById(@RequestParam("eid") Integer eid){
		Optional<Employee> optEmp = employeeRepo.findById(eid);
		boolean isPresent = optEmp.isPresent();
		if(isPresent) {
			Employee emp = optEmp.get();
			return ResponseEntity.ok().body(emp);
		}
		return ResponseEntity.notFound().build();
	}
}
