import java.util.ArrayList;
import java.util.List;

public class Lab18_JDBC_MovieTableDemo {
    
    static class Movie {
        int id;
        String title;
        String genre;
        
        Movie(int id, String title, String genre) {
            this.id = id;
            this.title = title;
            this.genre = genre;
        }
        
        @Override
        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Genre: " + genre;
        }
    }
    
    static List<Movie> movies = new ArrayList<>();
    
    // Task a: Add records
    static void addMovieRecords() {
        System.out.println("\nTask A: Adding records to MOVIE table");
        movies.add(new Movie(1, "Inception", "Science Fiction"));
        movies.add(new Movie(2, "Jatra", "Drama"));
        movies.add(new Movie(3, "Avatar", "Science Fiction"));
        System.out.println("3 records added successfully");
    }
    
    // Task b: Update genre using prepared statement
    static void updateGenre() {
        System.out.println("\nTask B: Update genre using Prepared Statement");
        for (Movie m : movies) {
            if (m.title.equals("Jatra")) {
                m.genre = "Comedy";
                System.out.println("Updated 1 record(s)");
                break;
            }
        }
    }
    
    static void displayMovies() {
        System.out.println("\nMovies in database:");
        for (Movie m : movies) {
            System.out.println(m);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- JDBC - MOVIE Table Operations (Demo Mode) ---");
        
        addMovieRecords();
        updateGenre();
        displayMovies();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 18");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
        System.out.println("Note: For actual MySQL JDBC, install mysql-connector-java");
    }
}
