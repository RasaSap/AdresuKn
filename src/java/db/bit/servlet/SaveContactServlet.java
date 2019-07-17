/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.data.Contact;
import lt.bit.db.DB;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "SaveContactServlet", urlPatterns = {"/saveContact"})
public class SaveContactServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String ids = request.getParameter("id");
         String ids2 = request.getParameter("id2");
         
         String contact = request.getParameter("contact");
         String type = request.getParameter("type");
    
          if (("".equals(contact))&&("".equals(type))){
           response.sendRedirect("contacts.jsp?id=" + ids);
           return;
         }
         
         if("".equals(contact)){       
             contact = "";
            }
         if("".equals(type)){       
             type = "";
            }
         
         Integer id2 = Integer.valueOf(ids2);
     
         Integer id = Integer.valueOf(ids);
         Contact c = new Contact();
         if (id2 == -1){
            
             if (contact != null && !"".equals(contact)){
                c.setContact(contact);
             }
             if (type != null && !"".equals(type)){
                c.setType(type);
             }
             
             DB.addContact(id, c);
             
       }
        else {          
                c.setContact(contact);
                c.setType(type);
                c.setId(id2);
                DB.updateContact(c);  
                
               }
         
         response.sendRedirect("contacts.jsp?id=" + id + "&id2=" + c.getId());
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
