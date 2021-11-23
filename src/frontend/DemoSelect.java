package frontend;

import java.sql.*;

public class DemoSelect {
    public static void main(String[] args) throws SQLException {
        //Khai báo các tham số để khởi tạo connection với Database
        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment";
        String username = "root";
        String password = "root";

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Khởi tạo đối tượng Statement từ Connection
        Statement statement = connection.createStatement();

        // Chạy câu lệnh và hứng kết quả vào Result Set
        ResultSet resultSet = statement.executeQuery("SELECT * FROM department");

        // In kết quả ra màn hình:
        while(resultSet.next()){
            System.out.print(resultSet.getString(1));
            System.out.print(" | ");
            System.out.println(resultSet.getString("DepartmentName"));
        }

    }
}
