package org.changli.covermanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.changli.covermanager.entity.Cover;
import org.changli.covermanager.mapper.CoverMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

@MapperScan("org.changli.covermanager.mapper")
public class MyTest {

    @Autowired
    private CoverMapper userMapper;
    
	
    public static void main(String[] args) {
        //加载驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   
            Connection conn=DriverManager.getConnection("jdbc:mysql://rm-2zev8z6z1wiaey621ro.mysql.rds.aliyuncs.com:3306/covermanager?useUnicode=true&characterEncoding=utf-8","cover","Aa123456"); 
            System.out.println(conn);
            Statement createStatement = conn.createStatement();
            ResultSet rs =  createStatement.executeQuery("select * from cover");
            while(rs.next()){
                System.out.println(rs.getString("coverID")+" 年龄："+rs.getDouble("humidity"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void equals() {
    	System.out.println("%E7%A9%BA%E9%97%B2".equals("空闲"));
    }
    
}
