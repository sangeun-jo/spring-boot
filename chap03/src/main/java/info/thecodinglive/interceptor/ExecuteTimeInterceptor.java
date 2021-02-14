package info.thecodinglive.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(
            HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        req.setAttribute("startTime", startTime);
        String reqUri = req.getRequestURI();
        System.out.println("reqUri: " + reqUri);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest req, HttpServletResponse res,
            Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long)req.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        req.setAttribute("executeTime", executeTime);
        System.out.println("[" + handler + "] executeTime: " + executeTime + "ms");
    }
}
