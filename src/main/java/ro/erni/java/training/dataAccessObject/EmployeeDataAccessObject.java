package ro.erni.java.training.dataAccessObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.model.Employee;

public class EmployeeDataAccessObject {
	private JdbcTemplate jdbcTemplate;
	private File file;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean isEmployeeInDb(String username, String password) throws SQLException {
		String query = "select username from employee where username=? and password=?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.executeQuery();
			}
		};

		List<Employee> listContact = this.jdbcTemplate.query(query, setter, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				List<Employee> list = new ArrayList<Employee>();
				Employee e = new Employee();
				while (rs.next()) {
					e.setUsername(rs.getString(1));
					e.setPassword(rs.getString(2));
					list.add(e);
				}
				return e;
			}

		});

		return listContact.size() > 0;
	}

	public boolean saveFeedback(String question, String answer, Boolean anonym) throws IOException, SerialException, SQLException {

		File file = writeData(question,answer);
		FileInputStream  in =  new FileInputStream(file);
		PreparedStatementCallback<Boolean> setter = new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement preparedStatement)
					throws SQLException, DataAccessException {
				preparedStatement.setBinaryStream(1, in, (int) file.length());
				preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
				preparedStatement.setBoolean(3, anonym);
				return preparedStatement.execute();
			}
		};

		String query = "insert into qa(qa, timestamp,anonym) values(?, ?, ?)";
		return this.jdbcTemplate.execute(query, setter);
	}

	public File writeData(String question, String answer ) {
		try {
			if (!answer.isEmpty()) {
				String content = question + "\n" + answer;

				this.file = File.createTempFile("Feedback", ".txt");

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.getDialogPane().setPrefSize(250, 120);
				alert.getDialogPane().setMinSize(250, 120);
				alert.setY(MainApp.primaryStage.getY() + MainApp.primaryStage.getHeight() / 2
						- alert.getDialogPane().getPrefHeight() / 2);
				alert.setX(MainApp.primaryStage.getX() + MainApp.primaryStage.getWidth() / 2
						- alert.getDialogPane().getPrefWidth() / 2);
				alert.setTitle("Invalid QA");
				alert.setHeaderText("Answer not submitted");
				alert.showAndWait();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;

	}
	
	

}
