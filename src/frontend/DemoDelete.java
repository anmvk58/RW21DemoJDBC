package frontend;

import java.sql.*;

public class DemoDelete {
    public static void main(String[] args) throws SQLException {
        //Khai báo các tham số để khởi tạo connection với Database
        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment";
        String username = "root";
        String password = "root";

        // Khởi tạo đối tượng connection tới DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Tạo câu update:
        String sql = "DELETE FROM department WHERE departmentId = ?";

        // Tạo đối tượng Prepared Statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int n = 1;
        preparedStatement.setInt(1, n);

        try {
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Delete thành công: " + affectedRows + " bản ghi!");
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.print("Có lỗi xảy ra: ");
            System.out.println(e.getMessage());
        } catch (SQLSyntaxErrorException e ){
            System.out.print("Có lỗi xảy ra: ");
            System.out.println(e.getMessage());
        }
    }
}
