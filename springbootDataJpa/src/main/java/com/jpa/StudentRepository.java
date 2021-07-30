package com.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trg.student.data.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{

}
