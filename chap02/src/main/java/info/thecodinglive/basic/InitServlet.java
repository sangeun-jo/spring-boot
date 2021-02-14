package info.thecodinglive.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name="Init", urlPatterns = {"/init"},
        initParams = { @WebInitParam(name = "siteName", value = "jpub") }
        )
public class InitServlet extends HttpServlet {
    private String myParam = "";
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init call");
        this.myParam = servletConfig.getInitParameter("siteName");
        System.out.println("Site Name is " + myParam);
    }
}
