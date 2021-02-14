package info.thecodinglive.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JpubInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(
            HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        System.out.println("preHandle method execute");
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest req, HttpServletResponse res,
            Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle method execute");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion method execute");
    }

    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(req, res, handler);

    }
}
