import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab19_ScrollableResultSet {
    
    static final String DB_URL = "jdbc:mariadb://localhost:3306/movie_db";
    static final String USER = "root";
    static final String PASS = "password";
    
    public static void main(String[] args) {
        System.out.println("--- Scrollable ResultSet Navigation ---");
        
        String sql = "SELECT * FROM MOVIE";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\nNavigating to Last Row:");
            if (rs.last()) {
                System.out.println("Last row - ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Genre: " + rs.getString("genre"));
            }
            
            System.out.println("\nNavigating to First Row:");
            if (rs.first()) {
                System.out.println("First row - ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Genre: " + rs.getString("genre"));
            }
            
            System.out.println("\nNavigating to Third Row:");
            if (rs.absolute(3)) {
                System.out.println("Third row - ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Genre: " + rs.getString("genre"));
            } else {
                System.out.println("Third row does not exist");
            }
            
            System.out.println("\nAll records from ResultSet:");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Genre: " + rs.getString("genre"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 19");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
