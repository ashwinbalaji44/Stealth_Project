package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Leave_Service {
	@Autowired
	Leave_Repo lr;

	public String approveleave(int lid) {
		// TODO Auto-generated method stub
		Leave l=lr.setLeaveStatus(lid);
		l.setLeave_status("Approved");
		lr.save(l);
		return "Approved Leave for Employee:"+l.getEmp().getEmp_id();
	}
	
	public String denyleave(int lid) {
		// TODO Auto-generated method stub
		Leave l=lr.setLeaveStatus(lid);
		l.setLeave_status("Rejected");
		lr.save(l);
		return "Denied Leave for Employee:"+l.getEmp().getEmp_id();
	}
	
	
}
