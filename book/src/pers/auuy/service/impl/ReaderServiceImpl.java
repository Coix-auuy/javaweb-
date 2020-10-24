package pers.auuy.service.impl;

import pers.auuy.dao.ReaderDAO;
import pers.auuy.dao.impl.ReaderDAOImpl;
import pers.auuy.pojo.Page;
import pers.auuy.pojo.Reader;
import pers.auuy.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private ReaderDAO readerDAO = new ReaderDAOImpl();
    @Override
    public void addReader(Reader reader) {
        readerDAO.addReader(reader);
    }

    @Override
    public void deleteReader(String id) {
        readerDAO.deleteReader(id);
    }

    @Override
    public void updateReader(Reader reader) {
        readerDAO.updateReader(reader);
    }

    @Override
    public Reader queryReaderById(String id) {
        return readerDAO.queryReaderById(id);
    }

    @Override
    public List<Reader> queryReaders() {
        return readerDAO.queryReaders();
    }

    @Override
    public Page<Reader> page(int pageNo, int pageSize) {
        Page<Reader> page = new Page<Reader>();
        // 设置当前显示数量
        page.setPageSize(pageSize);
        // 获得总记录数
        Integer pageTotalCount = readerDAO.queryForPageTotalCount();
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
        List<Reader> items = readerDAO.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Reader> pageByReaderID(int pageNo, int pageSize, String id) {
        Page<Reader> page = new Page<Reader>();
        // 设置当前显示数量
        page.setPageSize(pageSize);
        // 获得总记录数
        Integer pageTotalCount = readerDAO.queryForPageTotalCountByReaderID(id);
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
        List<Reader> items = readerDAO.queryForPageItemsByReaderID(begin,pageSize,id);
        page.setItems(items);
        return page;
    }
}
