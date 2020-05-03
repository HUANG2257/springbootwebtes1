package com.youmo.huang.bean;

import java.util.Date;

/**
 * @author 2257
 * @date 2020/4/23 - 14:33
 */
public class Book {

    private Long no;
    private String name;
//    private Long type_no;
    private BookType bookType;
    private Double price;
    private Date pub_time;
    private String outhor;
    private String pub_company;

    public Book() {
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pub_time=" + pub_time +
                ", outhor='" + outhor + '\'' +
                ", pub_company='" + pub_company + '\'' +
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


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPub_time() {
        return pub_time;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }

    public String getOuthor() {
        return outhor;
    }

    public void setOuthor(String outhor) {
        this.outhor = outhor;
    }

    public String getPub_company() {
        return pub_company;
    }

    public void setPub_company(String pub_company) {
        this.pub_company = pub_company;
    }
}
