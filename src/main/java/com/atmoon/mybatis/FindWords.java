package com.atmoon.mybatis;

/**
 * @auther: asuspc
 * @Date: 2019/1/4 22:45
 * @Description:
 */
public class FindWords {

    public static void main(String[] args) {
        //$a:"n. A As 或 A''s  安 ampere  a  art.一 n.字母A  [军] Analog.Digital 模拟 数字   =account of  帐上",
        FindWords findWords = new FindWords();
        String a = "$a:\"n. A As 或 A''s  安 ampere  a  art.一 n.字母A  [军] Analog.Digital 模拟 数字   =account of  帐上\",";
        //System.out.println(a.indexOf(":"));
        System.out.println(a.substring(1,findWords.findMao(a)));
        //System.out.println(findWords.findMao(a));
        System.out.println(a.substring(findWords.findleft(a),findWords.findright(a)));
    }

    public int findMao(String string){
        int index = -1;
        index = string.indexOf(":");
        return index;
    }

    public int findleft(String string){
        int index = -1;
        index = string.indexOf(":\"")+2;
        return index;
    }
    public int findright(String string){
        int index = -1;
        index = string.indexOf("\",");
        if(index<0){
            index = string.indexOf("],");
        }
        return index;
    }
}
