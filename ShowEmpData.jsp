<%-- 
    Document   : ShowEmpData
    Created on : 4 May, 2020, 7:12:41 AM
    Author     : XYZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.model.EmployeeModel"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            Employee Details
        </h1>
        <table border="1">
            <tr><td>ID</td><td>Name</td><td>Salary</td></tr>
            <%
                List l1=(List)request.getAttribute("emplist");
                Iterator i=l1.iterator();
                while(i.hasNext())
                {
                    EmployeeModel em=(EmployeeModel)i.next();
                    %>
                    <tr><td><%=em.getId()%></td><td><%=em.getName()%></td><td><%=em.getSalary()%></td></tr>
                    <%
                        }
                        %>
                        
                
        </table>
            
    </body>
</html>

