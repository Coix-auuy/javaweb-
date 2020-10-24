package pers.auuy.test;

import org.junit.Test;
import pers.auuy.dao.BookDAO;
import pers.auuy.dao.impl.BookDAOImpl;
import pers.auuy.pojo.Book;

import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();
    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null,"JSP程序设计技术教程","张志峰等","程序设计类","清华大学出版社"));
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(16,"JSP程序设计技术教程(第二版)","张志峰等","程序设计类","清华大学出版社"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDAO.queryBookById(16));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDAO.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDAO.queryForPageItems(0, 4)) {
            System.out.println(queryForPageItem);
        }
    }
    @Test
    public void queryForPageTotalCountByBookName() {
        System.out.println(bookDAO.queryForPageTotalCountByBookName("Python编程"));
    }
    @Test
    public void queryForPageItemsByBookName() {
        for (Book queryForPageItem : bookDAO.queryForPageItemsByBookName(0, 4,"Python编程")) {
            System.out.println(queryForPageItem);
        }
    }
}