package in.sp.bean.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import in.sp.bean.model.Student;
import in.sp.bean.model.Subject;
import in.sp.bean.repository.StudentRepository;

@Component
public class StudentService {
	
	@Autowired(required = true)
	private StudentRepository studentRepository;
	
	
	
	
	public void addStudent(Student sa)
	{
	
		
		this.studentRepository.save(sa);
		
	
	}
	
	
	public List<Student> getAllStudents()
	{
		
		List<Student>list=(List<Student>) studentRepository.findAll();
		return list;
	}
	
	
	public Student getStudentById(int id)
	{
	 Student stud=null;
	 List<Student> list=(List<Student>)  studentRepository.findAll();
		for (Student student : list) {
			if(student.getId()==id)
			{
				System.out.println(student.getId());
				System.out.println(student.getId()==id);
				
				return student;
			}
			
		}
		return stud;
	}

	
	 public void removeStudentById(int id)
		{
		 
		 List<Student> list=(List<Student>)  studentRepository.findAll();
			
			for (Student student : list) {
				
				if(student.getId()==id)
				{
					studentRepository.deleteById(id);
					break;
				}
				
				
			}
		}
	 
	 
	 
	 public void updateStudentByname(int id,String name )
		{
		 List<Student> list=(List<Student>)  studentRepository.findAll();
			for (Student student1 : list) {
				if(student1.getId()==id)
				{
					//studentRepository.deleteById(id);
					//student1.setId(id);
					student1.setName(name);
					//student1.setName(name);;
					list.add(student1);
					
					
					
					break;
					
				}
				
				
			}
			
		}
	 
	 
	
		




}
