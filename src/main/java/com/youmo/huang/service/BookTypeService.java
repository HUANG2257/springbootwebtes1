package com.youmo.huang.service;

import com.youmo.huang.bean.Book;
import com.youmo.huang.bean.BookType;
import com.youmo.huang.dao.BookTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 2257
 * @date 2020/4/25 - 0:17
 */
@Service
public class BookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    public Integer save(BookType bookType){
        Integer i = bookTypeMapper.save(bookType);
        return i;
    }

    public void delete(Long type_no){
        bookTypeMapper.delete(type_no);
    }

    public void update(BookType bookType){
        bookTypeMapper.update(bookType);
    }

    //查询全部
    public List<BookType> getList(){
        List<BookType> list = bookTypeMapper.getList();
        return list;
    }

    //根据编号查询
    public BookType getByNo(Long type_no){
        BookType one = bookTypeMapper.getOne(type_no);
        return one;
    }
    
}
