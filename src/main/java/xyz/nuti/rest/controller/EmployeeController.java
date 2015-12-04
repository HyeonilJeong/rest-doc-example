package xyz.nuti.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.nuti.rest.common.RestfulResponseBody;
import xyz.nuti.rest.exception.EmployeeNotFoundException;
import xyz.nuti.rest.exception.IncorrectedParameterException;
import xyz.nuti.rest.service.EmployeeService;
import xyz.nuti.rest.vo.EmployeeVO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/allEmployeeList", method = RequestMethod.GET)
	public ResponseEntity<? extends RestfulResponseBody> allEmployeeList() {
		RestfulResponseBody body = new RestfulResponseBody();
		ResponseEntity<RestfulResponseBody> responseEntity = null;
		HttpStatus httpStatus = null;
		
		try {
			Collection<EmployeeVO> employeeList = employeeService.getAllEmployeeList();
			
			body.setMessage("ok");
			body.put("employeeList", employeeList);
			httpStatus = HttpStatus.OK;
		} catch (EmployeeNotFoundException e) {
			body.setMessage(e.getMessage());
			httpStatus = HttpStatus.NOT_FOUND;
		}

		responseEntity = new ResponseEntity<RestfulResponseBody>(body, httpStatus);

		return responseEntity;
	}
	
	@RequestMapping(value = "/searchEmployeeByName", method = RequestMethod.GET)
	public ResponseEntity<? extends RestfulResponseBody> searchEmployeeByName(@RequestParam("name") String name) {
		RestfulResponseBody body = new RestfulResponseBody();
		ResponseEntity<RestfulResponseBody> responseEntity = null;
		HttpStatus httpStatus = null;

		try {
			Collection<EmployeeVO> employeeList = employeeService.searchEmployeeByName(name);
			
			body.setMessage("ok");
			body.put("employeeList", employeeList);
			httpStatus = HttpStatus.OK;
		} catch (IncorrectedParameterException e) {
			body.setMessage(e.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;
		} catch (EmployeeNotFoundException e) {
			body.setMessage(e.getMessage());
			httpStatus = HttpStatus.NOT_FOUND;
		}

		responseEntity = new ResponseEntity<RestfulResponseBody>(body, httpStatus);

		return responseEntity;
	}
}
