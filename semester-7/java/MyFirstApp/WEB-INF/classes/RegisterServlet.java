import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private String dbPath;

    @Override
    public void init() throws ServletException {
        dbPath = getServletContext().getRealPath("/") + "myapp.db";
        try {
            Class.forName("org.h2.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:h2:" + dbPath)) {
                con.createStatement().executeUpdate(
                    "CREATE TABLE IF NOT EXISTS users (username VARCHAR(100) PRIMARY KEY)"
                );
            }
        } catch (Exception e) {
            throw new ServletException("DB init failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Registered users:</h2><ul>");
        try (Connection con = DriverManager.getConnection("jdbc:h2:" + dbPath)) {
            ResultSet rs = con.createStatement().executeQuery("SELECT username FROM users");
            while (rs.next()) {
                out.println("<li>" + rs.getString("username") + "</li>");
            }
        } catch (Exception e) {
            out.println("<li>DB error: " + e.getMessage() + "</li>");
        }
        out.println("</ul><a href='index.html'>Back</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nameInput = request.getParameter("username");
        
        // Insert into database
        try (Connection con = DriverManager.getConnection("jdbc:h2:" + dbPath)) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?)");
            ps.setString(1, nameInput);
            ps.executeUpdate();
        } catch (Exception e) {
            // user might already exist — ignore for simplicity
        }
        
        Cookie cookie = new Cookie("lastUser", nameInput);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        
        HttpSession session = request.getSession();
        session.setAttribute("savedName", nameInput);
        response.sendRedirect("welcome.jsp");
    }
}