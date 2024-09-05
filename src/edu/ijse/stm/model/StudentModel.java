/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.stm.model;

import edu.ijse.stm.db.DBConnection;
import edu.ijse.stm.dto.StudentDto;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author anjan
 */
public class StudentModel {
    public String saveStudent(StudentDto studentDto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Student VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, studentDto.getStudentId());
        statement.setString(2, studentDto.getName());
        statement.setString(3, studentDto.getEmail());
        statement.setString(4, studentDto.getCourse());
        
        return statement.executeUpdate() > 0 ? "Success" : "Fail";
    }
    
    public String updateStudent(StudentDto studentDto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Student SET name = ?, email = ?, course = ? WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, studentDto.getName());
        statement.setString(2, studentDto.getEmail());
        statement.setString(3, studentDto.getCourse());
        statement.setString(4, studentDto.getStudentId());
        
        return statement.executeUpdate() > 0 ? "Success" : "Fail";
    }
}
