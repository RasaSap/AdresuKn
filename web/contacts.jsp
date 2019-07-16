<%-- 
    Document   : contacts
    Created on : Jul 10, 2019, 4:24:23 PM
    Author     : Lenovo
--%>

<%@page import="lt.bit.db.DB"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.data.Contact"%>
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
            h1{
               text-align: center; 
            }
          
            ul {
                padding: 20px;
                
                }
                ul > li {
                background: #e7e7e7;
                display: inline-block;
                width: 100%;
                float: left;
                top: 30px;
                bottom: 30px;
                margin: 10px;
                padding: 10px;
                }
                
                    
            .button {
                border: none;
                padding: 12px 20px;
                text-align: left;
                display: inline-block;
                font-size: 12px;
                margin: 4px 2px;
                cursor: pointer;
                
            } 
            .button > a{
                text-decoration: none;
                color: black;
            }
            .button1{
                background-color: #e7e7e7; 
                color: black;
                margin: 15px 30px;
                
            }
               
            
        </style>
    </head>
    <body>
        <% 
         String ids = request.getParameter("id");
         try{
         Integer id = Integer.valueOf(ids); 
         List <Contact> contacts = DB.getPersonContacts(id);
        // System.out.println(addresses.size());
         for(int i=0; i<contacts.size();i++){
             
        %>
        <ul>
        <li><label><b>Contact:</b></label>
            <%=contacts.get(i).getContact()%> <br>
            <label><b>Type:</b></label>
            <%=contacts.get(i).getType()%><br>
        
            <button class="button"><a href="deleteContact?id2=<%=contacts.get(i).getId()%>&id=<%=id%>">Del</a></button>
            <button class="button"><a href="editContact.jsp?id2=<%=contacts.get(i).getId()%>&id=<%=id%>">Edit</a></button>
           
        </li>
        </ul>
        <% } %>
           <%if(id == null){
               id = -1;
           }%>
           
           
            <button class="button button1"><a href="editContact.jsp?id=<%=id%>&id2=-1">New</a></button>
           <button class="button button1"><a href="index.jsp">Back</a></button>
            <%}catch(Exception e){
           //ignore
           }%>
    </body>
</html>
