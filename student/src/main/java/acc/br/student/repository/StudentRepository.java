package acc.br.student.repository;

import org.springframework.data.repository.CrudRepository;

import acc.br.student.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}

