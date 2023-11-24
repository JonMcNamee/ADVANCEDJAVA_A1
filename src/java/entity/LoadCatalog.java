/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package entity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JonMc
 */
@WebServlet(name = "LoadCatalog", urlPatterns = {"/LoadCatalog"})
public class LoadCatalog extends HttpServlet {

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
        ArrayList<Monitor> catalog = new ArrayList();

        InputStream csv = getServletContext().getResourceAsStream("/monitors.csv");
        if (csv == null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet LoadCatalog</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet LoadCatalog at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }
        Scanner sc = new Scanner(csv);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] pieces = line.split(",");
            int partNum = Integer.parseInt(pieces[0]);
            String description = pieces[1];
            String resolution = pieces[2];
            double size = Double.parseDouble(pieces[3]);
            String refreshRate = pieces[4];
            boolean ips = "yes".equalsIgnoreCase(pieces[5].trim());
            double price = Double.parseDouble(pieces[6]);
            Monitor m = new Monitor(partNum, description, resolution, size, refreshRate, ips, price);
            catalog.add(m);
        }
        request.getSession().setAttribute("catalog", catalog);
        request.getRequestDispatcher("/showOrders.jsp").forward(request, response);

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
    }// </editor-fold

}
