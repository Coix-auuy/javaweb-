package pers.auuy.test;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;
import pers.auuy.dao.ReaderDAO;
import pers.auuy.dao.impl.ReaderDAOImpl;
import pers.auuy.pojo.Reader;

import static org.junit.Assert.*;

public class ReaderDAOTest {
    private ReaderDAO readerDao = new ReaderDAOImpl();
    @Test
    public void addReader() {
        System.out.println(readerDao.addReader(new Reader("180970010","王蛋","男","体育")));
    }

    @Test
    public void deleteReader() {
    }

    @Test
    public void updateReader() {
        System.out.println(readerDao.updateReader(new Reader("180970010","王蛋","女","体育")));
    }

    @Test
    public void queryReaderById() {
        System.out.println(readerDao.queryReaderById("180970010"));
    }

    @Test
    public void queryReaders() {
        for (Reader queryReader : readerDao.queryReaders()) {
            System.out.println(queryReader);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(readerDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Reader queryForPageItem : readerDao.queryForPageItems(0,2)) {
            System.out.println(queryForPageItem);
        }
    }

    @Test
    public void queryForPageTotalCountByReaderID() {
        System.out.println(readerDao.queryForPageTotalCountByReaderID("180970010"));
    }

    @Test
    public void queryForPageItemsByReaderID() {
        for (Reader reader : readerDao.queryForPageItemsByReaderID(0,4,"180970010")) {
            System.out.println(reader);
        }
    }
}