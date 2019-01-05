package com.atmoon.mybatis;

/**
 * @auther: asuspc
 * @Date: 2019/1/5 22:08
 * @Description:
 */
import com.atmoon.mybatis.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class DictionaryAppMain extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textinput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DictionaryAppMain frame = new DictionaryAppMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DictionaryAppMain() throws Exception {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("FastDictionary");
        setBounds(100, 100, 503, 588);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textinput = new JTextField();
        textinput.setFont(new Font("宋体", Font.PLAIN, 15));
        textinput.setBounds(81, 72, 218, 32);
        contentPane.add(textinput);
        textinput.setColumns(10);

        final JTextArea textresult = new JTextArea();
        textresult.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        textresult.setBounds(81, 157, 328, 338);
        textresult.setLineWrap(true);//激活自动换行功能
        textresult.setWrapStyleWord(true);//激活断行不断字功能
        contentPane.add(textresult);

        final JButton 查找 = new JButton("查找");
        查找.setFont(new Font("微软雅黑", Font.BOLD, 16));
        查找.setBounds(313, 72, 96, 27);
        contentPane.add(查找);
        查找.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource()==查找){
                    textresult.setText("");
                    String inputword =  textinput.getText();
                    System.out.println("查找"+inputword);
                    // 指定全局配置文件
                    String resource = "mybatis-config.xml";
                    // 读取配置文件
                    InputStream inputStream = null;
                    try {
                        inputStream = Resources.getResourceAsStream(resource);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    // 构建sqlSessionFactory
                    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    // 获取sqlSession
                    SqlSession sqlSession = sqlSessionFactory.openSession();
                    try {
                        // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
                        // 第二个参数：指定传入sql的参数：这里是用户id
                        List<Dictionary> dictionaryList = new ArrayList();
                        dictionaryList = sqlSession.selectList("MyMapper.queryAllWords", inputword);
                        for (Dictionary dictionary:dictionaryList) {
                            //System.out.println(dictionary);
                            textresult.append(dictionary.getEnglish()+":"+dictionary.getChinese()+"\n");
                        }

                    } finally {
                        sqlSession.close();
                    }
                }
            }
        });
    }


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
