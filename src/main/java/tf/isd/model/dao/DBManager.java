/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tf.isd.model.dao;

/**
 *
 * @author yih
 */

import uts.isd.model.User;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {       
       st = conn.createStatement();   
    }

    //Find user by email and password in the database   
    public User findUser(String email, String password) throws SQLException {       
       //setup the select sql query string
       String fetch = "select * from tf.Users where EMAIL = '"+email+"' and PASSWORD = '"+password+"'";
       //execute this query using the statement field
       //add the results to a ResultSet
       ResultSet rs = st.executeQuery(fetch);
       //search the ResultSet for a user using the parameters
       while (rs.next()) {
           String userEmail = rs.getString(1);
           String userPass = rs.getString(3);
           if (userEmail.equals(email) && userPass.equals(password)) {
               String userName = rs.getString(2);
               String userGender = rs.getString(4);
               String userFavcol = rs.getString(5);
               return new User(userEmail,userName,userPass,userGender,userFavcol);
           }
       }
       return null;   
    }

    //Add a user-data into the database   
    public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException {
        //code for add-operation
        st.executeUpdate("INSERT INTO tf.Users " + "VALUES ('"+email+"','"+name+"','"+password+"','"+gender+"','"+favcol+"')");
    }

    //update a user details in the database   
    public void updateUser( String email, String name, String password, String gender, String favcol) throws SQLException {       
       //code for update-operation
       st.executeUpdate("UPDATE tf.Users SET NAME='"+name+"',PASSWORD='"+password+"',GENDER='"+gender+"',FAVCOL='"+favcol+"' WHERE (EMAIL='"+email+"' AND PASSWORD='"+password+"')");
    }

    //delete a user from the database   
    public void deleteUser(String email) throws SQLException{       
       //code for delete-operation
       st.executeUpdate("DELETE FROM tf.Users WHERE EMAIL='"+email+"'");
    }
    
    // read all Users rows and store the results into ResultSet
    // then iterate through the set and read every attribute by index
    public ArrayList<User> fetchUsers() throws SQLException{
        String fetch = "select * from Users";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList ();
        
        while (rs.next()) {
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String gender = rs.getString(4);
            String favcol = rs.getString(5);
            temp.add(new User(email,name,password,gender,favcol));
        }
        return temp;
    }
    
    // check if a user exists in the 
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "select * from tf.Users where EMAIL = '"+email+"' and PASSWORD = '"+password+"'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(1);
            String userPassword = rs.getString(3);
            if (userEmail.equals(email) && userPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "I'm the manager";
    }
}