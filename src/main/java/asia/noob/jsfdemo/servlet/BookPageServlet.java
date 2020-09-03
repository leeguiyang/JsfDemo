package asia.noob.jsfdemo.servlet;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import asia.noob.jsfdemo.pojo.Book;
import asia.noob.jsfdemo.service.BookService;
import asia.noob.jsfdemo.service.impl.BookServiceImpl;

@SessionScoped
@ManagedBean(name = "bookPage")
public class BookPageServlet implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -501487330845448062L;

    private BookService bookService = new BookServiceImpl();
    
    private List<Book> bookList;
    
    private Book book;
    
    public List<Book> getBookList()
    {
        bookList = bookService.queryAll();
        return bookList;
    }   
    public String deleteBook(Book book)
    {
        int result = bookService.deleteBook(book);
        bookList = bookService.queryAll();
        return String.valueOf(result);
    }
    
    public String addBook(Book book)
    {
        int result = bookService.insertBook(book);
        bookList = bookService.queryAll();
        return String.valueOf(result);
    }
}
