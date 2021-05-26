package com.mysite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.mysite.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from mysql.student";

		List<Student> result = jdbcTemplate.query(sql, new StudentMapper());
		return result;
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student st = new Student();
			st.setRollNo(rs.getInt("rollNo"));
			st.setName(rs.getString("name"));
			return st;
		}

	}

	@Override
	public Student findById(Integer rollNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("rollNo", rollNo);

		String sql = "select * from mysql.student where rollNo = :rollNo";

		Student result = null;

		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new StudentMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void save(Student st) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "insert into mysql.student values (:rollNo,:name)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(st));

	}
	
	private SqlParameterSource getSqlParameterByModel(Student student) {
		MapSqlParameterSource paramsSource = new MapSqlParameterSource();
		paramsSource.addValue("rollNo", student.getRollNo());
		paramsSource.addValue("name",student.getName());
		
		return paramsSource;
		
		
	}
	

	@Override
	public void update(Student st) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Student st) {
		// TODO Auto-generated method stub

	}

}
