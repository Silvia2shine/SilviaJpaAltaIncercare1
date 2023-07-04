import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSMelodyRepository {

    public JdbcSMelodyRepository() {
        getConnection();
    }
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/audioDb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "ROOT";

//o metoda cu care sa ne conectam la baza de date,
// pusa si in costructor, ca de fiecare data cand instantiem clasa sa fin siguri ca
//avem conexiune
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Can't connect to the db" + e.getMessage());
        }
    }

    public List<Melody> getAllMelody() {
        List<Melody> melodyList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM 'public.audioDb'")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String audioLink = resultSet.getString("audioLink");

                Melody melody = new Melody();
                melody.setId(id);
                melody.setName(name);
                melody.setAudioLink(audioLink);

                melodyList.add(melody);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return melodyList;
    }

    public void addMelody(Melody melody) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO audioDb (name, audioLink) VALUES (?, ?)")) {

            statement.setString(1, melody.getName());
            statement.setString(2, melody.getAudioLink());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}