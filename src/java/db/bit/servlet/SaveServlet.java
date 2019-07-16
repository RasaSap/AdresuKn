/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lt.bit.data.Person;
import lt.bit.db.DB;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "SaveServlet", urlPatterns = {"/save"})
public class SaveServlet extends HttpServlet {

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
        
         String ids= request.getParameter("id");
         
         String fn = request.getParameter("fn");
         String ln = request.getParameter("ln");
         String bd = request.getParameter("bd");
         
         try{
             System.err.println(ids);
     
         Date bd1 = new SimpleDateFormat("yyyy-MM-dd").parse(bd);
        
         String salary = request.getParameter("salary");
         
         BigDecimal salary1 = new BigDecimal(salary);
         
       
        if (ids == null){
            Person p = new Person(fn, ln, bd1, salary1);
            DB.add(p);

        } else {
            Person p = new Person(fn, ln, bd1, salary1);
            Integer id = Integer.valueOf(ids);
            p.setId(id);
                    
            DB.update(p);

        }
    response.sendRedirect("index.jsp");
         }catch(ParseException e){
             e.printStackTrace();
             System.out.println("Neteisingai ivesta data");
             response.sendRedirect("index.jsp");
         }
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
