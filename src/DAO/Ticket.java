package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket {
    public void saveTicket(int id, int userId, String ticketType, String creationDate) throws SQLException {
        String sql = "INSERT INTO public.ticket (id, user_id, ticket_type, creation_date) " +
                "VALUES (?, ?, ?::ticket_type, ?)";
        try  (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setInt(2, userId);
            statement.setString(3, ticketType);
            statement.setString(4, creationDate);
            statement.executeUpdate();
        }
    }


    public void fetchTicketsByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM public.ticket WHERE user_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("User ID: " + resultSet.getInt("user_id"));
                System.out.println("Ticket Type: " + resultSet.getString("ticket_type"));
                System.out.println("Creation Date: " + resultSet.getString("creation_date"));
            }
        }
    }
}
