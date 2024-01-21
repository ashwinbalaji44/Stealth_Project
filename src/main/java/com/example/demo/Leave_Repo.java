package com.example.demo;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Leave_Repo extends JpaRepository<Leave, Integer> {

	
//	@Query("select l from Leaves l where l.emp_emp_id = :empid ")
//	public Optional <List<Leave>> viewAllLeaves(@Param("empid") int empid);
	
	@Query("SELECT l FROM Leave l WHERE l.emp.emp_id = :emp_id")
	public List<Leave> viewAllLeaves(@Param("emp_id") int emp_id);
	
	@Query("SELECT l FROM Leave l WHERE l.leave_id = :lid and l.leave_status= 'awaiting approval'")
	public Leave setLeaveStatus(@Param("lid") int lid);
	
	

	

}
