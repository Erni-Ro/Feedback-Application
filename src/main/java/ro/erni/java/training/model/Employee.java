package ro.erni.java.training.model;

public class Employee {

	private int id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String function;
	private String city;
    
	
	public Employee() {
		super();
	}
	
	
	public Employee(int id, String username, String password, String email, String firstName, String lastName,
			String city, String function) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.function = function;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getFunction() {
		return function;
	}


	public void setFunction(String function) {
		this.function = function;
	}


	@Override
	public String toString() {
		return id + " " + firstName + " " + lastName;
	}

}
