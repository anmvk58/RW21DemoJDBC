package frontend;

import java.sql.*;

public class DemoInsert {
    public static void main(String[] args) throws SQLException {
        //Khai báo các tham số để khởi tạo connection với Database
        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment";
        String username = "root";
        String password = "root";

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Tạo câu insert:
        String sql = "INSERT INTO department (DepartmentID, DepartmentName) VALUES (?, ?)";

        // Tạo đối tượng Prepared Statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int n = 8;
        String s = "Phòng Kỹ Thuật Vận Hành";

        preparedStatement.setInt(1, n);
        preparedStatement.setString(2, s);

        try {
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Insert thành công: " + affectedRows + " bản ghi!");
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.print("Có lỗi xảy ra: ");
            System.out.println(e.getMessage());
        }
    }
}
