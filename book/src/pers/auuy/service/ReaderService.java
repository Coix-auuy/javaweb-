package pers.auuy.service;

import pers.auuy.pojo.Page;
import pers.auuy.pojo.Reader;

import java.util.List;

public interface ReaderService {


    public void addReader(Reader reader);

    public void deleteReader(String id);

    public void updateReader(Reader reader);

    public Reader queryReaderById(String id);

    public List<Reader> queryReaders();

    Page<Reader> page(int pageNo, int pageSize);

    Page<Reader> pageByReaderID(int pageNo, int pageSize, String id);
}
