/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author samar khan
 */
public class NewServlet extends HttpServlet {
      dbconnect db = new dbconnect();

    /*
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
           // request.getRequestDispatcher("login.html").include(request, response);  
            String cnic = request.getParameter("cnic");
            String pass = request.getParameter("password");
           // System.out.println(name);
            //System.out.println(pass);
           //String  a= db.getname(name);
            String  c= db.getcnic(cnic);
            String  b= db.getpass(pass);
            
            //out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            // out.println(c); 
            // out.println(b); 
           
        if(cnic.equals(c)){  
              if(pass.equals(b)){
                        //  response.sendRedirect("afterlogin.html");
                          
                        // HttpSession session = request.getSession();
			//session.setAttribute("cnic",c);
			//setting session to expiry in 30 mins
			//
                        //session.setMaxInactiveInterval(30*60);
                        Cookie usercnic = new Cookie("cnic", c);
			usercnic.setMaxAge(30*60);
			response.addCookie(usercnic);
                        response.sendRedirect("afterlogin.jsp");
                         // out.print("Welcome, "+name);  
                          //HttpSession session=request.getSession();  
                          //session.setAttribute("name",name);  
                         }
              else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
                        out.println("<html><body onload=\"alert('Either user name or password is wrong.')\"></body></html>");
                        rd.include(request, response);
              // out.print("Sorry, username or password error!"); 
               
              }
        } 
              
              else{  
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
                        out.println("<html><body onload=\"alert('Either user name or password is wrong.')\"></body></html>"); 
                        rd.include(request, response); 
                      }
           
           
          // request.getRequestDispatcher("index.html").include(request, response);  
        
          // response.sendRedirect("afterlogin.html");
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//          //  out.println("<title>Servlet Servlet2</title>");            
//            out.println("</head>");
//            out.println("<body>");
//           // out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
//           //  out.println("<p>candidate name: " + a + "</p>");
//            out.println("</body>");
//            out.println("</html>");
        
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
