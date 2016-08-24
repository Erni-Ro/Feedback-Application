package ro.erni.java.training.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {

	private IntegerProperty id;
	private StringProperty username;
	private StringProperty password;
	private StringProperty email;
	private StringProperty firstName;
	private StringProperty lastName;
	private IntegerProperty idSubsidiary;
	private IntegerProperty idFunction;

	public Employee() {
		super();
	}

	public Employee(String username, String password) {
		super();
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
	}

	public Employee(int id, String username, String password, String email, String firstName, String lastName,
			int idSubsidiary, int idFunction) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.email = new SimpleStringProperty(email);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.idSubsidiary = new SimpleIntegerProperty(idSubsidiary);
		this.idFunction = new SimpleIntegerProperty(idFunction);
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	public StringProperty usernameProperty() {
		return username;
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public StringProperty passwordProperty() {
		return password;
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public StringProperty emailProperty() {
		return email;
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public int getIdSubsidiary() {
		return idSubsidiary.get();
	}

	public void setIdSubsidiary(int idSubsidiary) {
		this.idSubsidiary.set(idSubsidiary);
	}

	public IntegerProperty idSubsidiaryProperty() {
		return idSubsidiary;
	}

	public int getIdFunction() {
		return idFunction.get();
	}

	public void setIdFunction(int idFunction) {
		this.idFunction.set(idFunction);
	}

	public IntegerProperty idFunctionProperty() {
		return idFunction;
	}

}
