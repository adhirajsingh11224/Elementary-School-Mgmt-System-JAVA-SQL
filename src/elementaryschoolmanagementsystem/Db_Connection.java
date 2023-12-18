/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementaryschoolmanagementsystem;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class Db_Connection {
    
    public static Connection connectDbMethod(){
        Connection con = null;
    
        try{
            Class.forName("java.sql.DriverManager");//establishing connection with database used
            con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/school_mgmt_db", "root", "root");
            return con;
        }catch(Exception ex){
            System.out.println("----"+ex.getMessage());
        }
        return con;// returning cconnection string
    }
}
