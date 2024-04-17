package com.Incentro.MicroservicesUsers.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Incentro.MicroservicesUsers.Model.User;
import com.Incentro.MicroservicesUsers.Service.IncentroService;

@RestController
@RequestMapping("/user")
public class IncentroController {
	
	private final IncentroService incentroService;
	
	
	public IncentroController(IncentroService incentroService) 
	{
		this.incentroService = incentroService;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * GETTERS
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	/*
	 * Method that call getUserById
	 * @param id: param required to do the query finduserbyid
	 * @return object user related with given id
	 */

	@GetMapping("/userById")
	public User getUserById(@RequestParam String id) 
	{
		return incentroService.getUserById(id);
	}
	
	/*
	 * Method that call getAllUSers in incentroService
	 * @return a list with all the users
	 */
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers()
	{
		return this.incentroService.getAllUsers();
	}
	
	
	/*
	 * Method that call getAllUsersByName in IncentroService
	 * @param name : param asked to do the query
	 * @return a list with all the users with that name
	 */
	@GetMapping("/allUsersByName")
	public List<User> getAllUsersByName(@RequestParam String name)
	{
		return incentroService.getAllUsersByName(name);
	}
	
	/*
	 * Method that call getAllUsersByAddress in incentroService
	 * @param address: param asked to do query
	 * @return a list with all the users with that address
	 */
	
	@GetMapping("/allUsersByAddress")
	public List<User> getAllUsersByAddress(@RequestParam String address)
	{
		return incentroService.getAllUsersByAddress(address);
	}
	
	/*
	 * Method that call getAllUsersByLastName
	 * @param lastname: param asked to do the query
	 * @return a list with all users with that last name
	 */
	
	@GetMapping("/allUsersByLastName")
	public List <User> getAllUsersByLastName(@RequestParam String lastName)
	 {
		return incentroService.getAllUsersByLastName(lastName);
	 }
	
	/*
	 * Method that call getUserByDni
	 * @param dni: param asked to do the query
	 * @return user that have that dni or null with string if not found
	 */
	@GetMapping("/userByDni")
	public User getUserByDni(@RequestParam String dni) 
	{
		return incentroService.getUserByDni(dni);
	}
	
	/*
	 * Method that call getUserByphone
	 * @param phone: param asked to do the query
	 * @return user that have that phone or nill with string 
	 */
	
	@GetMapping("/userByPhone")
	public User getUserByPhone(@RequestParam String phone) 
	{
		return incentroService.getUserByPhone(phone);
		
	}
	
	/*
	 * Method that call getUsersbynameandlastname  that needs two params
	 * @param name: first param to do the request
	 * @param lastName: second param to do the request
	 * @return list of users based on the param sname and last name
	 */
	
	@GetMapping("/usersByNameAndLastName")
	public List<User> getUsersByNameAndLastName(@RequestParam String name, @RequestParam String lastName)
	{
		return incentroService.getUsersByNameAndLastName(name, lastName);
	}
	
	/*
	 * Method that vall getUserByEmail that use email param as paramter
	 * @param email: parar required to do the query
	 * @return User object related with email param
	 */
	
	@GetMapping("/userByEmail")
	public User getUserByEmail(@RequestParam String email) 
	{
		return incentroService.getUserByEmail(email);
	}
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * DELETE
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	/*
	 * method that call delete Function that required id to delete the user
	 * @param id: required to do the query
	 * @return string with ok or Ko
	 */
	
	
	@DeleteMapping("/deleteUserById")
	public String deleteUserById(@RequestParam String id) 
	{
		
		return incentroService.removeUserByid(id);
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * POST
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/*
	 * method that call post Function that required all USER properties from Model user.
	 * @param name: required to set the name of object user
	 * @param lastName: required to set the lastName oj object user
	 * @param dni: required to set the dni of object user
	 * @param phone= required to set the phone property of object user
	 * @param address: required to set the address property of object user
	 * @param email: required to set the email property of object user
	 * @return string with ok or Ko
	 */
	
	
	@PostMapping("/addUser")
	public String postUserMethod(@RequestParam String name, @RequestParam String lastName, @RequestParam String dni,
								@RequestParam String phone, @RequestParam String address, @RequestParam String email ) 
	{
		return incentroService.addUser(name, lastName, dni, phone, address, email);
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * PUT
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/*
	 * method that call put Function that required dni to find the user and address to edit the field
	 * @param dni: required to find the user in ddbb
	 * @param address: required to edit the address data
	 * @return string with ok or Ko
	 */
	@PutMapping("/editUserAddress")
	public String putUserAddress(@RequestParam String dni, @RequestParam String address) 
	{
		return incentroService.editUserByAddress(dni, address);
	}
	
	/*
	 * method that call put Function that required dni to find the user and phto edit the field
	 * @param dni: required to find the user in ddbb
	 * @param address: required to edit the address data
	 * @return string with ok or Ko
	 */
	@PutMapping("/editUserPhone")
	public String putUserPhone(@RequestParam String dni, @RequestParam String phone) 
	{
		return incentroService.editUserByPhone(dni, phone);
	}
	
	/*
	 * method that call put Function that required dni to find the user and email edit the field
	 * @param dni: required to find the user in ddbb
	 * @param email: required to edit the email data
	 * @return string with ok or Ko
	 */
	@PutMapping("/editUserEmail")
	public String putUserEmail(@RequestParam String dni, @RequestParam String email) 
	{
		return incentroService.editUserByEmail(dni, email);
	}
	
	

}
