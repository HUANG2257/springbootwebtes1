package com.youmo.huang.service;

import com.youmo.huang.bean.Book;
import com.youmo.huang.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * @author 2257
 * @date 2020/4/25 - 0:17
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public Integer save(Book book){
        Integer i = bookMapper.save(book);
        return i;
    }

    public void delete(Long no){
        bookMapper.delete(no);
    }

    public void update(Book book){
        bookMapper.update(book);
    }

    //查询全部
    public List<Book> getList(){
        List<Book> list = bookMapper.getList();
        return list;
    }

    //根据编号查询
    public Book getByNo(Long no){
        Book one = bookMapper.getOne(no);
        return one;
    }


}
