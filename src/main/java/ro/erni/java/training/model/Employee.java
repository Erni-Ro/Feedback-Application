package ro.erni.java.training.model;

public class Employee {

	private int id;
	private String username;
	private String password; // TODO this must be encoded
	private String email;
	private String firstName;
	private String lastName;
	private int id_subsidiary;
	private int id_function;

	public Employee(int ID, String userName, String pass, String em, String fName, String lName, int id_sub,
			int id_func) {
		this.id = ID;
		this.username = userName;
		this.password = pass;
		this.email = em;
		this.firstName = fName;
		this.lastName = lName;
		this.id_subsidiary = id_sub;
		this.id_function = id_func;
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

	public int getId_subsidiary() {
		return id_subsidiary;
	}

	public void setId_subsidiary(int id_subsidiary) {
		this.id_subsidiary = id_subsidiary;
	}

	public int getId_function() {
		return id_function;
	}

	public void setId_function(int id_function) {
		this.id_function = id_function;
	}

}
