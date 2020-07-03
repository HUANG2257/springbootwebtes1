package com.youmo.huang.controller;

import com.youmo.huang.bean.Book;
import com.youmo.huang.bean.BookType;
import com.youmo.huang.service.BookService;
import com.youmo.huang.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 2257
 * @date 2020/4/25 - 0:17
 */
@Controller
@RequestMapping("/book")
public class BookController{

    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;

    @PostMapping("/saveOrUpdate")
    public String save(Book book, HttpSession session, MultipartFile pic){

        //上传文件
        upLoad(pic);

        Integer save = bookService.save(book);
        if(save > 0){
            return "redirect:/book/list";
        }
        session.setAttribute("addMsg","添加失败");
        return "/add";
    }

    @DeleteMapping("/delete/{no}")
    public String  delete(@PathVariable("no")Long no){
        bookService.delete(no);

        return "redirect:/book/list";
    }

    @PutMapping("/saveOrUpdate")
    public String update(Book book){
        bookService.update(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        return "book/list";
//        return "index";
    }


    @GetMapping("/one")
    public String addPage(Map<String, Object> map){
        List<BookType> list = bookTypeService.getList();
        map.put("bookTypeList",list);
        System.out.println("测试合并");
        return "book/add";
    }

    @GetMapping("/one/{no}")
    public String getOne(@PathVariable Long no,Map<String, Object> map){
        if(no!=null){
            Book book = bookService.getByNo(no);
            List<BookType> list = bookTypeService.getList();
            map.put("book", book);
            map.put("bookTypeList", list);
        }

        return "book/add";
    }

    //上传文件
    public String upLoad(MultipartFile pic) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();

        //获取文件名
        String originalFilename = pic.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.indexOf("."));
        String fileName = UUID.randomUUID() + suffixName;
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);

//        String path = "E:/Idea_WorkSpace/springbootwebtest/src/main/resources/public/";
        try {
            InputStream in = pic.getInputStream();
//            Files.copy(in, Paths.get(path));
            pic.transferTo(new File(path+fileName));

        } catch (IOException e) {
            e.printStackTrace();
            session.setAttribute("addMsg","添加图片失败");
            return "/add";
        }
        return "redirect:/book/list";
    }

}
