package pers.auuy.test;

import org.junit.Test;
import pers.auuy.pojo.Reader;
import pers.auuy.service.ReaderService;
import pers.auuy.service.impl.ReaderServiceImpl;

import static org.junit.Assert.*;

public class ReaderServiceTest {
    private ReaderService readerService = new ReaderServiceImpl();
    @Test
    public void addReader() {
        readerService.addReader(new Reader("180970011","铁蛋","男","工管"));
    }

    @Test
    public void deleteReader() {
        readerService.deleteReader("180970011");
    }

    @Test
    public void updateReader() {
        readerService.updateReader(new Reader("180970001","铁蛋","女","工管"));
    }

    @Test
    public void queryReaderById() {
        System.out.println(readerService.queryReaderById("180970011"));
    }

    @Test
    public void queryReaders() {
        for (Reader queryReader : readerService.queryReaders()) {
            System.out.println(queryReader);
        }
    }

    @Test
    public void page() {
        System.out.println(readerService.page(0,2));
    }

    @Test
    public void pageByReaderID() {
        System.out.println(readerService.pageByReaderID(0,2,"180970011"));
    }
}