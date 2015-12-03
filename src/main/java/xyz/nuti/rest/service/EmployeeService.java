package xyz.nuti.rest.service;

import java.util.Collection;

import xyz.nuti.rest.exception.EmployeeNotFoundException;
import xyz.nuti.rest.exception.IncorrectedParameterException;
import xyz.nuti.rest.vo.EmployeeVO;

public interface EmployeeService {
	Collection<EmployeeVO> getAllEmployeeList() throws EmployeeNotFoundException;
	Collection<EmployeeVO> searchEmployeeByName(String name) throws IncorrectedParameterException, EmployeeNotFoundException;
}
