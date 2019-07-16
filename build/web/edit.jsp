<%-- 
    Document   : edit
    Created on : Jul 10, 2019, 4:23:23 PM
    Author     : Lenovo
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lt.bit.db.DB"%>
<%@page import="lt.bit.data.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
           body * {
            margin: 0;
            padding: 0;
            vertical-align: top;
            box-sizing: border-box;
            }
            body{
                background: #3399ff;
            }
            
            form > input {
                width: 50%;
            }
             button {
                border: none;
                padding: 12px 20px;
                text-align: left;
                display: inline-block;
                font-size: 12px;
                margin: 4px 2px;
                cursor: pointer;
                
            }
            button > input{
                border: none;
                text-align: left;
                display: inline-block;
                font-size: 12px;
                cursor: pointer;
                
            }
            button > a{
                text-decoration: none;
                color: black;
            }
            
        </style>
    </head>
    <body>
             <% 
         String ids = request.getParameter("id");
            
         Person p = null;
         try{
             Integer id = Integer.valueOf(ids);
             p = DB.getById(id);
         }catch(Exception ex){
             //ignore
         }   
         if(ids != null && p == null){
            //jeigu perdave paramettra, bet jo nerado, siunciam ji atgal i index.jsp  
            response.sendRedirect("index.jsp");
            return;
         }
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         
        %>
        <form method="POST" action="save">
            
             <% if (p != null) {%>
            <input type="hidden" value="<%=ids%>" name="id">
            <% } %>
            <label for="fn"> First name:</label><br>  
           <input name="fn" value="<%=(p!=null)?p.getFirstName():""%>"> <br>
           <label for="ln"> Last name:</label> <br>  
           <input name="ln" value="<%=(p!=null)?p.getLastName():""%>"> <br>
           <label for="bd"> Birth date:</label><br> 
           <input name="bd" value="<%=(p!=null)?sdf.format(p.getBirthDate()):""%>"> <br>
           <label for="salary"> Salary:</label><br> 
           <input name="salary" value="<%=(p!=null)?p.getSalary():""%>"> <br>
           
           <button><input type="submit" value="Save"></button>
           <button><a href="index.jsp">Cancel</a></button>
            
        </form>
        
    </body>
</html>
