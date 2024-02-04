package com.example.demo;

import java.time.LocalDate;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Salary_Service {

	@Autowired
	TimeSheet_Repo trs;
	
	@Autowired
	Salary_Repo srs;
	
	@Autowired
	PayChart_Repo prs;
	
	 LocalDate currentDate = LocalDate.now();

     // Get the current month as a number
     int month = currentDate.getMonthValue();
	
	 int year = currentDate.getYear();
     
     // Create a YearMonth instance for the specified year and month
     YearMonth yearMonth = YearMonth.of(year, month);
     
     // Get the first day of the month
     LocalDate firstDayOfMonth = yearMonth.atDay(1);
     
     // Get the last day of the month
     LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();
	
	public int findNoOfDays(int emp_id) {
		return trs.findByEmployeeIdAndDateBetween(emp_id,firstDayOfMonth,lastDayOfMonth);
	}
	
}
