/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inet.util;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Designer Nguyễn
 */
public class RequestUtil {
    public static Integer getInt(HttpServletRequest request, String paramName, Integer defaultValue){
        try{
            Integer rs = Integer.parseInt(request.getParameter(paramName));
            return rs;
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static BigDecimal getBigDecimal(HttpServletRequest request, String paramName, BigDecimal defaultValue){
        try{
            BigDecimal rs = new BigDecimal(request.getParameter(paramName));
            return rs;
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static String getString(HttpServletRequest request, String paramName, String defaultValue){
        try{
            if(request.getParameter(paramName) != null && !"".equals(request.getParameter(paramName))) 
                return request.getParameter(paramName);
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static String getStringUTF8(HttpServletRequest request, String paramName, String defaultValue){
        try{
            if(request.getParameter(paramName) != null && !"".equals(request.getParameter(paramName))) 
                return new String(request.getParameter(paramName).getBytes(
                                "iso-8859-1"), "UTF-8");
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static String getRealContextPath(HttpServletRequest request){
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = "";
        if("localhost".equals(serverName)) contextPath = request.getScheme() + "://"+serverName+":"+serverPort+request.getContextPath();
        else contextPath = request.getScheme() + "://"+serverName;
        return contextPath;
    }
    
    public static String getContextPath(HttpServletRequest request){
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = "";
        if("localhost".equals(serverName)) contextPath = request.getScheme() + "://"+serverName+":"+serverPort+request.getContextPath();
        else contextPath = request.getScheme() + "://"+serverName;
        return contextPath;
    }
}
