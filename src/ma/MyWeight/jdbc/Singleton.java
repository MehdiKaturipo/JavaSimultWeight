package ma.MyWeight.jdbc;

import javax.swing.*;
import java.sql.*;

public class Singleton {
    private static Connection connection;
    private Singleton(){
        var url ="jdbc:mysql://localhost:3306/MyWeight" ;
        var login ="root";
        var pass ="";
        var driver ="com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, pass);
            JOptionPane.showMessageDialog(null,
                    "Database connected with MyWeight database",
                    "Session ouverte",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "ERREUR  DE CONNECION",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getConnection(){
        if(connection == null) new Singleton();
        else System.out.println("Connection already exists");
        return connection;
    }

    public static void main(String[] args) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Weight");
            Statement st = getConnection().createStatement();
                           getConnection().setAutoCommit(false);
            DatabaseMetaData meta = getConnection().getMetaData();

        }catch (SQLException e){
           e.printStackTrace();
        }
    }

}
