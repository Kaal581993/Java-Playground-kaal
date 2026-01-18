package sprint.first.tut;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JDBDemo {
    private static final String URL ="jdbc:mysql://localhost:3306/demo_db";
    private static final String USER="root";
    private static final String PASSWORD="MySQL123";


    public static void main(String[] args) {
        //Connection conn =null;

        //try with resources
        try (Connection conn =  DriverManager.getConnection(URL,USER,PASSWORD);){
            System.out.println("Database connection established Successfully");
         //   insertStudent(conn, "Kaal","kaal@kaal.com");
            selectStudent(conn);
                updateStudent(conn,2, "Viral", "viral@kaal.com");
            selectStudent(conn);
            deleteStudent(conn,4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, String name, String email){
        String sql ="INSERT INTO Student (name, email) VALUES('"+name+"','"+email+"')";

            try(Statement stmt = conn.createStatement()){
                int rows = stmt.executeUpdate(sql);
                System.out.println("Inserted "+rows+" rows");
            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }

    private static void selectStudent(Connection conn){
        String sql ="SELECT * FROM Student;";

        try(Statement stmt = conn.createStatement()){
            ResultSet result= stmt.executeQuery(sql);
            System.out.println("Table contents:"+result);
            while (result.next()){
                int id=result.getInt("id");
                String name = result.getString("name");
                String email=result.getString("email");
                System.out.println("id: "+id+" name: "+name+" email: "+email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateStudent(Connection conn, int id, String name, String email){
        String sql = "UPDATE Student SET name=?, email=? where id=? Limit 1";
//UPDATE Student SET name='Viral', email='viral@kaal.com' where id=1 limit 1
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1,name);
                pstmt.setString(2,email);
                pstmt.setInt(3, id);
                int rows = pstmt.executeUpdate();
                System.out.println("Updated "+rows+" rows");
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    private static void deleteStudent(Connection conn, int id){
        String sql = "DELETE from Student where id="+id;
//UPDATE Student SET name='Viral', email='viral@kaal.com' where id=1 limit 1
        try(Statement stmt = conn.createStatement()){
            int rows = stmt.executeUpdate(sql);
            System.out.println("Deleted "+rows+" rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



/**
 *
 *
 *    try {
 *              conn = DriverManager.getConnection(URL,USER,PASSWORD);
 *             System.out.println("Database connection established Successfully");
 *         } catch (SQLException e) {
 *             e.printStackTrace();
 *         }finally {
 *             try {
 *                 conn.close();
 *                 System.out.println("Connection closed!");
 *             } catch (SQLException e) {
 *                 throw new RuntimeException(e);
 *             }
 *
 *
 *
 *
 * */