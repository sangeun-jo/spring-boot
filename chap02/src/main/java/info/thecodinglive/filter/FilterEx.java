package info.thecodinglive.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("*.jsp") //url에 상관없이 기존 jsp 파일에 적용
public class FilterEx implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.println("필터 동작 전"); //클라이언트의 요청에 대비해 미리 해놓을 작업
        chain.doFilter(req, res);
        out.println("필터 동작 후"); //클라이언트의 요청 후 할 작업
    }
    @Override
    public void destroy(){

    }
}
