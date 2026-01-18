package sprint.first.tut;

import java.sql.*;

public class TransactionsDemo {
    private static final String URL ="jdbc:mysql://localhost:3306/demo_db";
    private static final String USER="root";
    private static final String PASSWORD="MySQL123";

    public static void main(String[] args) {
        //Connection conn =null;

        //try with resources
        try (Connection conn =  DriverManager.getConnection(URL,USER,PASSWORD);){
            System.out.println("Database connection established Successfully");
            //  Order, OrderItems

            //TURN OFF AUTO COMMIT
            conn.setAutoCommit(false);
            try {
                //INSERT INTO Order
                int orderID = insertOrder(conn, 101, "Kaal", 500.50);
                //INSERT INTO OrderItems
                insertOrderItem(conn, orderID, "Toys", 5, 200.50);

                conn.commit();
                System.out.println("Transaction committed successfully");
            }catch (Exception e){
                e.printStackTrace();
                conn.rollback();
                System.out.println("Operation rollback complete!");
            }finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertOrderItem(Connection conn, int orderID, String product_name, int quantity, double price) {
        String sql="insert into order_items (order_id, product_name, quantity, price) values(?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,orderID);
            pstmt.setString(2, product_name);
            pstmt.setInt(3,quantity);
            pstmt.setDouble(4,price);
            int rows=pstmt.executeUpdate();
            System.out.println("INSERTED into order_items:"+rows);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static int insertOrder(Connection conn, int id, String name, double totalamount) {
        String sql="insert into orders (user_id, customer_name,  total_amount) values(?,?,?)";

        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setDouble(3,totalamount);
            int rows=pstmt.executeUpdate();
            System.out.println("INSERTED into orders:"+rows);
            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if(rs.next()){
                    int orderID= rs.getInt(1);
                    System.out.println("ORDER ID:"+orderID);
                    return orderID;
                }else {
                    throw new SQLException("Order ID not generated");
                }
            }catch (Exception e){
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

}
}

;
/**
 *     private static int insertOrder(Connection conn, int customerId, String customerName, double price) {
 *         String sql = "INSERT INTO orders (user_id, customer_name, total_amount) " +
 *                 "VALUES (?, ?, ?)";
 *         try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
 *             pstmt.setInt(1, customerId);
 *             pstmt.setString(2, customerName);
 *             pstmt.setDouble(3, price);
 *             int rows = pstmt.executeUpdate();
 *             System.out.println("INSERTED into orders: " + rows);
 *
 *             try (ResultSet rs = pstmt.getGeneratedKeys()) {
 *                 if (rs.next()) {
 *                     int orderId = rs.getInt(1);
 *                     System.out.println("ORDER ID: " + orderId);
 *                     return orderId;
 *                 } else {
 *                     throw new SQLException("Order ID not generated");
 *                 }
 *             }
 *         } catch (SQLException e) {
 *             throw new RuntimeException(e);
 *         }
 *
 *
 *     }
 */
