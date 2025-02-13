/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tf.isd.controller;

/**
 *
 * @author yih
 */

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.User;
import tf.isd.model.dao.DBConnector;
import tf.isd.model.dao.DBManager;

public class TestDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;

    public static void main(String[] args) throws SQLException {
        (new TestDB()).runQueries();
    }
    
    public TestDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException {
        char c;
        
        while ((c=readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
    
    private void testAdd() {
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User name: ");
        String name = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        System.out.print("User gender: ");
        String gender = in.nextLine();
        System.out.print("User favorite color: ");
        String favcol = in.nextLine();

        try {
            db.addUser(email,name,password,gender,favcol);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("User is added to the database.");
    }
    
    private void testRead() throws SQLException {
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        User user = db.findUser(email, password);
        if (user != null) {
            System.out.println("User " + user.getName() + " exists in the database.");
        } else {
            System.out.println("User does not exist");
        }
    }
    
    private void testUpdate() {
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        
        try {
            if (db.checkUser(email,password)) {
                System.out.print("User name: ");
                String name = in.nextLine();
                System.out.print("User gender: ");
                String gender = in.nextLine();
                System.out.print("User favorite color: ");
                String favcol = in.nextLine();
                db.updateUser(email,name,password,gender,favcol);
            } else {
                System.out.println("User does not exist.");
            }
            System.out.println("User details are updated.");
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() {
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        
        try {
            if (db.checkUser(email,password)) {
                db.deleteUser(email);
            } else {
                System.out.println("User does not exist.");
            }
            System.out.println("User is deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAll() {
        try {
            ArrayList<User> users = db.fetchUsers();
            System.out.println("User table: ");
            users.stream().forEach((user) -> 
                System.out.printf("%-20s %-50s %-20s %-20s %-20s \n",user.getEmail(),user.getName(),user.getPassword(),user.getGender(),user.getFavouriteColour()));
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
