package jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConn {
    // 方式1
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver(); //创建 driver 对象
        String url = "jdbc:mysql://localhost:3306/gxy_db01";
        //将 用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "123456"); //密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式 2
    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //使用反射加载 Driver 类 , 动态加载，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/gxy_db01";
        //将 用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        //说明 user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");// 用户
        properties.setProperty("password", "123456"); //密码
        Connection connect = driver.connect(url, properties);
        System.out.println("方式 2=" + connect);
    }

    //方式 3 使用 DriverManager 替代 driver 进行统一管理
    @Test
    public void connect03() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        //使用反射加载 Driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //创建 url 和 user 和 password
        String url = "jdbc:mysql://localhost:3306/gxy_db01";
        String user = "root";
        String password = "123456";
        DriverManager.registerDriver(driver);//注册 Driver 驱动
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种方式=" + connection);
    }

    //方式 4: 使用 Class.forName 自动完成注册驱动，简化代码
    //这种方式获取连接是使用的最多，推荐使用
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //创建 url 和 user 和 password
        String url = "jdbc:mysql://localhost:3306/gxy_db01";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第 4 种方式~ " + connection);
    }

    //方式 5 , 在方式 4 的基础上改进，增加配置文件，让连接 mysql 更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("Basic\\src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);//建议写上
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式 5 " + connection);
    }
}