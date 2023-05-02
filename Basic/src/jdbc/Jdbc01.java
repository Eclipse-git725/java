package jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1. 注册驱动
        Driver driver = new Driver(); //创建 driver 对象
        String url = "jdbc:mysql://localhost:3306/gxy_db01";

        //2. 得到连接
        //将 用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "123456"); //密码
        Connection connect = driver.connect(url, properties);
        //3. 执行 sql
//        String sql = "insert into actor values(null, '周星驰', '男', '1970-11-11', '110')";
        String sql = "update actor set name='刘德华' where id = 1";
//        String sql = "delete from actor where id = 1";
        //statement 用于执行静态 SQL 语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是 dml 语句，返回的就是影响行数
        System.out.println(rows > 0 ? "成功" : "失败");
        //4. 关闭连接资源
        statement.close();
        connect.close();
    }
}
