package com.youmo.huang.bean;

/**
 * @author 2257
 * @date 2020/4/23 - 14:33
 */
public class BookType {

    private Long no;
    private String name;

    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
