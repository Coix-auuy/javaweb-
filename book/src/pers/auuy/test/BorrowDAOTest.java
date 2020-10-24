package pers.auuy.test;

import org.junit.Test;
import pers.auuy.dao.BorrowDAO;
import pers.auuy.dao.impl.BorrowDAOImpl;
import pers.auuy.pojo.Borrow;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class BorrowDAOTest {
    private BorrowDAO borrowDAO = new BorrowDAOImpl();
    @Test
    public void addBorrow() {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(borrowDAO.addBorrow(new Borrow(null,"180970001",1,df.format(date))));
    }

    @Test
    public void deleteBorrow() {
        System.out.println(borrowDAO.deleteBorrow(1));
    }
    @Test
    public void queryBorrows() {
        for (Borrow queryBorrow : borrowDAO.queryBorrows()) {
            System.out.println(queryBorrow);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(borrowDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Borrow queryForPageItem : borrowDAO.queryForPageItems(0,2)) {
            System.out.println(queryForPageItem);
        }
    }

    @Test
    public void queryForPageTotalCountByReaderID() {
        System.out.println(borrowDAO.queryForPageTotalCountByReaderID("180970001"));
    }

    @Test
    public void queryForPageItemsByReaderID() {
        System.out.println(borrowDAO.queryForPageItemsByReaderID(0,1,"180970001"));
    }
}