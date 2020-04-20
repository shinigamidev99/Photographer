/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.PagingBeanImage;
import dao.ContactDB;
import dao.GalleryDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;

/**
 *
 * @author Administrator
 */
public class GalleryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ContactDB cdb = new ContactDB();
            GalleryDB gdb = new GalleryDB();
            PagingBeanImage bean = new PagingBeanImage();

            String page = request.getParameter("page");
            String id = request.getParameter("galleryId");
            String imagePath = request.getParameter("imagePath");
                    
            String error = null;

            int gallery_id = 0;
            
            // begin: validate gallery_id. If is not correct set error
            try {
                gallery_id = Integer.parseInt(id);
            } catch (Exception ex) {
                error = "Page not found!";
            }
            // end: validate gallery_id. If is not correct set error

            // begin: validate page. If is not correct set error
            if (page != null) {
                int p = 0;

                try {
                    p = Integer.parseInt(page);
                } catch (Exception ex) {
                    error = "Page not found!";
                }

                bean.setGalleryId(gallery_id);
                int pages = bean.getPages();
                
                if (p > pages || p <= 0) {
                    error = "Page not found!";
                }
            } else {
                error = "Page not found!";
            }
            // end: validate page. If is not correct set error

            // begin: if have error set atribute error. Else set atribute gallery
            if (error != null) {
                request.setAttribute("error", error);
            } else {
                Gallery gallery = gdb.selectGalleryById(gallery_id);
                request.setAttribute("gallery", gallery);
            }
            // end: if have error set atribute error. Else set atribute gallery

            request.setAttribute("imagePath", imagePath);
            request.setAttribute("galleryId", gallery_id);
            request.setAttribute("contact", cdb.select());
            request.setAttribute("galleryTop", gdb.selectTop(3));
            request.getRequestDispatcher("/view/home.jsp?action=gallery").forward(request, response);
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
