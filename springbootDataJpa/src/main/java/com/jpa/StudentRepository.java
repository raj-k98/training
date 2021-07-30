package com.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trg.student.data.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Integer>{

}
