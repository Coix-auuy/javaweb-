package pers.auuy.web;

import pers.auuy.pojo.Book;
import pers.auuy.pojo.Page;
import pers.auuy.service.BookService;
import pers.auuy.service.impl.BookServiceImpl;
import pers.auuy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parasInt(req.getParameter("pageNo"),0);
        pageNo++;
        // 1.获取请求的参数封装为 Book 对象
        Book book = WebUtils.copyParaToBean(req.getParameterMap(),new Book());
        // 2.调用 BookService.addBook()
        bookService.addBook(book);
        // 3.跳到图书列别页面 (不能用请求转发 当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键 F5 ，就会发起浏览器记录的最后一次请求)
        // 重定向的 / 表示到端口号
        resp.sendRedirect(req.getContextPath()+"/manage/bookServlet?action=page&pageNo="+pageNo);

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.获取请求的参数 ID，图书编号
        int id = WebUtils.parasInt(req.getParameter("id"),0);
        // 2.调用 BookService.deleteBookById()
        bookService.deleteBook(id);
        // 3.重定向回图书列表页
        // http://ip:port/工程名/........
        // 在请求转发中 / === http://ip:prot/工程名/
        resp.sendRedirect(req.getContextPath()+"/manage/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数封装为 Book 对象
        Book book = WebUtils.copyParaToBean(req.getParameterMap(), new Book());
        // 2.调用 bookService.updateBook();
        bookService.updateBook(book);
        // 3.重定向
        resp.sendRedirect(req.getContextPath()+"/manage/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过 BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
//        for (Book book : books) {
//            System.out.println(book);
//        }
        // 2.把全部图书保存到 request 域中
        req.setAttribute("books",books);
        // 3.请求转发到 /pages/manage/bookManage.jsp
        req.getRequestDispatcher("/pages/manage/bookManage.jsp").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取的请求的参数图书编号
        int id = WebUtils.parasInt(req.getParameter("id"),0);
        // 2.调用 bookService.queryBookById()
        Book book =  bookService.queryBookById(id);
        // 3.保存图书信息到 request 域中
        req.setAttribute("book",book);
        // 4.请求转发 book_edit.jsp
        req.getRequestDispatcher("/pages/manage/book_edit.jsp").forward(req,resp);
    }

    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数 pageNo，pageSize
        int pageNo = WebUtils.parasInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parasInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2.调用 BookService.page(pageNo,pageSize):Page 对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        // 设置请求地址
        page.setUrl("manage/bookServlet?action=page");
        // 3.保存 Page 对象到 request 域中
        req.setAttribute("page",page);
        // 4.请求转发 /pages/manage/bookManage.jsp
        req.getRequestDispatcher("/pages/manage/bookManage.jsp").forward(req,resp);
    }
    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByBookName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数 pageNo，pageSize
        int pageNo = WebUtils.parasInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parasInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 获取图书名
        String name = req.getParameter("name");
        // 2.调用 BookService.page(pageNo,pageSize):Page 对象
        Page<Book> page = bookService.pageByBookName(pageNo,pageSize,name);
        // 设置请求地址
        page.setUrl("manage/bookServlet?action=pageByBookName&name="+name);
        // 3.保存 Page 对象到 request 域中
        req.setAttribute("page",page);
        // 4.请求转发 /pages/manage/bookManage.jsp
        req.getRequestDispatcher("/pages/manage/bookManage.jsp").forward(req,resp);
    }
}
