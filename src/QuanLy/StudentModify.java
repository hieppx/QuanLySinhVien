/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiepp
 */
public class StudentModify {
    public static List<Student> showAll() {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //truy van
            String sql = "SELECT * FROM student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                Student std = new Student(resultSet.getInt("id"), 
                        resultSet.getString("fullname"), resultSet.getString("gender"), 
                        resultSet.getString("email"), resultSet.getString("phone_number"), 
                        resultSet.getInt("age"));
                studentList.add(std);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null ){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
    return studentList;
    }
    
    public static void insert(Student std){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // then
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //truy van
            String sql = "INSERT INTO student(fullname, gender, age, email, phone_number) VALUES(?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getFullName());
            statement.setString(2, std.getGender());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null ){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
    }
    
    public static void update(Student std){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //truy van
            String sql = "UPDATE student SET fullname=?, gender=?, age=?, email=?, phone_number=? WHERE id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getFullName());
            statement.setString(2, std.getGender());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.setInt(6, std.getId());
            statement.execute();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null ){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
    }
    
    public static void delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //truy van
            String sql = "DELETE FROM student WHERE id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null ){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
    }
    
    public static List<Student> findByName(String fullname) {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            
            //truy van
            String sql = "SELECT * FROM student WHERE fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Student std = new Student(resultSet.getInt("id"), 
                        resultSet.getString("fullname"), resultSet.getString("gender"), 
                        resultSet.getString("email"), resultSet.getString("phone_number"), 
                        resultSet.getInt("age"));
                studentList.add(std);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null ){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
    return studentList;
    }
}
