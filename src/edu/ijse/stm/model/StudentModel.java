/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.stm.model;

import edu.ijse.stm.db.DBConnection;
import edu.ijse.stm.dto.StudentDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


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
    
    public String deleteStudent(String id) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Student WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        return statement.executeUpdate() > 0 ? "Success" : "Fail";
    }
    
    public StudentDto getStudent(String id) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Student WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        
        ResultSet rst = statement.executeQuery();
        if(rst.next()){
            return new StudentDto(
                    rst.getString("student_id"),
                    rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("course"));
        }
        return null;
    }
    
    public ArrayList<StudentDto> getAll() throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Student";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<StudentDto> dtos = new ArrayList<>();
        while(rst.next()){
            dtos.add(new StudentDto(
                    rst.getString("student_id"),
                    rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("course")));
        }
        return dtos;
    }
}
