package info.thecodinglive.pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//url 받으면 연결해주는 녀석 ..옛날에 전화 연결해주던 전화원st
public abstract class Command { //abstract- 추상 메서드를 하나 이상 포함하는 클래스
    private HttpServletRequest req;
    private HttpServletResponse res;
    private ServletContext servletContext;

    abstract public void execute(); //추상 메서드

    public void forward(String url){
        try{
            RequestDispatcher rd = req.getRequestDispatcher(url);
            rd.forward(getReq(), getRes());
        } catch (IOException ioe){
            servletContext.log("forward Error", ioe);
        } catch (ServletException servletEx){
            servletContext.log("servlet Error", servletEx);
        }
    }

    // Command는 서블릿 클레스가 아니므로, stter getter 메서드 필요

    public HttpServletRequest getReq(){
        return req;
    }

    public HttpServletResponse getRes() {
        return res;
    }

    public ServletContext getServletContext(){
        return servletContext;
    }

    public void setReq(HttpServletRequest req){
        this.req = req;
    }

    public void setRes(HttpServletResponse res){
        this.res = res;
    }

    public void setServletContext(ServletContext servletContext){
        this.servletContext = servletContext;
    }
}
