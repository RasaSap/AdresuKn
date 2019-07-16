/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.data.Address;
import lt.bit.db.DB;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "SaveAddressServlet", urlPatterns = {"/saveAddress"})
public class SaveAddressServlet extends HttpServlet {

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
         
         String address = request.getParameter("address");
         String city = request.getParameter("city");
         String postalCode = request.getParameter("postalCode");
     
         Integer id2 = Integer.valueOf(ids2);
         
       /* if (id2 == -1){
             Integer id = Integer.valueOf(ids);
             
             Address a = new Address();
             
             a.setAddress(addr);
             a.setCity(city);
             a.setPostalCode(postalCode);
             
             DB.addAddress(id, a);
             
         } else {
             Address a = new Address();  
             DB.updateAddress(a);  
         }
         response.sendRedirect("addresses.jsp");
       
         */
       
       Integer id = Integer.valueOf(ids);
         Address a = new Address();
         if (id2 == -1){
             
          
             if (address != null && !"".equals(address)){
                a.setAddress(address);
             }
             if (city != null && !"".equals(city)){
                a.setCity(city);
             }
             if (postalCode != null && !"".equals(postalCode)){
                a.setPostalCode(postalCode);
             }
             
             DB.addAddress(id, a);
             
       }
        else {
                a.setAddress(address);
                a.setCity(city);
                a.setPostalCode(postalCode);
                a.setId(id2);
                DB.updateAddress(a);  
                
               }
         
         
         response.sendRedirect("addresses.jsp?id=" + id + "&id2=" + a.getId());
       
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
