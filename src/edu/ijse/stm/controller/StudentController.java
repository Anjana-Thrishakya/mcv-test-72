/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.stm.controller;

import edu.ijse.stm.dto.StudentDto;
import edu.ijse.stm.model.StudentModel;
import java.util.ArrayList;

/**
 *
 * @author anjan
 */
public class StudentController {
    
    private StudentModel studentModel = new StudentModel();

    public String saveStudent(StudentDto studentDto) throws  Exception{
        return studentModel.saveStudent(studentDto);
    }
    
    public String updateStudent(StudentDto studentDto) throws  Exception{
        return studentModel.updateStudent(studentDto);
    }
    
    public String deleteStudent(String id) throws Exception {
        return studentModel.deleteStudent(id);
    }
    
    public StudentDto getStudent(String id) throws  Exception{
        return studentModel.getStudent(id);
    }
    
    public ArrayList<StudentDto> getAll() throws  Exception{
        return studentModel.getAll();
    }
}
