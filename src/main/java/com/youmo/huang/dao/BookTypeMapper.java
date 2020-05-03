package com.youmo.huang.dao;

import com.youmo.huang.bean.BookType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 2257
 * @date 2020/4/25 - 0:18
 */
@Mapper
public interface BookTypeMapper {

    //添加
    public Integer save(BookType BookType);

    //删除
    public void delete(Long no);

    //修改
    public void update(BookType BookType);

    //查询全部
    public List<BookType> getList();

    //根据编号查询
    public BookType getOne(Long no);
}
