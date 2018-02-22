package com.qa.Integration;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.repository.DBService;


@Path("/account")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class AccountEndpoint {
	
	@Inject
	DBService dbServ;
	
	@Path("/json")
	@GET
	public String getAccounts() {
		return dbServ.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({"Application/JSON"})
	public String addAccount(String accnt) {
		return dbServ.createAccount(accnt);
	}
	
	@Path("/json/{i}")
	@GET
	public String findAccount(@PathParam("i") Long id) {
		return dbServ.findAnAccount(id);
	}
	@Path("/json/{i}")
	@PUT
	@Produces({"Application/JSON"})
	public String updateAccount(@PathParam("i") Long id, String value) {
		return dbServ.updateAccount(id, value);
	}
	@Path("/json/{i}")
	@DELETE
	@Produces({"Application/JSON"})
	public String deleteAccount(@PathParam("i") Long id) {
		return dbServ.deleteAccount(id);
	}
}
