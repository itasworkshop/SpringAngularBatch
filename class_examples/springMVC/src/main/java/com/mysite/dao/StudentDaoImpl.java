package com.mysite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysite.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
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
		String sql = "select * from student";
		
		List<Student> result = jdbcTemplate.query(sql, new StudentMapper());
		return null;
	}
	
	private static final class StudentMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student st = new Student();
			st.setRollNo(rs.getInt("rollNo"));
			st.setName(rs.getString("name"));
			return st;
		}
		
	}

}
