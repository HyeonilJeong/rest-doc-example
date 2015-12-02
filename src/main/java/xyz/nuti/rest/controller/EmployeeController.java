package xyz.nuti.rest.controller;

import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.nuti.rest.common.RestfulResponseBody;
import xyz.nuti.rest.service.EmployeeService;
import xyz.nuti.rest.vo.EmployeeVO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/allEmployeeList", method = RequestMethod.GET)
	public ResponseEntity<? extends RestfulResponseBody> home(Locale locale, Model model) {
		RestfulResponseBody body = new RestfulResponseBody();
		ResponseEntity<RestfulResponseBody> responseEntity = null;
		HttpStatus httpStatus = null;
		
		Collection<EmployeeVO> employeeList = employeeService.getAllEmployeeList();
		
		if (employeeList == null) {
			body.setMessage("not found");
			httpStatus = HttpStatus.NOT_FOUND;
		} else if (employeeList.size() == 0) {
			body.setMessage("not found");
			httpStatus = HttpStatus.NOT_FOUND;
		} else {
			body.setMessage("ok");
			body.put("employeeList", employeeList);
			httpStatus = HttpStatus.OK;
		}
		
		responseEntity = new ResponseEntity<RestfulResponseBody>(body, httpStatus);

		return responseEntity;
	}
}
