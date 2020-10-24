package pers.auuy.dao;

import pers.auuy.pojo.Book;

import java.util.List;

public interface BookDAO {

    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByBookName(String name);

    List<Book> queryForPageItemsByBookName(int begin, int pageSize, String name);
}
