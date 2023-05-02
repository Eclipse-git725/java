package jdbc.jdbcutils;

import jdbc.Preparedstatement;
import org.junit.Test;

import java.sql.*;

public class JDBCUtils_Use {
    @Test
    public void testSelect(){
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个 sql
        String sql = "select * from actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建 PreparedStatement 对象
        try{
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            set = preparedStatement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }

    @Test
    public void testDML() throws SQLException {
        Connection connection = null;
        String sql = "update actor set name=? where id=?";
        PreparedStatement preparedstatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, "周润发");
            preparedstatement.setInt(2, 2);
            preparedstatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(set, preparedstatement, connection);
        }
    }
}
