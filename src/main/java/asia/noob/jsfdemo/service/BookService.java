package asia.noob.jsfdemo.service;

import java.util.List;

import asia.noob.jsfdemo.pojo.Book;

public interface BookService
{
    List<Book> queryAll() ;
    
    int insertBook(Book book);
    
    int deleteBook(Book book);
    
    int updateBook(Book book);
}
