package com.so.soconfig.server;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoconfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoconfigServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner configServerRunner()  {
        return x -> {
            testAll();
        };
    }

    private void testAll() {
        String url = "jdbc:h2:~/h2";
        String username = "root"; // H2数据库的默认用户名
        String password = "123456"; // H2数据库的默认密码

        Connection conn = null;
        try {
            // 加载H2数据库驱动
            Class.forName("org.h2.Driver");
            // 建立连接
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to H2 database established.");
            // 获取DatabaseMetaData对象
            DatabaseMetaData metaData = conn.getMetaData();

            System.out.println(conn.getSchema());
            System.out.println(conn.getMetaData());
            List<String> tableNames = new ArrayList<>();
            metaData.getTables(null, null, "%", new String[]{"TABLE"});
            // 获取指定模式下的所有表
            ResultSet rs = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            // 遍历结果集，将表名添加到列表中
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                tableNames.add(tableName);
            }
            // 打印所有表名
            for (String name : tableNames) {
                System.out.println(name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
