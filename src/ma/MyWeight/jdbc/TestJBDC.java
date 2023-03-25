package ma.MyWeight.jdbc;

import ma.MyWeight.modéle.Weight;

import java.sql.*;

public class TestJBDC {

    public static void main(String[] args) {
        var url ="jdbc:mysql://localhost:3306/MyWeight" ;
        var login ="root";
        var pass ="";
        var driver ="com.mysql.cj.jdbc.Driver";
        Connection connection = null ;
        Statement statement = null;
        PreparedStatement sc = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultMetaDta = null;

        try {
            Class.forName(driver);
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection(url, login, pass);
            System.out.println("Database connected");

            //Statement
            sc=connection.prepareStatement("select * from Weight ");
            resultSet = sc.executeQuery();
            resultMetaDta = resultSet.getMetaData();
            // METHODE 1
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            while (resultSet.next()){
//                for (int i =1;i<=resultMetaDta.getColumnCount();i++)
//
//                    System.out.print("\t"+resultMetaDta.getColumnName(i).toUpperCase()+
//                            " : "+resultSet.getObject(i).toString() + "\t |");
//                System.out.println();
//                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//
//            }
            // METHODE 2
            while (resultSet.next()){

                System.out.println("=========================================================");
                System.out.println("                        Weight                          ");
                System.out.println("=========================================================");
                System.out.println("#ID        :   "+ resultSet.getInt("id"));
                System.out.println("+Name     :   "+ resultSet.getString("name"));
                System.out.println("+Sexe     :   "+ resultSet.getString("sexe"));
                System.out.println("+Age     :   "+ resultSet.getDouble("age"));
                System.out.println("-Poid    :   "+ resultSet.getDouble("poids")+ " KG");
                System.out.println("-Taille  :   "+ resultSet.getInt("height")+" CM");
                System.out.println("-Description      :   "+ resultSet.getString("description"));
                System.out.println("-BMI :   "+ resultSet.getDouble("bmi")+" KG/CM");
                System.out.println("=========================================================");

            }




        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Database not connected");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Database not closed");
                }
            }

        }
    }
}