package pers.auuy.web;

import pers.auuy.pojo.Borrow;
import pers.auuy.pojo.Page;
import pers.auuy.service.BorrowService;
import pers.auuy.service.impl.BorrowServiceImpl;
import pers.auuy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BorrowServlet extends BaseServlet {
    private BorrowService borrowService = new BorrowServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parasInt(req.getParameter("pageNo"),0);
        pageNo++;
        // 1.获取请求的参数封装为 Borrow 对象
        Borrow borrow = WebUtils.copyParaToBean(req.getParameterMap(),new Borrow());
        // 2.调用 ReaderService.addReader()
        borrowService.addBorrow(borrow);
        // 3.跳到借书列页面 (不能用请求转发 当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键 F5 ，就会发起浏览器记录的最后一次请求)
        // 重定向的 / 表示到端口号
        resp.sendRedirect(req.getContextPath()+"/manage/borrowServlet?action=page&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.获取请求的参数 ID，图书编号
        int id = WebUtils.parasInt(req.getParameter("id"),0);
        // 2.调用 borrowService.deleteBookById()
        borrowService.deleteBorrow(id);
        // 3.重定向回借书列表页
        // http://ip:port/工程名/........
        // 在请求转发中 / === http://ip:prot/工程名/
        resp.sendRedirect(req.getContextPath()+"/manage/borrowServlet?action=page&pageNo="+req.getParameter("pageNo"));
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
        Page<Borrow> page = borrowService.page(pageNo,pageSize);
        // 设置请求地址
        page.setUrl("manage/borrowServlet?action=page");
        // 3.保存 Page 对象到 request 域中
        req.setAttribute("page",page);
        // 4.请求转发
        req.getRequestDispatcher("/pages/manage/borrowManage.jsp").forward(req,resp);
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
        // 获取 id
        String readerID = req.getParameter("readerID");
        // 2.调用 borrowService.page(pageNo,pageSize):Page 对象
        Page<Borrow> page = borrowService.pageByReaderID(pageNo,pageSize,readerID);
        // 设置请求地址
        page.setUrl("manage/borrowServlet?action=pageByReaderID&readerID="+readerID);
        // 3.保存 Page 对象到 request 域中
        req.setAttribute("page",page);
        // 4.请求转发 /pages/manage/bookManage.jsp
        req.getRequestDispatcher("/pages/manage/borrowManage.jsp").forward(req,resp);
    }
}
