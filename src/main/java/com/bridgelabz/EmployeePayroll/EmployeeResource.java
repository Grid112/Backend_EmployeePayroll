package com.bridgelabz.EmployeePayroll;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {

	EmployeeDao dao = new EmployeeDao();
	
	//To Get All The Employees Available
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Employee> getEmployees() {

		System.out.println("Employee Available...");

		return dao.getEmployees();
	}
	
	//To Get An Employee Using Id
	@GET
	@Path("employee/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Employee getEmployee(@PathParam("id") int id) {

		return dao.getEmployee(id);
	}
	
	//To Create Table For New Employee
	@POST
	@Path("employee")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Employee createEmployee(Employee e1) {

		System.out.println(e1);
		dao.create(e1);
		return e1;
	}
	
	//To Update Employee Data
	@PUT
	@Path("employee")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Employee updateEmployee(Employee e1) {

		System.out.println(e1);
		if (dao.getEmployee(e1.getId()).getId() == 0) {
			dao.create(e1);
		} else {
			dao.update(e1);
		}
		return e1;
	}
	
	
	//To Delete Employee Using Id
	@DELETE
	@Path("employee/{id}")
	public Employee killEmployee(@PathParam("id") int id) {
		
		Employee e = getEmployee(id);
		
		if(e.getId() !=0) {
		dao.delete(id);
		}
		return e;
	}
	
	

}
