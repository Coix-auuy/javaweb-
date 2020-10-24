package pers.auuy.service;

import pers.auuy.pojo.Borrow;
import pers.auuy.pojo.Page;

import java.util.List;

public interface BorrowService {
    public void addBorrow(Borrow borrow);

    public void deleteBorrow(Integer id);

    public Borrow queryBorrowByID(Integer id);

    public List<Borrow> queryBorrows();

    Page<Borrow> page(int pageNo, int pageSize);

    Page<Borrow> pageByReaderID(int pageNo, int pageSize, String readerID);
}
