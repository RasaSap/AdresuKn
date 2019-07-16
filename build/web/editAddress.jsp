<%-- 
    Document   : editAddress
    Created on : Jul 10, 2019, 4:24:04 PM
    Author     : Lenovo
--%>

<%@page import="lt.bit.db.DB"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.data.Address"%>
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
            // List<Address> addresses = DB.getPersonAddresses(id);
%>
        <form method="POST" action="saveAddress">

            <input type="hidden" value="<%=id%>" name="id">
            <input type="hidden" value="<%=id2%>" name="id2">
            
            
            <label for="address"> Address:</label><br> 
            <input name="address" value="<%=(id2 != -1)?DB.getAddressById(id2).getAddress():""%>"><br> 
            <label for="city"> City:</label><br> 
            <input name="city" value="<%=(id2 != -1)?DB.getAddressById(id2).getCity():""%>"><br> 
            <label for="postalCode"> Postal Code:</label><br> 
            <input name="postalCode" value="<%=(id2 != -1)?DB.getAddressById(id2).getPostalCode():""%>"> <br>


            <button><input type="submit" value="Save"></button>
            <button><a href="addresses.jsp?id=<%=id%>&id2=<%=id2%>">Cancel</a></button>

        </form>
    </body>
</html>
