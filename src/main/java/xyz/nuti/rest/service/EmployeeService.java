package xyz.nuti.rest.service;

import java.util.Collection;

import xyz.nuti.rest.vo.EmployeeVO;

public interface EmployeeService {
	Collection<EmployeeVO> getAllEmployeeList();
}
