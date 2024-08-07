package in.sp.bean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.sp.bean.model.Student;
import in.sp.bean.model.Subject;
import in.sp.bean.repository.SubjectRepository;

@Component
public class SubjectService {
	
	@Autowired(required = true)
	private SubjectRepository subjectRepository;
	
	public List<Subject> getAllSubjects()
	{
		
		
		List<Subject>list=(List<Subject>) subjectRepository.findAll();
		return list;
	}
	
	
	public void addSubject(Subject s)
	{
	
		
		this.subjectRepository.save(s);
		
	
	}

}
