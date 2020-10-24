package pers.auuy.test;

import org.junit.Test;
import pers.auuy.pojo.Book;
import pers.auuy.service.BookService;
import pers.auuy.service.impl.BookServiceImpl;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"考研英语核心语法","王泉","考研英语类","中国原子能出版社"));
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(17);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(17,"考研英语核心语法","王泉","文都考研英语类","中国原子能出版社"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(17));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
    }
    @Test
    public void pageByBookName() {
        System.out.println(bookService.pageByBookName(1,4,"Python编程"));
    }
}