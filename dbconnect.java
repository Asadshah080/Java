/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NailaSaad
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class dbconnect {
 
        private java.sql.Connection connect;
        private Statement st;
        private ResultSet rs;
        
        public dbconnect()
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","asad1234");
                st = connect.createStatement();
                
                
                
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e);
            }
            
        }
        public ResultSet getData(String q){
            try{
                rs = st.executeQuery(q);
            }catch(Exception e){
                
            }
            return rs;
        }
        public String getname(String name1)
        {
            try{
                
            
            String query = "Select * from signup where name = '"+name1+"' ";
            System.out.println (query);
            rs= st.executeQuery(query);
            
            while (rs.next())
            {
                 System.out.println ("Query Result"+ rs);
                String nam = rs.getString("name");
                
                return nam ;
            }
            
            }catch (Exception e )
            {
                System.out.println ("Error: " + e);
            }
            return null;
        }
        
        public String getpass(String password1)
        {
            try{
                
            
            String query = "Select * from signup where password = '"+password1+"' ";
            System.out.println (query);
            rs= st.executeQuery(query);
            
            while (rs.next())
            {
                
                String pass= rs.getString("password");
                
                return pass;
            }
            
            }catch (Exception e)
            {
                System.out.println ("Error: " + e);
            }
            return null;
        }
         public String getcnic(String cnic1)
        {
            try{
                
            
            String query = "Select * from signup where cnic = '"+cnic1+"' ";
            System.out.println (query);
            rs= st.executeQuery(query);
            
            while (rs.next())
            {
                System.out.println ("Query Result"+ rs);
                String cn = rs.getString("cnic");
                return cn ;
            }
            
            }catch (Exception e )
            {
                System.out.println ("Error: " + e);
            }
            return null;
        }
         public String insert(String name,String cnic,String password){
               try{
                   String query = "select * from signup where cnic='" +cnic+ "' ";
            ResultSet rs=st.executeQuery(query);

            
            if(rs.next()) {return "error";}
            else{
         query = "INSERT INTO `signup`(`name`, `cnic`, `password`)VALUES('"+name+"','"+cnic+"','"+password+"')";
          st.executeUpdate(query);
             return "error";
            } 
               }catch (Exception e)
            {
                System.out.println ("Error: " + e);
            }
               return null;
         }
         
         public String getallname()
        {
            try{
                
            
            String query = "Select * from signup ";
            System.out.println (query);
            rs= st.executeQuery(query);
            
           // while (rs.next())
           // {
             //    System.out.println ("Query Result"+ rs);
               // String nam = rs.getString("name");
                
             //   return nam ;
           // }
            
            }catch (Exception e )
            {
                System.out.println ("Error: " + e);
            }
            return null;
        }
        public ResultSet return_Object()
        {
            return rs;
        }
         public boolean signupcheck(String cnic)
        {
            try{
                
           String query = "select * from citizen_data where cnic='" +cnic+ "' ";
            ResultSet rs=st.executeQuery(query);
            
            if (rs.next())
            {
                
                
                return false ;
            }
            
            }catch (Exception e )
            {
                System.out.println ("Error: " + e);
            }
            return true;
        }
}

