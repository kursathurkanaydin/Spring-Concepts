package com.kha.studentdemo.repository;

import com.kha.studentdemo.entity.Student;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
