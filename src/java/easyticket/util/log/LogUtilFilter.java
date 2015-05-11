/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyticket.util.log;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class LogUtilFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (LogUtil.logPath.equals("")) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpSession session = request.getSession();
            ServletContext context = session.getServletContext();
            LogUtil.logPath = context.getRealPath(request.getContextPath()) + File.separator + "logs" + File.separator;
        }
        chain.doFilter(req, res);
    }

    public void destroy() {

    }

}
