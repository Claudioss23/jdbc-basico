package conexão;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {
    public static void main(String[] args) {

        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";

        try (Connection conn = DriverManager.getConnection(urlConnection, "Claudio", "clauh129")) {
            System.out.println("Sucesso!");
        } catch (Exception e) {
            System.out.println("Falha!");
        }
    }
}