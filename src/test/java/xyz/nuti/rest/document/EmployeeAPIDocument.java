package xyz.nuti.rest.document;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context-configuration/*-context.xml" })
@WebAppConfiguration
public class EmployeeAPIDocument extends WebMvcConfigurerAdapter {

	@Rule
	public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets");

	@Autowired
	protected WebApplicationContext context;

	protected MockMvc mockMvc;

	@Before
	public void setUp() {
		// @formatter:off
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.defaultRequest(get("/").contextPath("/rest-doc-example"))
				.apply(
					documentationConfiguration(this.restDocumentation)
					.uris()
					.withScheme("http")
					.withHost("your.domain.com")
					.withPort(80)
				).build();
		// @formatter:on
	}

	@Test
	public void getAllEmployeeExample() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/rest-doc-example/employee/allEmployeeList"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("data.employeeList", is(notNullValue())))
			.andDo(document("all_employee_list",
				responseFields(
					fieldWithPath("message").type(JsonFieldType.STRING).description("message"),
					fieldWithPath("data").type(JsonFieldType.OBJECT).description("data object"),
					fieldWithPath("data.employeeList").type(JsonFieldType.ARRAY).description("employee list"),
					fieldWithPath("data.employeeList[].employeeNo").type(JsonFieldType.NUMBER).description("unique number of employee"),
					fieldWithPath("data.employeeList[].name").type(JsonFieldType.STRING).description("employee name"),
					fieldWithPath("data.employeeList[].dept").type(JsonFieldType.STRING).description("employee department"),
					fieldWithPath("data.employeeList[].age").type(JsonFieldType.NUMBER).description("employee age")
				)
			));
		// @formatter:on
	}

	@Test
	public void getSearchEmployeeByNameExample() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/rest-doc-example/employee/searchEmployeeByName?name=el"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("data.employeeList", is(notNullValue())))
			.andDo(document("search_employee_by_name",
				requestParameters(
					parameterWithName("name").description("some letters of the name")
				),
				responseFields(
					fieldWithPath("message").type(JsonFieldType.STRING).description("message"),
					fieldWithPath("data").type(JsonFieldType.OBJECT).description("data object"),
					fieldWithPath("data.employeeList").type(JsonFieldType.ARRAY).description("employee list"),
					fieldWithPath("data.employeeList[].employeeNo").type(JsonFieldType.NUMBER).description("unique number of employee"),
					fieldWithPath("data.employeeList[].name").type(JsonFieldType.STRING).description("employee name"),
					fieldWithPath("data.employeeList[].dept").type(JsonFieldType.STRING).description("employee department"),
					fieldWithPath("data.employeeList[].age").type(JsonFieldType.NUMBER).description("employee age")
				)
			));
		// @formatter:on
	}
}
