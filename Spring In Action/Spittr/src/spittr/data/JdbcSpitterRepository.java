package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

	private static final String INSERT_SPITTER = "";
	private static final String SELECT_SPITTTER_BY_NAME = null;
	private JdbcOperations jdbcOperations;
	
	@Autowired
	public JdbcSpitterRepository (JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	@Override
	public void addSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		jdbcOperations.update(INSERT_SPITTER,
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFirstName(),
				spitter.getEmail(),
				spitter.isUpdateByEmail());
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return jdbcOperations.queryForObject(
				SELECT_SPITTTER_BY_NAME, new SpitterRowMapper(), 
				username);
	}
	
	private static final class SpitterRowMapper implements RowMapper<Spitter> {
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Spitter(
					rs.getLong("id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("firstName"),
					rs.getString("lastName")
					);
		}
	}

}
