package com.atmoon.mybatis;

import com.atmoon.mybatis.bean.User;
import com.mysql.cj.jdbc.ConnectionImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: asuspc
 * @Date: 2018/12/10 23:12
 * @Description:
 */
public class JdbcTest {


    public static void main(String[] args) throws IOException{

        List<Dictionary> dictionaryList = new ArrayList();
        FindWords findWords = new FindWords();
        File file = new File("C:\\Users\\asuspc\\Desktop\\dic.txt");
        //File file2 = new File("C:\\Users\\asuspc\\Desktop\\dic2.txt");
        BufferedReader br1 =new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        //FileWriter writer = new FileWriter(file2, true);
        String temp;
        while((temp=br1.readLine()) != null){
            System.out.println(br1.readLine());
            if(temp.equals("")){
                continue;
            }
            else{
                Dictionary dictionary = new Dictionary();
                //System.out.println(temp);
                //writer.write(temp+"\n");
                String english = temp.substring(1,findWords.findMao(temp));
                String chinese = temp.substring(findWords.findleft(temp),findWords.findright(temp));
                dictionary.setEnglish(english);
                dictionary.setChinese(chinese);
                dictionaryList.add(dictionary);
            }
        }
        /*for (Dictionary dictionary:dictionaryList) {
            System.out.println(dictionary);
        }*/
        Connection conn;

        String url = "jdbc:mysql://localhost:3306/testmoon";
        String sql = "insert into dictionary(pid,english,chinese) values (?,?,?)";
        final int num = 1000;
        int count = 0;
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, "root", "admin123");
            // 建立Statement对象
            PreparedStatement ps = conn.prepareStatement(sql);
            for(Dictionary dictionary:dictionaryList){
                //System.out.println(dictionary);
                ps.setInt(1,count+1);
                ps.setString(2,dictionary.getEnglish());
                ps.setString(3,dictionary.getChinese());
                ps.addBatch();
                if(++count % num == 0){
                    System.out.println("-------"+count);
                    ps.executeBatch();
                }
            }
            ps.executeBatch();
            ps.close();
            conn.close();
            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }

}
