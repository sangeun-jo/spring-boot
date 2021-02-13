package info.thecodinglive.sessionEx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/readse")
public class ReadSessionValueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>세션</title></head>");
        HttpSession session = req.getSession();
        String sessionValue = (String) session.getAttribute("jpub");
        out.println("생성된 세션 값: " + sessionValue);
        out.println("</body></html>");
    }
}
