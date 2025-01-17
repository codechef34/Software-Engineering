/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import java.sql.*;
import org.apache.log4j.*;


/**
 *
 * @author
 */
public class DBconnection {
    
    private static String dbtype=null;
     private static String dbusername=null;
     private static String dbpassword=null;
     private static String dbname=null;
     private static String dbhost=null;
     private static String dbport=null;
     private static DBconnection dbconObj=null;
     private static Connection dbcon=null;
     private final static Logger logger = Logger.getLogger(DBconnection.class);


    private DBconnection()
    {
        dbtype=DBpropertiesRead.getProperty("dbtype");
        dbusername=DBpropertiesRead.getProperty("username");
        dbpassword=DBpropertiesRead.getProperty("password");
        dbname=DBpropertiesRead.getProperty("dbname");
        dbhost=DBpropertiesRead.getProperty("dbhost");
        dbport=DBpropertiesRead.getProperty("dbport");
        
    }
    
   public static Connection getConnection()
   {
        if(dbconObj==null)
           dbconObj=new DBconnection();
       try
       {
       String url="";
       if(dbtype.equalsIgnoreCase("MYSQL"))
       {
           url="jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname;
           Class.forName ("com.mysql.jdbc.Driver");
       }
       else if(dbtype.equalsIgnoreCase("POSGRESQL"))
       {
           
           
       }
       else if(dbtype.equalsIgnoreCase("ORACLE"))
       {
           
           
       }
       System.out.println("The dynamic url prparation is :"+url);
       dbcon=DriverManager.getConnection(url, dbusername, dbpassword);
       }
       catch(ClassNotFoundException classnotfe)
       {
           System.out.println("class not found check driver classes");
           logger.error(classnotfe.getMessage());
       }
       catch(SQLException sqlexec)
       {
    	   JOptionPane.showMessageDialog(null, "Problem "+sqlexec.getMessage());
           System.out.println("some sql connection Exception occured");
           sqlexec.printStackTrace();
       }
       return dbcon;
   }


   public static void closeCon()
   {
        if(dbcon!=null)
        {
            try
            {
            dbcon.close();
            dbcon=null;
            }
            catch(SQLException sql)
            {
                System.out.println("closing error"); 
            }
        }
   }
   
   
   public static void closeAll(Connection con,PreparedStatement ps,Statement st,ResultSet rs)
   {
        if(con!=null)
        {
            try
            {
            	con.close();
            	con=null;
            }
            catch(SQLException sql)
            {
                System.out.println("closing error"); 
            }
        }
        if(ps!=null)
        {
            try
            {
            	ps.close();
            	ps=null;
            }
            catch(SQLException sql)
            {
                System.out.println("closing error"); 
            }
        }
        if(st!=null)
        {
            try
            {
            	st.close();
            	st=null;
            }
            catch(SQLException sql)
            {
                System.out.println("closing error"); 
            }
        }
        if(rs!=null)
        {
            try
            {
            	rs.close();
            	rs=null;
            }
            catch(SQLException sql)
            {
                System.out.println("closing error"); 
            }
        }
   }
   
   
   
   
    public static void main(String[] args) {
        System.out.println(getConnection());
        if(dbcon!=null)
        {
            try
            {
            dbcon.close();
            dbcon=null;
            }
            catch(SQLException sql)
            {
                
            }
        }
       
    }


}
