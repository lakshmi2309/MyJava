package com.example.EmployeeNewJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Department> findAllDepartments(){
        String mySQL = "select * from department";
        List<Department> depts = jdbcTemplate.query(mySQL,new DepartmentRowMapper());
        return depts;
    }

    private class DepartmentRowMapper implements RowMapper<Department>{

        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department dept = new Department();

            dept.setDept_id(rs.getInt("dept_id"));
            dept.setDept_name(rs.getString("dept_name"));
            dept.setTeam_id(rs.getInt("team_id"));


            return dept;

        }


    }

}
