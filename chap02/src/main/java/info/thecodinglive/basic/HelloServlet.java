package info.thecodinglive.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="HelloServlet", urlPatterns = {"/helloget"} )
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("DoGet method call");
        res.setCharacterEncoding("utf-8");
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html");
        writer.println("<html>");
        writer.println("<head>jpub java webservice</head>");
        writer.println("<body> get 요청 예제입니다. </body>");
        writer.println("</html>");
    }
}
