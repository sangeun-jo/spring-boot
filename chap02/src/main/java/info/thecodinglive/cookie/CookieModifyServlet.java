package info.thecodinglive.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/modicookie")
public class CookieModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>쿠키 수정</title></head>");
        out.println("<body>");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jpub")){
                    Cookie modifiedCookie = new Cookie("jpub", "read");
                    res.addCookie(modifiedCookie);
                }
            }
        }
        out.println("<a href='/readcookie'>readcookie</a></body></html>");
    }

}
