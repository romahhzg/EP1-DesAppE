package isil.jdbc;

import java.sql.*;

public class MainApp {

    public static void main(String[] var) throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/EP1";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conexion = DriverManager.getConnection(jdbcUrl, "root", "root");

        //Statement st = con.createStatement();
        //testPreparedStatement(conexion);
        testCallableStatement(conexion);

        conexion.close();
    }

        //ResultSet rs = st.executeQuery("select * from Users");

        //while(rs.next()){
            //System.out.println(rs.getString("id") + " " +
                    //rs.getString("name") +
                    //" " + rs.getString("lastname") +
                    //" " + rs.getString("age") +
                    //" " + rs.getString("city") +
                    //" " + rs.getString("phone"));
        //}

            //Insertar con Statement
            //int filasAfectadas = st.executeUpdate("insert into Users values(6,'Sussy',' Paredes' ,'38', 'Tumbes', '915357468')");

            //System.out.println("Filas afectadas: "+filasAfectadas);

        //public static void testStatement(Connection connection) throws Exception{ }

        public static void testPreparedStatement(Connection connection) throws Exception{

            //Actualizar con PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("update Users set name=? where id=?");
            preparedStatement.setString(1,"Enrique");
            preparedStatement.setInt (2,3);

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("Filas afectadas: " + affectedRows);

        }

        public static void testCallableStatement(Connection connection) throws Exception{

        CallableStatement cs = connection.prepareCall("{call getAllUsers()}");
        ResultSet rs = cs.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("id") + " " +
                rs.getString("name") + " " +
                " " + rs.getString("lastname") + " " +
                " " + rs.getString("age") + " " +
                " " + rs.getString("city") + " " +
                " " + rs.getString("phone"));
                }
        }

}
