package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "hello", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().append("hello from Servlet: " + req.getMethod());
        HttpSession session = req.getSession();
        if(session.getValue("name") == null){
            session.putValue("name", "\nmy session");
            res.getWriter().append("\n=========== No session ==============");
        }else{
            res.getWriter().append((String)session.getValue("name"));
        }
    }
    
}
