package com.org.patient.servlet;

/**
 * Resource Servlet - Use this for loading various resources on Application
 * startup.
 * 
 * @author jhasting
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.org.patient.db.util.DBUtilMongo;;



@WebServlet(name = "ResourceServlet", urlPatterns = {"/ResourceServlet"})
public class ResourceServlet extends HttpServlet {
	
    private static Logger logger = Logger.getLogger(ResourceServlet.class.getName());
    
    
    private DBUtilMongo dbUtilMongo  = null;
    
   

    // This Happens Once and is Reused
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        super.init(config);
        
       
        // force db connections to be created
        dbUtilMongo = DBUtilMongo.getInstance();
        
       /* dbUtilCaseImpact = DBUtilCaseImpact.getInstance();
       
        dbUtilCG1Orders = DBUtilCG1Orders.getInstance();*/
        
    }
    
    /**
     *
     */
    @Override
    public void destroy() {
        logger.info("in destroy");
        super.destroy();
       
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResourceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResourceServlet at " + request.getContextPath() + "</h1></br>");
            out.println("This should not be accessed directly");            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
        return "ResourceServlet Loads Application Resources";
    }// </editor-fold>
}
