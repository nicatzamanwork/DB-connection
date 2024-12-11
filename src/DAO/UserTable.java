package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {
    public void saveUser(int id, String username, String creationDate) throws SQLException {
        String sql = "INSERT INTO public.user_table (id, name, creation_date) VALUES (?, ?, ?)";
        try  (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, creationDate);
            statement.executeUpdate();
        }
    }

    public void fetchUserById(int id) throws SQLException {
        String sql = "SELECT * FROM public.user_table WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("name"));
                System.out.println("Creation Date: " + resultSet.getString("creation_date"));
            }
        }
    }
}
