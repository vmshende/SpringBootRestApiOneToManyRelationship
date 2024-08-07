package in.sp.bean.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.sp.bean.model.Student;
import in.sp.bean.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired(required = true)
	private StudentService studentService;
	
	
	//Insert student
	@PostMapping("/students")
	public ResponseEntity<Void> insertStudent(@RequestBody Student student) {
		
	try {
		studentService.addStudent(student);
	 return	ResponseEntity.status(HttpStatus.CREATED).build();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
	}
	
	
	
	//get All Students
		@GetMapping("/students")
		public ResponseEntity<List<Student>>  fetchAllStudents()
		{
			
			List<Student> students=studentService.getAllStudents();
			if(students.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(students));
			
			
		}
		
		
		//Get Single Student Handler
		@GetMapping("/student/{id}")
		public ResponseEntity<Student>  fetchStudentById(@PathVariable("id")int id1)
		{
			
			Student student=studentService.getStudentById(id1);
			if(student==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			return ResponseEntity.of(Optional.of(student));
		}
		
		
		//Delete Student handler
				@DeleteMapping("/student/{id}")
				public ResponseEntity<Void> clearById(@PathVariable("id") int userId)
				{
					try {
					
						studentService.removeStudentById(userId);
						 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					} catch (Exception e) {
						e.printStackTrace();
						 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
						// TODO: handle exception
					}
				}
		
			
				

				// Updating Book Handler
				@PutMapping("/student/{id}/{name}")
				public ResponseEntity<Void>  updateAuthor(@PathVariable("id") int userid, @PathVariable("name") String username)
				{
					try {
						System.out.println(userid);
						System.out.println(username);
						studentService.updateStudentByname(userid, username);
						return ResponseEntity.status(HttpStatus.OK).build();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					}
					
				}
				
			
	
	

}
