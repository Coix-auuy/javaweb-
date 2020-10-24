package pers.auuy.dao;
import pers.auuy.pojo.Reader;
import java.util.List;

public interface ReaderDAO {

    public int addReader(Reader reader);
    public int deleteReader(String id);
    public int updateReader(Reader reader);
    public Reader queryReaderById(String id);
    public List<Reader> queryReaders();
    public Integer queryForPageTotalCount();
    List<Reader> queryForPageItems(int begin, int pageSize);
    Integer queryForPageTotalCountByReaderID(String id);
    List<Reader> queryForPageItemsByReaderID(int begin, int pageSize, String id);
}
