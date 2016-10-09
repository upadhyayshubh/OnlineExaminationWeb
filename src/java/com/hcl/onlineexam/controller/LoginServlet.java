package com.hcl.onlineexam.controller;

import com.google.gson.Gson;
import com.hcl.onlineexam.dao.StudentDao;
import com.hcl.onlineexam.dto.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        StudentDao sdao = new StudentDao();

        Student s = sdao.login(email, password);

        Gson g = new Gson();
        //String d="";

        //Student s2 = g.fromJson(d, Student.class);

        String data = g.toJson(s);

        if(data.equalsIgnoreCase("{}")){
            data="not found";
        }
        
        
        PrintWriter out = response.getWriter();

        out.print(data);

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
