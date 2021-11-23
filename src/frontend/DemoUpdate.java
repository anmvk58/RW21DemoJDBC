package frontend;

import java.sql.*;

public class DemoUpdate {
    public static void main(String[] args) throws SQLException {
        //Khai báo các tham số để khởi tạo connection với Database
        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment";
        String username = "root";
        String password = "root";

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Tạo câu update:
        String sql = "UPDATE department SET departmentName = ? WHERE departmentId = ?";

        // Tạo đối tượng Prepared Statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int n = 9;
        String s = "Phòng Họp Lớn";

        preparedStatement.setString(1, s);
        preparedStatement.setInt(2, n);

        try {
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Update thành công: " + affectedRows + " bản ghi!");
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.print("Có lỗi xảy ra: ");
            System.out.println(e.getMessage());
        }
    }
}
