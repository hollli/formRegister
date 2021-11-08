package ua.edu.chdtu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("static/index.html");
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phonecode = req.getParameter("phonecode");
        String tel = req.getParameter("tel");
        String job = req.getParameter("job");

        //TODO implement JSON data
        resp.getWriter().write("<h1>JSON: " + convertDataToJSON(fullName,email,phonecode,tel,job)+"</h1>");
    }

    private String convertDataToJSON(String fullName, String email,String phonecode,String tel,String job) {

        String jsonData = "{" +
                "\"fullName\": \"" + fullName + "\"" +
                "\"email\": \"" + email + "\"" +
                "\"phonecode\": \"" + phonecode + "\"" +
                "\"tel\": \"" + tel + "\"" +
                "\"job\": \"" + job + "\"" +
                "}";
        return jsonData;
    }

}
