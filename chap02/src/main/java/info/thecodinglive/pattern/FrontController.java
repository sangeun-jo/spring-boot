package info.thecodinglive.pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(urlPatterns = "/controller", initParams = {@WebInitParam(name="mapping", value="/WEB-INF/command.properties")})
public class FrontController extends HttpServlet {
    private Properties cmdMapping;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        InputStream is = null;
        try {
            String location = config.getInitParameter("mapping");
            is = getServletContext().getResourceAsStream(location);
            cmdMapping = new Properties();
            cmdMapping.load(is);
        } catch (IOException e){
            getServletContext().log("I/O Error", e);
        } finally {
            try {
                is.close();
            } catch (IOException iog){

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cmd = req.getParameter("cmd"); //주소창 끝에 ?cmd='어쩌구' << 이런식으로 입력하면 '어쩌구' 얻어오기
        String cmdClass = (String) cmdMapping.get(cmd); //입력된 값을 클레스 이름으로 변경하기 ex) home이 입력되면 HomeView 클래스 이름 불러옴
        Command command = null;

        try {
            command = (Command)Class.forName(cmdClass).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex){
            getServletContext().log("class not found", ex);
        }

        command.setReq(req);
        command.setRes(res);
        command.setServletContext(getServletContext());
        command.execute();
    }
}
