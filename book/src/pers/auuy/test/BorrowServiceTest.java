package pers.auuy.test;

import org.junit.Test;
import pers.auuy.pojo.Borrow;
import pers.auuy.service.BorrowService;
import pers.auuy.service.impl.BorrowServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class BorrowServiceTest {
    private BorrowService borrowService = new BorrowServiceImpl();
    @Test
    public void addBorrow() {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        borrowService.addBorrow(new Borrow(null,"180970001",3,df.format(date)));
    }

    @Test
    public void deleteBorrow(Integer id) {
        borrowService.deleteBorrow(id);
    }


    @Test
    public void queryBorrows() {
        for (Borrow queryBorrow : borrowService.queryBorrows()) {
            System.out.println(queryBorrow);
        }
    }

    @Test
    public void page() {
        System.out.println(borrowService.page(0,2));
    }

    @Test
    public void pageByReaderID() {
        System.out.println(borrowService.pageByReaderID(0,1,"180970001"));
    }
}