package asia.noob.jsfdemo.service.impl;

import java.util.List;

import asia.noob.jsfdemo.dao.BookDao;
import asia.noob.jsfdemo.dao.impl.BookDaoImpl;
import asia.noob.jsfdemo.pojo.Book;
import asia.noob.jsfdemo.service.BookService;

public class BookServiceImpl implements BookService
{
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> queryAll()
    {
        return bookDao.queryAll();
    }

    @Override
    public int insertBook(Book book)
    {
        return bookDao.insertBook(book);
    }

    @Override
    public int deleteBook(Book book)
    {
        return bookDao.deleteBook(book);
    }

    @Override
    public int updateBook(Book book)
    {
        return bookDao.updateBook(book);
    }
    
    
}
