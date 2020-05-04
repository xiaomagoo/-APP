package com.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.pkcs11.Secmod;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/*
数据库连接池
 */
public class DBConnection {
    private static String JDBCPath;
    private static String url;
    private static String user;
    private static String password;
    private static Connection conn;
    public static Connection  getConn() {
        try {
            Properties pro=new Properties();//创建一个Properties实例对象
            ClassLoader classLoader =DBConnection.class.getClassLoader();//获取当前类的类加载器
            //获取指定资源的字节输入流
            InputStream in = classLoader.getResourceAsStream("jdbcInfo.properties");
            try {
                pro.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取指定的键的值。
            JDBCPath=pro.getProperty("JDBCPath");
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            Class.forName(JDBCPath);
            DBConnection.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }
    public static void closeAll(ResultSet rs, PreparedStatement psm, Connection conn) {
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if(psm!=null)
            try {
                psm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if(conn!=null)
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}
