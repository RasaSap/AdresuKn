<%-- 
    Document   : index
    Created on : Jul 10, 2019, 3:15:44 PM
    Author     : Lenovo
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lt.bit.data.Person"%>
<%@page import="java.util.List"%>
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
        <h1>Address Book</h1>
        <%  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Person> list = DB.getAll();
            
           // list.sort(p1, p2)->p1.getFirstName().length)-p2.getFirstName().length);
           list.sort((p1, p2)-> p1.getFirstName().compareTo(p2.getFirstName()));
               
           
           /* if (p1.getFirstName() > p2.getFirstName()){
            return  -1;
           }else if(p1.getFirstName().equals(p2.getFirstName())){
               return 0;
           }else{
               return 1;
           }   
           });*/
         
            for (Person p: list){
              %>
     
     <ul>
         <li><label><b>First name: </b></label>
             <%=p.getFirstName()%><br>
             <label><b>Last name: </b></label>
             <%=p.getLastName()%> <br>
             <label><b>Birth date: </b></label>
             <%=sdf.format(p.getBirthDate())%><br> 
             <label><b>Salary: </b></label>
             <%=p.getSalary()%><br>
        <button class="button"><a href="delete?id=<%=p.getId()%>">Del</a></button>
        <button class="button"><a href="edit.jsp?id=<%=p.getId()%>">Edit</a></button>
        <button class="button"><a href="addresses.jsp?id=<%=p.getId()%>">Addresses</a></button>
        <button class="button"><a href="contacts.jsp?id=<%=p.getId()%>">Contacts</a></button>
    </li>
    </ul>
      <% } %>
       
     
     <button class="button button1"><a href="edit.jsp">New</a></button>
         
</body>
</html>
