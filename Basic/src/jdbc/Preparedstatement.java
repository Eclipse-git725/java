package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Preparedstatement {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("Basic\\src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select name , sex, borndate from actor where id=?";
        PreparedStatement preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setInt(1, 1);
        ResultSet resultset = preparedstatement.executeQuery();
        if(resultset.next()){
            System.out.println("成功");
        }else {
            System.out.println("成功");
        }

        preparedstatement.close();
        resultset.close();
        connection.close();
    }
}
