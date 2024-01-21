package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_Repo extends JpaRepository<Employee, Integer> 
{
	@Query("select e from Employee e where e.email_id = :email")
	Optional<Employee> findByEmail(String email);
	
	
//	@Query("SELECT e FROM Employee e WHERE " +
//	        "(:designation IS NULL OR LOWER(e.designation) LIKE CONCAT('%', LOWER(:query), '%'))")
//	List<Employee> searchEmployees(@Param("designation") String designation, @Param("query") String query);

}
