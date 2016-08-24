package ro.erni.java.training.dataAccessObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class WriteFeedbackDataAccessObject {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveFeedback() throws FileNotFoundException {
		File blob = new File("a1.txt");
		File blob2 = new File("q1.txt");
		FileInputStream in = new FileInputStream(blob);
		FileInputStream in2 = new FileInputStream(blob);
		
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setBinaryStream(1, in , (int) blob.length());
				preparedStatement.setBinaryStream(2, in2 , (int) blob2.length());
				preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				preparedStatement.executeQuery();
			}
		};
		String query = "insert into qa(question, answer, timestamp) values(?, ?, ?)";
		return jdbcTemplate.update(query,setter);
	}
}
