/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import java.sql.*;
import java.util.*;
import com.model.EmployeeModel;


/**
 *
 * @author XYZ
 */
public class EmployeeDao {
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    List emplist;
    public EmployeeDao()
    {
        try
        {
            //load the driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            
        }
        catch(Exception ee)
        {
            System.out.println("connection error"+ee);
        }
    }
    public int insertEmp(EmployeeModel ee)
    {
        int retval=0;
        try
        {
            ps=con.prepareStatement("insert into app.employee(empid,empname,empsalary) values(?,?,?)");
            ps.setString(1,ee.getId());
            ps.setString(2,ee.getName());
            ps.setInt(3,ee.getSalary());
            retval=ps.executeUpdate();
        }
        catch(Exception ee2)
        {
            System.out.println("insertion error"+ee2);
        }
        return retval;
        
    }
     public int deleteEmp(EmployeeModel ee3)
    {
        int retval=0;
        try
        {
            ps=con.prepareStatement("delete from app.employee where empid=?");
            ps.setString(1,ee3.getId());
            retval=ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("deletion error"+e);
        }
        return retval;
        
    }
     public int updateEmp(EmployeeModel ee11)
    {
        int retval=0;
        try
        {
            ps=con.prepareStatement("update app.employee set empname=? , empsalary=? where empid=?");
            ps.setString(1,ee11.getName());
            ps.setInt(2,ee11.getSalary());
            ps.setString(3,ee11.getId());
        
            retval=ps.executeUpdate();
        }
        catch(Exception ee10)
        {
            System.out.println("updation error"+ee10);
        }
        return retval;
        
    }
    public List showRecord()
    {
        List emplist=new LinkedList();
        String empid=null;
        String empname=null;
        int empsalary;
        try
        {
            st=con.createStatement();
            rs=st.executeQuery("select * from app.employee");
            while(rs.next())
            {
                empid=rs.getString("empid");
                empname=rs.getString("empname");
                empsalary=rs.getInt("empsalary");
                EmployeeModel em=new EmployeeModel(empid,empname,empsalary);
                emplist.add(em);
            }
        }
        catch(Exception ee1)
        {
            System.out.println("retrieval error"+ee1);
        }
        return emplist;
    }
    
}
