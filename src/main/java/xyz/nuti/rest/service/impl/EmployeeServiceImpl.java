package xyz.nuti.rest.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nuti.rest.dao.EmployeeDAO;
import xyz.nuti.rest.service.EmployeeService;
import xyz.nuti.rest.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public Collection<EmployeeVO> getAllEmployeeList() {
		return employeeDAO.getAllEmployeeList();
	}
	
}