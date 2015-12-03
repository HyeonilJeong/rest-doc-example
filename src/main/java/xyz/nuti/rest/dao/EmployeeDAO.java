package xyz.nuti.rest.dao;

import java.util.Collection;

import xyz.nuti.rest.vo.EmployeeVO;

public interface EmployeeDAO {
	Collection<EmployeeVO> getAllEmployeeList();
	Collection<EmployeeVO> searchEmployeeByName(String name);
}
