package jdbc.transtion;

import jdbc.jdbcutils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transtion_ {
    // 没有使用事务
    @Test
    public void notransaction(){
        Connection connection = null;
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql
            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 3 条 sql
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
    // 使用事务解决
    @Test
    public void transaction(){
        Connection connection = null;
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); //开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql

            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 3 条 sql
            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的 SQL
            //默认回滚到事务开始的状态. System.out.println("执行发生了异常，撤销执行的 sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void homework(){
        // tom给king转10块
        Connection connection = null;
        String sql = "update account set balance = balance - 10 where id = 3";
        String sql2 = "update account set balance = balance + 10 where id = 4";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false); //开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql

//            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 3 条 sql
            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的 SQL
            //默认回滚到事务开始的状态. System.out.println("执行发生了异常，撤销执行的 sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
