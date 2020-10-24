package pers.auuy.dao;

import pers.auuy.pojo.Borrow;

import java.util.List;

public interface BorrowDAO {

    public int addBorrow(Borrow borrow);
    public int deleteBorrow(Integer id);
    public Borrow queryBorrowByID(Integer id);
    public List<Borrow> queryBorrows();
    public Integer queryForPageTotalCount();
    List<Borrow> queryForPageItems(int begin, int pageSize);
    Integer queryForPageTotalCountByReaderID(String id);
    List<Borrow> queryForPageItemsByReaderID(int begin, int pageSize, String id);
}
