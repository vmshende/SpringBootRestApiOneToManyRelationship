package in.sp.bean.repository;

import org.springframework.data.repository.CrudRepository;

import in.sp.bean.model.Student;

public interface StudentRepository  extends CrudRepository<Student, Integer>{

}
