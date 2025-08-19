package com.cognizant.students.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.students.entities.Address;
import com.cognizant.students.entities.Student;
import com.cognizant.students.entities.Subject;
import com.cognizant.students.model.StudentRequest;
import com.cognizant.students.model.SubjectRequest;
import com.cognizant.students.repository.AddressRepository;
import com.cognizant.students.repository.StudentRepository;
import com.cognizant.students.repository.SubjectRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Student> getAllStudents () {
		return studentRepository.findAll();
	}
	
	public String getFirstNameById (long id) {
		return studentRepository.findById(id).get().getFirstName();
	}
	
	public String getLastNameById (long id) {
		return studentRepository.findById(id).get().getLastName();
	}
	
	public Student createStudent (StudentRequest studentRequest) {
		Student student = new Student();
		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
		student.setEmail(studentRequest.getEmail());
		
		Address address = new Address();
		address.setStreet(studentRequest.getStreet());
		address.setCity(studentRequest.getCity());
		
		address = addressRepository.save(address);
		
		student.setAddress(address);
		student = studentRepository.save(student);
		
		List<Subject> subjectsList = new ArrayList<Subject>();
		
		if(studentRequest.getSubjectsLearning() != null) {
			for (SubjectRequest subjectRequest : studentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(subjectRequest.getSubjectName());
				subject.setMarksObtained(subjectRequest.getMarksObtained());
				subject.setStudent(student);
				
				subjectsList.add(subject);
			}
			
			subjectRepository.saveAll(subjectsList);
			
		}
		
		student.setLearningSubjects(subjectsList);
		
		return student;
	}
	
}

