package pers.auuy.web;

import pers.auuy.pojo.Page;
import pers.auuy.pojo.Reader;
import pers.auuy.service.ReaderService;
import pers.auuy.service.impl.ReaderServiceImpl;
import pers.auuy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReaderServlet extends BaseServlet{
    private ReaderService readerService = new ReaderServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parasInt(req.getParameter("pageNo"),0);
        pageNo++;
        // 1.获取请求的参数封装为 Reader 对象
        Reader reader = WebUtils.copyParaToBean(req.getParameterMap(),new Reader());
        // 2.调用 ReaderService.addReader()
        readerService.addReader(reader);
        // 3.跳到读者列别页面 (不能用请求转发 当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键 F5 ，就会发起浏览器记录的最后一次请求)
        // 重定向的 / 表示到端口号
        resp.sendRedirect(req.getContextPath()+"/manage/readerServlet?action=page&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.获取请求的参数 ID，图书编号
        String id = req.getParameter("id");
        // 2.调用 BookService.deleteBookById()
        readerService.deleteReader(id);
        // 3.重定向回读者列表页
        // http://ip:port/工程名/........
        // 在请求转发中 / === http://ip:prot/工程名/
        resp.sendRedirect(req.getContextPath()+"/manage/readerServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数封装为 Book 对象
        Reader reader = WebUtils.copyParaToBean(req.getParameterMap(), new Reader());
        // 2.调用 bookService.updateBook();
        readerService.updateReader(reader);
        // 3.重定向
        resp.sendRedirect(req.getContextPath()+"/manage/readerServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void getReader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取的请求的参数图书编号
        String id =req.getParameter("id");
        // 2.调用 bookService.queryBookById()
        Reader reader =  readerService.queryReaderById(id);
        // 3.保存图书信息到 request 域中
        req.setAttribute("Reader",reader);
        // 4.请求转发 book_edit.jsp
        req.getRequestDispatcher("/pages/manage/reader_edit.jsp").forward(req,resp);
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
        Page<Reader> page = readerService.page(pageNo,pageSize);
        // 设置请求地址
        page.setUrl("manage/readerServlet?action=page");
        // 3.保存 Page 对象到 request 域中
        req.setAttribute("page",page);
        // 4.请求转发
        req.getRequestDispatcher("/pages/manage/readerManage.jsp").forward(req,resp);
    }
    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByReaderID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数 pageNo，pageSize
        int pageNo = WebUtils.parasInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parasInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 获取读者id
        String id = req.getParameter("id");
        // 2.调用 BookService.page(pageNo,pageSize):Page 对象
        Page<Reader> page = readerService.pageByReaderID(pageNo,pageSize,id);
        // 设置请求地址
        page.setUrl("manage/readerServlet?action=pageByReaderID&id="+id);
        // 3.保存 Page 对象到 request 域中
        req.setAttribute("page",page);
        // 4.请求转发 /pages/manage/readerManage.jsp
        req.getRequestDispatcher("/pages/manage/readerManage.jsp").forward(req,resp);
    }
}
