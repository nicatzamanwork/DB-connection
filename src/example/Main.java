package org.example;
public class Main {
    public static void main(String[] args) {
        UserTable userDao = new UserTable();
        Ticket ticketDao = new Ticket();

        try {
            userDao.saveUser(3, "John Doe", "2024-12-09");

            userDao.fetchUserById(3);

            ticketDao.saveTicket(3, 3, "DAY", "2024-12-09");

            ticketDao.fetchTicketsByUserId(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
