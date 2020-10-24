package pers.auuy.dao.impl;

import pers.auuy.dao.BorrowDAO;
import pers.auuy.pojo.Borrow;

import java.util.List;

public class BorrowDAOImpl extends BaseDAO implements BorrowDAO {
    @Override
    public int addBorrow(Borrow borrow) {
        String sql = "INSERT INTO t_borrow(`readerID`,`bookID`,`time`) VALUES(?,?,?)";
        return update(sql,borrow.getReaderID(),borrow.getBookID(),borrow.getTime());
    }

    @Override
    public int deleteBorrow(Integer id) {
        String sql = "delete from t_borrow where id=?";
        return update(sql,id);
    }


    @Override
    public Borrow queryBorrowByID(Integer id) {
        String sql = "select `id`,`readerID`,`bookID`,`time` from t_borrow where id=?";
        return queryForOne(Borrow.class,sql,id);
    }

    @Override
    public List<Borrow> queryBorrows() {
        String sql = "select `id`, `readerID`,`bookID`,`time` from t_borrow";
        return queryForList(Borrow.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_borrow";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Borrow> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`readerID`,`bookID`,`time` from t_borrow limit ?,?";
        return queryForList(Borrow.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByReaderID(String readerID) {
        String sql = "select count(*) from t_borrow where readerID = ?";
        Number count = (Number) queryForSingleValue(sql,readerID);
        return count.intValue();
    }

    @Override
    public List<Borrow> queryForPageItemsByReaderID(int begin, int pageSize, String readerID) {
        String sql = "select `id`,`readerID`,`bookID`,`time` from t_borrow where readerID = ? limit ?,?";
        return queryForList(Borrow.class,sql,readerID,begin,pageSize);
    }
}
