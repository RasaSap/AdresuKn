<%-- 
    Document   : editContact
    Created on : Jul 10, 2019, 4:24:41 PM
    Author     : Lenovo
--%>

<%@page import="lt.bit.db.DB"%>
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
            String ids2 = request.getParameter("id2");
            Integer id = Integer.valueOf(ids);
            Integer id2 = Integer.valueOf(ids2);
          
            %>
            <form method="POST" action="saveContact">
                
                <input type="hidden" value="<%=id%>" name="id">
                <input type="hidden" value="<%=id2%>" name="id2">
         
                <label for="contact"> Contact:</label><br>
                <input name="contact" value="<%=(id2!=-1)?DB.getContactById(id2).getContact():""%>"> <br>
                <label for="type"> Type:</label><br>
                <input name="type" value="<%=(id2!=-1)?DB.getContactById(id2).getType():""%>"> <br>
               
                <button><input type="submit" value="Save"></button>
                <button><a href="contacts.jsp?id=<%=id%>&id2=<%=id2%>">Cancel</a></button>
               
            </form>
    </body>
</html>
