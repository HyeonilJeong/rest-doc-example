package xyz.nuti.rest.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import xyz.nuti.rest.dao.EmployeeDAO;
import xyz.nuti.rest.vo.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public Collection<EmployeeVO> getAllEmployeeList() {
		Collection<EmployeeVO> employeeList = initialEmployeeList();
		
		return employeeList;
	}
	
	public Collection<EmployeeVO> initialEmployeeList() {
		Collection<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		
		employeeList.add(new EmployeeVO(1, "mike", "development", 30));
		employeeList.add(new EmployeeVO(2, "jhone", "design", 35));
		employeeList.add(new EmployeeVO(3, "angela", "management", 34));
		employeeList.add(new EmployeeVO(4, "elssa", "design", 25));
		employeeList.add(new EmployeeVO(5, "emma", "design", 41));
		employeeList.add(new EmployeeVO(6, "lucy", "management", 27));
		employeeList.add(new EmployeeVO(7, "aron", "development", 35));
		employeeList.add(new EmployeeVO(8, "helen", "development", 48));
		employeeList.add(new EmployeeVO(9, "adam", "development", 28));
		employeeList.add(new EmployeeVO(10, "mary", "design", 27));
		
		return employeeList;
	}
}
