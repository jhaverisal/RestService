package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test2")
public class FirstRest {
	
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStud() {
		
		DBConnection db=new DBConnection();
		List<Student> students=db.getAllStudents();
		GenericEntity<List<Student>> newList=new GenericEntity<List<Student>>(students) {};
		return Response.ok(newList).build();
		
	}
	
	@Path("/msg")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String message() {
		
		return "hard coded msg";
	}
	
	}
	
	

