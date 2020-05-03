package com.youmo.huang.dao;

import com.youmo.huang.bean.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 2257
 * @date 2020/4/25 - 0:18
 */
@Mapper
public interface BookMapper {

    //添加
    public Integer save(Book book);

    //删除
    public void delete(Long no);

    //修改
    public void update(Book book);

    //查询全部
    public List<Book> getList();

    //根据编号查询
    public Book getOne(Long no);

}
