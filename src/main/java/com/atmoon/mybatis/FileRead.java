package com.atmoon.mybatis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: asuspc
 * @Date: 2019/1/4 21:54
 * @Description:
 */
public class FileRead {
    public static void main(String[] args) throws IOException {
        /*try {
            FileReader fileReader = new FileReader("C:\\Users\\asuspc\\Desktop\\dic.txt");
            int aa;
            String content = null;
            try {
                aa = fileReader.read();
                content = "";
                while (aa != (-1)) {    //ASCII码是从0开始的数字，只有什么都没有才会返回-1
                    content += (char) aa;
                    System.out.print(content);
                    aa = fileReader.read(); //继续读取一个字符
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(content);
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
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
        for (Dictionary dictionary:dictionaryList) {
            System.out.println(dictionary);
        }

    }
}
