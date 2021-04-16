package com.myfirstapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myfirstapp.model.User;

@RestController
@RequestMapping("/hello")
public class HelloWordController {

	// curl localhost:8080/hello/home -w "\n"
	// curl localhost:8080/hello -w "\n"
	@RequestMapping(value = { "", "/", "/home" }) // all are forword used for get request
	public String sayHello() {
		return "Hello From BHUSHAN!!!";
	}

	// curl localhost:8080/hello/query?name=bhushan -w "\n"
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name") String name) {
		return "Hello " + name + " !";
	}

	// curl localhost:8080/hello/param/bhushan -w "\n"
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello " + name + " !";
	}

	// curl -X POST -H "Content-Type: application/json" -d '{"firstName":
	// "BHUSHAN","lastName": "PATIL"}' "http://localhost:8080/hello/post"

	// curl -X POST -H "Content-Type: application/json" -d '{"firstName":
	// "BHUSHAN","lastName": "PATIL"}' "http://localhost:8080/hello/post" -w "\n"
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + " !";
	}

	// curl -X PUT localhost:8080/hello/put/BHUSH/?lastName=PATIL -w "\n"
	@PutMapping("/put/{firstName}")
	public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
		return "Hello " + firstName + " " + lastName + " !";
	}

}