/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class JspFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            
            // Array page special
            String[] specialPage = {"gallery", "contact"};

            String url = req.getRequestURI();
            String context = req.getContextPath();

            String[] urlSplit = url.split("/");
            url = urlSplit[urlSplit.length - 1].toLowerCase();
            
            if (url.endsWith(".jsp")) {
                url = url.replaceAll(".jsp", "");
                boolean isSpecial = false;
                
                for (String str : specialPage) {
                    if (str.equals(url)) {
                        isSpecial = true;
                        break;
                    }
                }

                if (isSpecial) {
                    String galleryId = request.getParameter("galleryId");
                    String page = request.getParameter("page");
                    
                    if(galleryId != null || page != null) {
                        url += "?galleryId=" + galleryId + "&page=" + page;
                    }
                    
                    res.sendRedirect(context + "/" + url);
                } else {
                    res.sendRedirect(context + "/home");
                }
            }

            chain.doFilter(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
