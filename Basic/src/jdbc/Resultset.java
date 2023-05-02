package jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class Resultset {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("Basic\\src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        // 1. 注册驱动
        Class.forName(driver);//建议写上
        // 2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 3. 得到Statement
        Statement statement = connection.createStatement();
        //4. 组织 SqL
        String sql = "select id, name , sex, borndate from actor";

        ResultSet resultSet = statement.executeQuery(sql);
        //5. 使用 while 取出数据
        while (resultSet.next()) { // 让光标向后移动，如果没有更多行，则返回 false
            int id = resultSet.getInt(1); //获取该行的第 1 列
            //int id1 = resultSet.getInt("id"); 通过列名来获取值, 推荐
            String name = resultSet.getString(2);//获取该行的第 2 列
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        //6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
