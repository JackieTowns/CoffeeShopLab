package co.grandcircus.coffeeshop.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.entities.User;

@Repository
public class UserDao {
		
		@Autowired
		private JdbcTemplate jdbc;

	public List<User> findAll() {

		String sql = "SELECT * FROM users";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
		}

	public User findById(Long id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
		}

	public void update(User user) {
		String sql = "UPDATE users SET username=?, password=?, yourname=? WHERE id=?";
		jdbc.update(sql, user.getUsername(), user.getPassword(), user.getYourname(), user.getId());
		}

	public void create(User user) {
		String sql = "INSERT INTO Users (username, password, yourname) VALUES(?, ?, ?)";
		jdbc.update(sql, user.getUsername(), user.getPassword(), user.getYourname());
		}

		public void delete(Long id) {
		String sql = "DELETE FROM Users WHERE id = ?";
			jdbc.update(sql, id);

		}

	}



