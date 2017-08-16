package com.topjavatutorial;
 
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;	
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
 
import com.topjavatutorial.dao.Employee;
import com.topjavatutorial.dao.EmployeeDAO;
 
 
@Path("/employees")
public class MyResource {
 
    @GET
    @Path("/all")
    @Consumes("application/json")
    @Transactional
    //@Produces( MediaType.APPLICATION_JSON )
    public List<Employee> getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getEmployees();
        return employees;
    }
    @GET
    @Path("/test")
    @Consumes("application/json")
    @Transactional
    //@Produces( MediaType.APPLICATION_JSON )
    public String testThis() {
        //EmployeeDAO dao = new EmployeeDAO();
        String employees = "a";
        return employees;
    }
    
    @POST
    @Path("/create")
    @Consumes("application/json")
    @Transactional
    public Response addEmployee(Employee emp){
        emp.setName(emp.getName());
        emp.setAge(emp.getAge());
                
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    @Transactional
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    @Transactional
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
