package org.crazyit.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.crazyit.test.entity.Book;
import org.crazyit.test.service.BookService;
import org.crazyit.test.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sale-web")
public class SaleWebController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/list")
    public String listBook(Model model, HttpServletRequest request) {
        List<Book> books = bookService.getBooks();
        // 写到临时文件中
        for (Book book : books) {
            String coverUrl = ImageUtil.writeToImage(book, request);
            book.setCoverUrl(coverUrl);
        }
        model.addAttribute("books", books);
        return "index";
    }
}
