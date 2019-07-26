package org.crazyit.test.ctl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.crazyit.test.entity.Book;
import org.crazyit.test.entity.User;
import org.crazyit.test.service.BookService;
import org.crazyit.test.service.UserService;
import org.crazyit.test.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/manage-web")
public class ManageController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute User loginUser, Model model,
			HttpSession session) {
		if (loginUser.getName() == null) {
			return "login";
		}
		// 调用验证服务
		User dataUser = userService.validate(loginUser.getName(),
				loginUser.getPassword());
		if (dataUser.getId() == null) {
			// 验证失败
			model.addAttribute("message", "fail");
			return "login";
		} else {
			session.setAttribute("manage-user", loginUser);
			return "index";
		}
	}

	@RequestMapping(value = "/book/addBook")
	public String addBook() {
		return "book/add";
	}

	@RequestMapping(value = "/book/save")
	public String saveBook(@ModelAttribute Book book, MultipartFile file)
			throws Exception {
		book.setCover(file.getBytes());
		// 保存数据
		bookService.save(book);
		return "forward:/manage-web/book/list";
	}

	@RequestMapping(value = "/book/list")
	public String listBook(Model model, HttpServletRequest request) {
		List<Book> books = bookService.getBooks();
		// 写到临时文件中
		for (Book book : books) {
			String coverUrl = ImageUtil.writeToImage(book, request);
			book.setCoverUrl(coverUrl);
		}
		model.addAttribute("books", books);
		return "book/list";
	}

	@RequestMapping(value = "/staticPage/{name}")
	public String staticPage(@PathVariable String name) {
		return name;
	}
}
