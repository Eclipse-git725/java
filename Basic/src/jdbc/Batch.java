package jdbc;

import jdbc.jdbcutils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

// 批处理
public class Batch {
    // 传统方法插入5000条数据
    @Test
    public void nobatch() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {//5000 执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时=" + (end - start));//传统的方式 耗时=8374
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
    //使用批量方式添加数据
    @Test
    public void batch() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for(int i = 0; i < 5000; i ++ ){
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            // 批量处理会减少我们发送 sql 语句的网络开销，而且减少编译次数，因此效率提高
            preparedStatement.addBatch();
            //当有 1000 条记录时，在批量执行
            if((i + 1) % 5000 == 0) {//满 1000 条 sql
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时=" + (end - start));//批量方式 耗时=8370???
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
