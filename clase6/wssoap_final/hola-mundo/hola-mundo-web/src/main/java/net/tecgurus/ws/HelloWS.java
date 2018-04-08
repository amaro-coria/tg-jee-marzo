package net.tecgurus.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWS {

	@WebMethod
	public String hello(String name) {
		return "Hello world :"+name;
	}
	
}
