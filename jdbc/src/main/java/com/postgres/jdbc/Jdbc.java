package com.postgres.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author postgresqltutorial.com
 */
public class Jdbc {

    private final String url = "jdbc:postgresql://localhost/test";
    private final String user = "postgres";
    private final String password = "4546";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws java.sql.SQLException
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * Get all rows in the actor table
     */
    public void getEmployee() {

        String SQL = "SELECT employeeid,employeename, employeeaddress FROM employee";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayActor(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Get actors count
     * @return
     */
     public int getEmpCount() {
        String SQL = "SELECT count(*) FROM employee";
        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

    /**
     * Display actor
     *
     * @param rs
     * @throws SQLException
     */
    private void displayActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getInt("employeeid") + "\t"
                    + rs.getString("employeename") + "\t"
                    + rs.getString("employeeaddress"));

        }
    }

    /**
     * Find actor by his/her ID
     *
     * @param actorID
     */
    public void findEmpByID(int employeeid) {
        String SQL = "SELECT employeeid,employeename,employeeaddress "
                + "FROM employee "
                +"Where employeeid = ? ";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, String.valueOf(employeeid));
            ResultSet rs = pstmt.executeQuery();
            displayActor(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc main = new Jdbc();
        main.getEmployee();
        main.findEmpByID(1);
        System.out.println("total : "+main.getEmpCount());
    }
}