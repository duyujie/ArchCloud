package com.yujiedu.service.poc;

import java.util.List;

import com.yujiedu.orm.poc.PocDep;
import com.yujiedu.orm.poc.PocEmp;

public interface IPocEmployeeService  {
	PocDep getDepartment(String depName);

	PocEmp getEmployee(String employeeNo);

	String createEmployee(PocEmp emp);

	List<PocEmp> findAllEmpployees();

	int updateEmployee(PocEmp emp);

	int deleteEmployee(String employeeNo);

	int deleteAllEmployees();

	void generatePocReport();
}
