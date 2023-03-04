package com.a2m.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.a2m.models.Employee;

public class EmployeeDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee emp) {
		String sql = "insert into employee(id,name,age,phone_number,address) "
				+ "values(" + emp.getId() + ",N'" + emp.getName() + "',"
				+ emp.getAge() + ",'" + emp.getPhoneNumber() + "',N'" + emp.getAddress() + "')";
		return template.update(sql);
	}

	public int update(Employee emp) {
		String sql = "update employee set name='" + emp.getName() + "', age=" + emp.getAge() + ",phone_number='"
				+ emp.getPhoneNumber() + "', address='" + emp.getAddress() + "' where id=" + emp.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from employee where id=" + id + "";
		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Employee getEmpById(int id) {
		String sql = "select * from employee where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public List<Employee> getEmployees() {
		return template.query("select * from employee", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setAddress(rs.getString("address"));
				return emp;
			}
		});
	}
}
