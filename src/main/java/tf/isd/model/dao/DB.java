/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tf.isd.model.dao;

/**
 *
 * @author yih
 */

import java.sql.Connection;

/** 
* Super class of DAO classes that stores the database information 
*  
*/

public abstract class DB {   
    protected String URL = "jdbc:mariadb://localhost:3306/";//replace this string with your jdbc:derby local host url   
    protected String db = "tf";//name of the database   
    protected String dbuser = "root";//db root user   
    protected String dbpass = "loulou"; //db root password   
    protected String driver = "org.mariadb.jdbc.Driver"; //jdbc client driver - built in with NetBeans   
    protected Connection conn; //connection null-instance to be initialized in sub-classes
}
