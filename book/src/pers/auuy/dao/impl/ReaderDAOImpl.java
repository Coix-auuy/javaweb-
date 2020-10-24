package pers.auuy.dao.impl;

import pers.auuy.dao.ReaderDAO;
import pers.auuy.pojo.Book;
import pers.auuy.pojo.Reader;

import java.util.List;

public class ReaderDAOImpl extends BaseDAO implements ReaderDAO {
    @Override
    public int addReader(Reader reader) {
        String sql = "INSERT INTO t_reader(`id`,`name`,`sex`,`major`) VALUES(?,?,?,?);";
        return update(sql,reader.getId(),reader.getName(),reader.getSex(),reader.getMajor());
    }

    @Override
    public int deleteReader(String id) {
        String sql = "delete from t_reader where id=?";
        return update(sql,id);
    }

    @Override
    public int updateReader(Reader reader) {
        String sql = "update t_reader set `name`=?,`sex`=?,`major`=? where id=?";
        return update(sql,reader.getName(),reader.getSex(),reader.getMajor(),reader.getId());
    }

    @Override
    public Reader queryReaderById(String id) {
        String sql = "select `id`,`name`,`sex`,`major` from t_reader where id=?";
        return queryForOne(Reader.class,sql,id);
    }

    @Override
    public List<Reader> queryReaders() {
        String sql = "select `id`,`name`,`sex`,`major` from t_reader";
        return queryForList(Reader.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_reader";

        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Reader> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`sex`,`major` from t_reader limit ?,?";
        return queryForList(Reader.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByReaderID(String id) {
        String sql = "select count(*) from t_reader where id = ?";
        Number count = (Number) queryForSingleValue(sql,id);
        return count.intValue();
    }

    @Override
    public List<Reader> queryForPageItemsByReaderID(int begin, int pageSize, String id) {
        String sql = "select `id`,`name`,`sex`,`major` from t_reader where id = ? limit ?,?";
        return queryForList(Reader.class,sql,id,begin,pageSize);
    }
}
