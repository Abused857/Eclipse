package com.Incentro.MicroservicesUsers.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Incentro.MicroservicesUsers.Model.User;
import com.Incentro.MicroservicesUsers.Repository.UserRepository;

@Service
public class IncentroService {
	
	private final UserRepository userRepository;
	
	public IncentroService(UserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}
	
	//getters user table
	
	/*
	 * Method that calls findAllUsers
	 * @return list of all users
	 */
	
	public List <User> getAllUsers() 
	{
		return this.findAllUsers();
	}
	
	/*
	 * Method that calls findUserByName
	 * @param name: param to call findbyUserName function
	 * @return List of users found by a name
	 */
	public List <User> getAllUsersByName(String name)
	{
		return findUsersByName(name);
	}
	
	/*
	 *  Method that calls findUsersByAddress
	 * @param address: param to call findUsersByAddress function
	 * @return List of users found by address
	 */
	
	public List <User> getAllUsersByAddress(String address)
	{
		return findUsersByAddress(address);
	}
	
	
	/*
	 * Method that calls findUsersByLastName
	 * @param lastName: param to call findUsersByLastName function
	 * 
	 * @return List of user/users found wuth that lastName
	 */
	public List <User> getAllUsersByLastName(String LastName)
	{
		return findUsersByLastName(LastName);
	}
	
	/*
	 * Method that calls findUserByDni
	 * @param dni: param to call finduserbyDni function
	 * @return the user found values or string not found + user null object
	 */
	
	public User getUserByDni(String Dni)
	{
		return findUserByDni(Dni);
	}
	
	/*
	 * Method that calls findUserByPhone
	 * @param phone to call findUserByPhone function
	 * @return the user found values or string not found + user notfound string
	 */
	
	public User getUserByPhone(String phone) 
	{
		return findUserByPhone(phone);
	}
	
	/*
	 * Method that calls findUsersbynameandlastname that required two params
	 * @param name: first param used on the call
	 * @param lastName: second param used on the call
	 * @return the list with all users will be returned
	 */
	
	public List <User> getUsersByNameAndLastName(String name, String lastName)
	{
		return findUsersByNameAndLastName(name, lastName);
	}
	
	/*
	 * Method that calls findByUserEmail that required email param
	 * @param email: param used on the email search
	 * @return User info that match with email param
	 */
	
	public User getUserByEmail(String email) 
	{
		return findUserByEmail(email);
	}
	
	/*
	 * Method that calls findBYuser function
	 * @param id: used on search function
	 * @return object user with his info 
	 */
	
	public User getUserById(String id) 
	{
		return findUserById(id);
	}
	
	/*
	 * Method that calls delete user function
	 * @param id : used to find the user to delete
	 * @return string with ok or ko
	 */
	
	public String removeUserByid(String id) 
	{
		return deletedUserByIdMethod(id);
	}
	
	/*
	 * Method that calls postuserfunction that will validate each property provided and create or not the user
	 * @param name: required to create a new user
	 * @param lastName: required to create a new User
	 * @param dni: required to create a new User
	 * @param phone: required to create a new User
	 * @param address: required to create a new User
	 * @param email: required to create a new user
	 * @return string with the ko or ok
	 */
	
	public String addUser(String name, String lastName, String dni, String phone, String address, String email) 
	{
		return postUserFunction(name, lastName, dni, phone, address, email);
	}
	
	/*
	 * Method that calls editUserFunction using dni to find the user and address to edit
	 * @param dni: required to find the user that we want to update on ddbb
	 * @param address: required to edit that we want from the user found
	 * @return string with the ko or ok
	 */
	
	public String editUserByAddress(String dni, String address) 
	
	{
		return putUserAddressFunction(dni, address);
	}
	
	/*
	 * Method that calls editUserFunction using dni to find the user and phone to edit
	 * @param dni: required to find the user that we want to update on ddbb
	 * @param phone: required to edit that we want from the user found
	 * @return string with the ko or ok
	 */
	
	public String editUserByPhone(String dni, String phone) 
	
	{
		return putUserPhoneFunction(dni, phone);
	}
	
	/*
	 * Method that calls editEmailFunction using dni to find the user and email to edit
	 * @param dni: required to find the user that we want to update on ddbb
	 * @param email: required to edit that we want from the user found
	 * @return string with the ko or ok
	 */
	
	public String editUserByEmail(String dni, String email) 
	
	{
		return putUserEmailFunction(dni, email);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * FUNCTIONS
	 * 
	 * 
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
	 * Method that return a list with all the users
	 */
	private List<User> findAllUsers()
	{
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	/*
	 * @param name: defines the name that will do the search on bbdd
	 * @return List with all users that match with name param
	 */
	private List<User> findUsersByName(String name)
	{
		List <User>allUsers = findAllUsers();
		
		List <User> allUsersByName = new ArrayList<>();
		
		for(User user : allUsers) 
		{
			if (user.getName().equalsIgnoreCase(name)) {
				
				allUsersByName.add(user);
			}
		}
		
		return allUsersByName;
	}
	
	/*
	 * @param address: defines the addres that will do the search
	 * @return List with all users that contains address param
	 */
	
	private List <User> findUsersByAddress(String address)
	{
		List <User> allUsers = findAllUsers();
		
		List <User> allUsersByAddress = new ArrayList<>();
	
		for (User user : allUsers) {
			 if (user.getAddress().contains(address)) {
				 
				 allUsersByAddress.add(user);
				
			}
		}
		
		return allUsersByAddress;
	}
	
	
	/*
	 * @param lastName: defines the lastName that will do the search
	 * @return List with all users that equals with the lastName param
	 */
	private List<User> findUsersByLastName(String lastName)
	{
		List<User> allUsers = findAllUsers();
		
		List<User> allUsersByLastName = new ArrayList<>();
		
		for (User user : allUsers) {
			
			if (user.getLastName().equalsIgnoreCase(lastName)) {
				
				allUsersByLastName.add(user);	
			}
		}
		
		return allUsersByLastName;
	} 
	
	/*
	 * @param dni: defines the dni that will do the search
	 * @return If found it returnd the object User with properties userFound 
	 * if not found it returns the object user with null values and string saying not found
	 */
	
	private User findUserByDni(String dni)
	{
		List <User> allUsers = findAllUsers();
	
		User userFound = new User();
		
		for (User user : allUsers) {
			if (user.getDni() != null) {
				if (user.getDni().equalsIgnoreCase(dni)) {
					
					userFound = user;
					return userFound;
				}	
				
			}
			
		}
		
		

			return null;
		
	}
	
	/*
	 * @param phone defines the phone that will do the search
	 * @return if found it returns the object user-> userFound
	 * if not found it returns objecT User will null values and a string not found
	 */
	
	private User findUserByPhone(String phone) {
	    List<User> allUsers = findAllUsers();
	    
	    User userFound = null;  // Inicializar como null, no como un objeto nuevo

	    for (User user : allUsers) {
	        if (user.getPhone().equals(phone)) {
	            userFound = user; 
	            break; 
	        }
	    }

	    if (userFound == null) {
	        System.out.println("User not found");
	        return null; 
	    } else {
	        return userFound; 
	    }
	}

	
	/*
	 * @param name: defines the name that will do the search
	 * @param lastName defines the lastName that will do the search
	 * @return a list with all users that have the name and lastname used on search 
	 * (could be brothers working thats why list and not User)
	 */
	
	
	private List<User> findUsersByNameAndLastName(String name, String lastName)
	{
		List <User> allUsers = findAllUsers();
		
		List <User> allUsersByNameAndLastName = new ArrayList<>();
		
		for (User user : allUsers) {
			
			if (
					user.getName().equalsIgnoreCase(name) 
					
					&& 
					
					user.getLastName().equalsIgnoreCase(lastName)
				) 
				{
					allUsersByNameAndLastName.add(user);
				}
		}
		
		return allUsersByNameAndLastName;
	}
	
	/*
	 * @param email: defines the email that will do the search
	 * @return the User that has email param
	 */
	
	private User findUserByEmail(String email) 
	{
		List<User> allUsers = findAllUsers();
		
		User userEmail = new User();
		
		for (User user : allUsers) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				
				userEmail = user;
				
			}
		}
		return userEmail;
	}
	
	/*
	 * @param id : defines the id that will be uses to find a specific user
	 * @return object user with the values if an user was found
	 */
	
	private User findUserById(String id) 
	{
		List<User> allUsers = findAllUsers();
		
		User userId = new User ();
		
		for (User user : allUsers) {
			if (user.getId().equalsIgnoreCase(id)) {
				
				userId = user;
			}
		}
		return userId;
	}
	
	/*
	 * @param id: define the id related with the user that will be deleted
	 * @return String with Ok or KO
	 */
	
	private String deletedUserByIdMethod(String id)
	{
		if (id == null) {
			return null;
		}
		
		User userDeleted = userRepository.findById(id).orElse(null);
		
		if (userDeleted != null) 
		{
			userRepository.delete(userDeleted);
			return "User deleted correctly";
		}
		
			return "User not found";
		
	}
	
	/*
	 * Method that validate dni length and that dni letter calculated from numbers is equal to dni letter provided by user
	 * @param dni: dni provided to do the whole validation
	 * @return true if everything is correct or false if not
	 */
	
	private boolean validatorDni(String dni) {
	    if (dni == null || dni.length() != 9) {
	        return false; 
	    }
	    
	    int dniNumbers;
	    try {
	        dniNumbers = Integer.parseInt(dni.substring(0, 8));
	    } catch (NumberFormatException e) {
	        return false; 
	    }
	    
	    int rest = dniNumbers % 23;
	    String[] assignedLetter = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
	    String calculatedLetter = assignedLetter[rest];
	    String providedLetter = dni.substring(8);
	    
	    return calculatedLetter.equals(providedLetter);
	}


	
	/*
	 * Method that validates each property before create a new user on the ddbb 
	 * also calls validation dni function to be sure that the dni provided is correct
	 * @param name: required to create a new user
	 * @param lastName: required to create a new User
	 * @param dni: required to create a new User
	 * @param phone: required to create a new User
	 * @param address: required to create a new User
	 * @param email: required to create a new user
	 * @return true if each property passed the validation///false if not
	 */

	private boolean validatorPost(String name, String lastName, String dni, String phone, String address, String email) {
		
		User dniUser = new User();
		dniUser = findUserByDni(dni);
		
		if(dniUser.getDni() != null) {
			if (dniUser.getDni().equalsIgnoreCase(dni)) {
				System.out.println("Dni exists in bbdd");
				return false;
			}
		}
		
		
	
	    if (name == null || !name.matches("[a-zA-Z]+")) {
	    	System.out.println("Wrong name");
	        return false; 
	    }

	    if (lastName == null || !lastName.matches("[a-zA-Z]+")) {
	    	System.out.println("Wrong last name");
	        return false; 
	    }

	    
	    if (dni == null || !validatorDni(dni)) { 
	        System.out.println("Wrong dni");
	        return false; 
	    }


	   
	    if (phone == null || !phone.matches("\\d{9}")) {
	    	System.out.println("Wrong phone");
	        return false; 
	    }

	 

	    
	    if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
	    	System.out.println("Wrong email");
	        return false; 
	    }

	    return true; 
	}
	
	/*
	 * Method that after get the validation of each property create or no the new user
	 * UUID to string to asiggn random id to the user
	 * @param name: required to create a new user
	 * @param lastName: required to create a new User
	 * @param dni: required to create a new User
	 * @param phone: required to create a new User
	 * @param address: required to create a new User
	 * @param email: required to create a new user
	 * @return string with ko or ok depends if passed the validation and create or not the user
	 */

	private String postUserFunction(String name, String lastName, String dni, String phone, String address, String email) 
	{
		if(validatorPost(name, lastName, dni, phone, address, email)) 
		{
			String id = UUID.randomUUID().toString();
			
			User user = new User(id, name, lastName, dni, phone, address, email);
			
			userRepository.save(user);
			return "User added.";
		}else {return "User not added";}
	}
	
	/*
	 * Method update the address of an user on the ddbb
	 * @param dni: required to find the user that will be updated on ddbb
	 * @param address: the field that will be updated
	 * @return string with ko or ok if the user was updated or not in ddbb
	 */
	
	private String putUserAddressFunction(String dni, String address) 
	{
		
		User dniUser = new User();
		dniUser = findUserByDni(dni);
		String ok = "User updated correctly";
		String ko = "Cant update user settings";
		
		if(dniUser != null && dniUser.getDni().equals(dni)) 
		{
			dniUser.setAddress(address);
			userRepository.save(dniUser);
			return ok;
		}else {return ko;}
		
		
		
		
	}
	
	/*
	 * Method update the address of an user on the ddbb
	 * @param dni: required to find the user that will be updated on ddbb
	 * @param phone: the field that will be updated
	 * @return string with ko or ok if the user was updated or not in ddbb
	 */
	
	private String putUserPhoneFunction(String dni, String phone) 
	{
		
		User dniUser = new User();
		dniUser = findUserByDni(dni);

		
		String ok = "User phone updated correctly";
		String ko = "Cant update users phone";
		
		if (dniUser != null && dniUser.getDni().equals(dni)) {
			
			dniUser.setPhone(phone);
			userRepository.save(dniUser);
			return ok;
		}else {return ko;}
	}
	
	/*
	 * Method update the Email of an user on the ddbb
	 * @param dni: required to find the user that will be updated on ddbb
	 * @param email: the field that will be updated
	 * @return string with ko or ok if the user was updated or not in ddbb
	 */
	
	private String putUserEmailFunction(String dni, String email) 
	{
		User dniUser = new User();
		dniUser = findUserByDni(dni);
		
		String ok = "User email updated correctly";
		String ko = "Cant update users email";
		if (validatorEmail(email)) {
			if (dniUser != null && dniUser.getDni().equals(dni)) 
			{
				dniUser.setEmail(email);
				userRepository.save(dniUser);
				return ok;
				
			}else {return ko;}
			
		}else {return ko;}
		

	}
	
	/*
	 * Method that validates email property 
	 * @param email: the param that will be evaluated
	 * @return boolean true or false true if everything correct false if not
	 */
	
	private boolean validatorEmail(String email) {
	
	
		    
		    if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
		    	System.out.println("Wrong email");
		        return false; 
		    }
	
		    return true; 
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
