package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeSkill;
import lv.javaguru.java2.hrsystem.core.domain.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSkillRowMapper implements RowMapper<EmployeeSkill> {
    @Override
    public EmployeeSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        Skill skill = new Skill();

        employee.setId(rs.getLong("empl_id"));
        employee.setName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setAge(rs.getInt("age"));
        employee.setTitle(rs.getString("employee_title"));

        skill.setSkillId(rs.getLong("skill_id"));
        skill.setSkillName(rs.getString("skill_name"));

        return new EmployeeSkill(employee, skill);
    }
}