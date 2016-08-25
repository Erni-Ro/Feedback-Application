package ro.erni.java.training.dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.erni.java.training.model.Feedback;

public class FeedbackDataAccessObject {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveFeedback(Feedback f) {
		String sql = "INSERT INTO feedback(id_sender, id_receiver, anonym, rocks, good, improve) VALUES(?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] { f.getSenderId(), f.getReceiverId(), f.isAnonymous(),
				f.getRocks(), f.getGood(), f.getImprove() });
		return result;
	}

	public List<Feedback> getAllFeedbacks() {
				String query = "select f.id_feed, f.id_sender, se.firstname, f.id_receiver, re.firstname, f.anonym, f.rocks, f.good, f.improve from feedback f INNER JOIN employee se on se.id_emp = f.id_sender INNER JOIN employee re on re.id_emp = f.id_receiver";
		List list = this.jdbcTemplate.query(query, new RowMapper<Feedback>() {
			public Feedback mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Feedback feedback = new Feedback();
				feedback.setSenderId(rs.getInt(2));
				feedback.setSenderName(rs.getString(3));
				feedback.setReceiverId(rs.getInt(4));
				feedback.setReceiverName(rs.getString(5));
				feedback.setAnonymous(rs.getBoolean(6));
				feedback.setRocks(rs.getString(7));
				feedback.setGood(rs.getString(8));
				feedback.setImprove(rs.getString(9));
				return feedback;
			}
		});
		return list;
	}
}