/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryan.loancal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ryan.business.LoanCalculator;

/**
 *
 * @author 1333612
 */
@WebServlet(name = "LoanServlet", urlPatterns = {"/LoanServlet","/loan"})
public class LoanServlet extends HttpServlet {
    private static final String TITLE = "Loan Calculator";

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoanServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    /**
     * URLs entered in the address bar or taken from a bookmark are always GET
     * requests
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Define the type of content that will appear in the http response
        response.setContentType("text/html");

		// The PrintWriter object allows you to write/transmit HTML to the
        // browser that issued the request.
        PrintWriter out = response.getWriter();

        // Now for some ugly code
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + TITLE + "</title></head>");
        out.println("<body><h1>" + TITLE + "</h1>");

        // This form will call the post method
        out.println("<form method='post'>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>Amount Of Loan:</td>");
        out.println("<td><input name='pv'/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Rate:</td>");
        out.println("<td><input name='rate'/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Length of Loan in Months:</td>");
        out.println("<td><input name='n'/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type='submit'/></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
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
        //processRequest(request, response);
       String a = request.getParameter("pv");
       String b = request.getParameter("rate");
       String c = request.getParameter("n");
       
       double pv = Double.parseDouble(a);
       double rate = Double.parseDouble(b);
       int n = Integer.parseInt(c);
       
       LoanCalculator lc = new LoanCalculator();
       double pmt = lc.calculate(pv, rate, n);
       
       PrintWriter out = response.getWriter();
         // more ugly code
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + TITLE + "</title></head>");
        out.println("</head>");
        out.println("<body><h1>" + TITLE + "</h1>");
        out.println("<h1> The Answer is: " + pmt + "</h1>");
        out.println("</body>");
        out.println("</html>");
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
