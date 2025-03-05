import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class peopleDatabase {

    // Method to connect to the SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            // SQLite connection string
            String url = "jdbc:sqlite:people.db"; // Creates a local DB named 'people.db'
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // Method to create a table in the database
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS people (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " age INTEGER,\n"
                + " gender TEXT\n"
                + ");";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
            System.out.println("Table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to insert a person into the database
    public static void insertPerson(String name, int age, String gender) {
        String sql = "INSERT INTO people(name, age, gender) VALUES(?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.executeUpdate();
            System.out.println("Person added.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createTable(); // Create the table

        // Add people to the database
        insertPerson("Alice", 30, "Female");
        insertPerson("Bob", 25, "Male");
        insertPerson("Charlie", 35, "Male");
    }
}
