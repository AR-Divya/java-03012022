package service;

import java.sql.*;

public class DbServices {
    private final Connection connection;

    public DbServices(Connection connection) {
        this.connection = connection;
    }

    public int createNewAccount(int acNum, String acHldNm, double amt, Date crDt, boolean status) throws SQLException {
        var sql = "insert into cust_info values(?, ?, ?, ?, ?)";
        var ps1 = connection.prepareStatement(sql);
        ps1.setInt(1, acNum);
        ps1.setString(2, acHldNm);
        ps1.setDouble(3, amt);
        ps1.setDate(4, crDt);
        ps1.setBoolean(5, status);

        var affected = ps1.executeUpdate();
        connection.commit();

        return affected;

    }

    public void printAllAccounts() throws SQLException {
        String sql = "select * from cust_info";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ac_num");
            String nm = rs.getString("ac_hld_nm");
            double amt1 = rs.getDouble("amount");
            Date dob = rs.getDate("ac_cre_dt");
            boolean sts = rs.getBoolean("status");

            System.out.println(" acc num : " + id + "Name " + nm +  " amount : " + amt1  + " dob : " + dob.toString() + " status : " + sts);
        }
        connection.commit();
        rs.close();
    }
    public void displayBalance(int acNum) throws SQLException {
        String sql = "select amount,ac_hld_nm from cust_info where ac_num =?";
        PreparedStatement ps2 = connection.prepareStatement(sql);

        ps2.setInt(1, acNum);
        ResultSet rs = ps2.executeQuery();
        while (rs.next()) {
            double amt2 = rs.getDouble("amount");
            String nm1 = rs.getString("ac_hld_nm");
            System.out.println("Name :" + nm1 + "  balance  :" + amt2);

        }
        connection.commit();
        rs.close();
    }
}