package com.atmoon.mybatis;

/**
 * @auther: asuspc
 * @Date: 2019/1/4 22:42
 * @Description:
 */
public class Dictionary {
    private String english;

    private String chinese;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "english='" + english + '\'' +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}
