package jsfdemo;

import org.junit.jupiter.api.Test;

import asia.noob.jsfdemo.service.BookService;
import asia.noob.jsfdemo.service.impl.BookServiceImpl;

public class BookServletTest
{
    @Test
    public void testBook()
    {
        BookService bookService = new BookServiceImpl();
        System.out.println(bookService.queryAll());
    }
}
