package info.thecodinglive.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(urlPatterns = "/upload", name="uploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //2MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 50, //50MP
        location = "d:/upload" //save location
)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        final String path = req.getParameter("destination");  //path
        final Part filePart = req.getPart("file"); //file
        final String fileName = getFileName(filePart); //filename
        final PrintWriter writer = resp.getWriter();

        try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
             InputStream filecontent = filePart.getInputStream()) {
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1){
                out.write(bytes, 0, read);
            }

            writer.print("new file: " + fileName + ", created in " + path);
        } catch (FileNotFoundException fne){
            System.out.println(fne.getMessage());
        }
    }


    private String getFileName(final Part part){
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("Part Header = {0}" + partHeader);
        for (String content: part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
