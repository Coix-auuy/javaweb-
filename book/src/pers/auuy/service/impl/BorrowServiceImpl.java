package pers.auuy.service.impl;

import pers.auuy.dao.BorrowDAO;
import pers.auuy.dao.impl.BorrowDAOImpl;
import pers.auuy.pojo.Borrow;
import pers.auuy.pojo.Page;
import pers.auuy.pojo.Reader;
import pers.auuy.service.BorrowService;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    private BorrowDAO borrowDAO = new BorrowDAOImpl();
    @Override
    public void addBorrow(Borrow borrow) {
        borrowDAO.addBorrow(borrow);
    }

    @Override
    public void deleteBorrow(Integer id) {
        borrowDAO.deleteBorrow(id);
    }

    @Override
    public Borrow queryBorrowByID(Integer id) {
        return borrowDAO.queryBorrowByID(id);
    }

    @Override
    public List<Borrow> queryBorrows() {

        return borrowDAO.queryBorrows();
    }

    @Override
    public Page<Borrow> page(int pageNo, int pageSize) {
        Page<Borrow> page = new Page<Borrow>();
        // 设置当前显示数量
        page.setPageSize(pageSize);
        // 获得总记录数
        Integer pageTotalCount = borrowDAO.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 设置总页码数
        Integer pageTotal = pageTotalCount / pageSize;
        if((pageTotalCount % pageSize) != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置当前页码
        // 数据边界有效检查
        if(pageNo < 1) {
            pageNo = 1;
        }
        if(pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 求当前页数据
        List<Borrow> items = borrowDAO.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Borrow> pageByReaderID(int pageNo, int pageSize, String readerID) {

        Page<Borrow> page = new Page<Borrow>();
        // 设置当前显示数量
        page.setPageSize(pageSize);
        // 获得总记录数
        Integer pageTotalCount = borrowDAO.queryForPageTotalCountByReaderID(readerID);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 设置总页码数
        Integer pageTotal = pageTotalCount / pageSize;
        if((pageTotalCount % pageSize) != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置当前页码
        // 数据边界有效检查
        if(pageNo < 1) {
            pageNo = 1;
        }
        if(pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 求当前页数据
        List<Borrow> items = borrowDAO.queryForPageItemsByReaderID(begin,pageSize,readerID);
        page.setItems(items);
        return page;
    }
}
