package xyz.nuti.rest.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nuti.rest.dao.EmployeeDAO;
import xyz.nuti.rest.exception.EmployeeNotFoundException;
import xyz.nuti.rest.exception.IncorrectedParameterException;
import xyz.nuti.rest.service.EmployeeService;
import xyz.nuti.rest.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public Collection<EmployeeVO> getAllEmployeeList() throws EmployeeNotFoundException {
		Collection<EmployeeVO> employeeList = employeeDAO.getAllEmployeeList();
		
		if (employeeList == null || employeeList.size() == 0) {
			throw new EmployeeNotFoundException();
		}
		
		return employeeList;
	}
	
	@Override
	public Collection<EmployeeVO> searchEmployeeByName(String name) throws IncorrectedParameterException, EmployeeNotFoundException {
		if (name == null || name.equals("")) {
			throw new IncorrectedParameterException(name);
		}
		
		Collection<EmployeeVO> employeeList = employeeDAO.searchEmployeeByName(name);
		
		if (employeeList == null || employeeList.size() == 0) {
			throw new EmployeeNotFoundException(name);
		}
		
		return employeeList;
	}
	
}