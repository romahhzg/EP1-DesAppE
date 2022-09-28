package isil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] var) throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/EP1";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

        Statement st = con.createStatement();

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
            int filasAfectadas = st.executeUpdate("insert into Users values(6,'Sussy',' Paredes' ,'38', 'Tumbes', '915357468')");

            System.out.println("Filas afectadas: "+filasAfectadas);

    }
}
