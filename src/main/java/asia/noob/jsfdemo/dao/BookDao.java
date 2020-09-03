package asia.noob.jsfdemo.dao;

import java.util.List;

import asia.noob.jsfdemo.pojo.Book;

public interface BookDao
{
    List<Book> queryAll();
    
    int insertBook(Book book);
    
    int deleteBook(Book book);
    
    int updateBook(Book book);
}
