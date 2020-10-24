package pers.auuy.service;

import pers.auuy.pojo.Book;
import pers.auuy.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo,int pageSize);

    Page<Book> pageByBookName(int pageNo, int pageSize, String name);
}
