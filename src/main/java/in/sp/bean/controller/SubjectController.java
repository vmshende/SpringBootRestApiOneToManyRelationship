package in.sp.bean.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.sp.bean.model.Subject;
import in.sp.bean.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired(required = true)
	private SubjectService subjectService;
	
	//get All Subjects
			@GetMapping("/subjects")
			public ResponseEntity<List<Subject>>  fetchAllStudents()
			{
				
				List<Subject> subjects=subjectService.getAllSubjects();
				if(subjects.isEmpty())
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return ResponseEntity.of(Optional.of(subjects));
				
				
			}
			
			
			
			//Insert subject
			@PostMapping("/subjects")
			public ResponseEntity<Void> insertsubject(@RequestBody Subject subject) {
				
			try {
			
				subjectService.addSubject(subject);
			 return	ResponseEntity.status(HttpStatus.CREATED).build();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
				
			}
			

}
