package pers.auuy.dao.impl;

import pers.auuy.dao.BookDAO;
import pers.auuy.pojo.Book;

import java.util.List;

public class BookDAOImpl extends BaseDAO implements BookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name`,`author`,`category`,`publish`) VALUES(?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getCategory(),book.getPublish());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`category`=?,`publish`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getCategory(),book.getPublish(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql ="select `id`,`name`,`author`,`category`,`publish` from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`category`,`publish` from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";

        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`category`,`publish` from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByBookName(String name) {
        String sql = "select count(*) from t_book where name = ?";
        Number count = (Number) queryForSingleValue(sql,name);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByBookName(int begin, int pageSize, String name) {
        String sql = "select `id`,`name`,`author`,`category`,`publish` from t_book where name = ? limit ?,?";
        return queryForList(Book.class,sql,name,begin,pageSize);
    }
}
