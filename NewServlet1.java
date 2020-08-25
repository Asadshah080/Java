/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author samar khan
 */
public class NewServlet1 extends HttpServlet {

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
        dbconnect db = new dbconnect();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
               request.getRequestDispatcher("signup.html").include(request, response);  
            String name = request.getParameter("name");
            String cnic = request.getParameter("cnic");
            String pass = request.getParameter("password");
            String cpass = request.getParameter("confirm Password");
             System.out.println(name);
             System.out.println(cnic);
          //  String  c= db.getcnic(cnic);
          
            boolean check=db.signupcheck(cnic);
            
            if(check==false){out.println("<html><body onload=\"alert('you are not eligible to cast vote.')\"></body></html>");}
            else {
             String s = db.insert(name,cnic,pass);
            
            
            if(s.equals("error"))
            {
                 out.println("<html><body onload=\"alert('you already registered Login to continue.')\"></body></html>");
            }
            }
           //response.sendRedirect("generic.html");
          
           // response.sendRedirect("html1.html");
          
           //response.sendRedirect("html1.html");
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           // out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
           //  out.println("<p>candidate name: " + a + "</p>");
            out.println("</body>");
            out.println("</html>");*/
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
