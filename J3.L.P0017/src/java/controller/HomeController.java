/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.PagingBean;
import dao.ContactDB;
import dao.GalleryDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ContactDB cdb = new ContactDB();
            GalleryDB gdb = new GalleryDB();
            PagingBean bean = new PagingBean();
            
            // get total page
            String page = request.getParameter("page");
            int pages = bean.getPages();
            String error = null;
            
            // begin: validate page. If is not correct set error
            if (page != null) {
                int p = 0;

                try {
                    p = Integer.parseInt(page);
                } catch (Exception ex) {
                    error = "Page not found!";
                }

                if (p > pages || p <= 0) {
                    error = "Page not found!";
                }

                if (error != null) {
                    request.setAttribute("error", error);
                }
            }
            // end: validate page. If is not correct set error

            request.setAttribute("contact", cdb.select());
            request.setAttribute("galleryTop", gdb.selectTop(3));
            request.getRequestDispatcher("/view/home.jsp?action=home").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
