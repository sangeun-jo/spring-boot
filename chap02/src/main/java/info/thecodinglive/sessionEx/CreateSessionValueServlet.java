package info.thecodinglive.sessionEx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/createse")
public class CreateSessionValueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>세션</title></head>");
        HttpSession session = req.getSession();
        session.setAttribute("jpub", "book");
        out.println("세션이 생성 되었습니다.");
        out.println("<a href='/readse'>세션 읽기</a><body></html>");
    }
}
