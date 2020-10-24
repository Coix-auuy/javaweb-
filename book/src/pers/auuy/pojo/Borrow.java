package pers.auuy.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrow {
    private Integer id;
    private String readerID;
    private Integer bookID;
    private String time;

    public Borrow() {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = df.format(date);
    }

    public Borrow(Integer id, String readerID, Integer bookID, String time) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.id = id;
        this.readerID = readerID;
        this.bookID = bookID;
        this.time = df.format(date);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReaderID() {
        return readerID;
    }

    public void setReaderID(String readerID) {
        this.readerID = readerID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", readerID='" + readerID + '\'' +
                ", bookID=" + bookID +
                ", time='" + time + '\'' +
                '}';
    }
}
