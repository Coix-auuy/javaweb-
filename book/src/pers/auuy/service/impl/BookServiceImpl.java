package pers.auuy.service.impl;

import pers.auuy.dao.BookDAO;
import pers.auuy.dao.impl.BookDAOImpl;
import pers.auuy.pojo.Book;
import pers.auuy.pojo.Page;
import pers.auuy.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();
    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDAO.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        // 设置当前显示数量
        page.setPageSize(pageSize);
        // 获得总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 设置总页码数
        Integer pageTotal = pageTotalCount / pageSize;
        if((pageTotalCount % pageSize) != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置当前页码
        // 数据边界有效检查
        if(pageNo < 1) {
            pageNo = 1;
        }
        if(pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 求当前页数据
        List<Book> items = bookDAO.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByBookName(int pageNo, int pageSize, String name) {
        Page<Book> page = new Page<Book>();
        // 设置当前显示数量
        page.setPageSize(pageSize);
        // 获得总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCountByBookName(name);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 设置总页码数
        Integer pageTotal = pageTotalCount / pageSize;
        if((pageTotalCount % pageSize) != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置当前页码
        // 数据边界有效检查
        if(pageNo < 1) {
            pageNo = 1;
        }
        if(pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 求当前页数据
        List<Book> items = bookDAO.queryForPageItemsByBookName(begin,pageSize,name);
        // 设置当前页数据
        page.setItems(items);
        return page;
    }
}
