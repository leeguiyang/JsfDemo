package asia.noob.jsfdemo.dao.impl;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import asia.noob.jsfdemo.dao.BookDao;
import asia.noob.jsfdemo.pojo.Book;
import asia.noob.jsfdemo.util.JdbcUtil;

public class BookDaoImpl implements BookDao
{
    @Override
    public List<Book> queryAll()
    {
        List<Book> bookList = new ArrayList<>();
        try
        {
            String sql = "select * from book";
            PreparedStatement ptmt = JdbcUtil.preparedSQL(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next())
            {
                Field[] fields = Book.class.getDeclaredFields();
                Book book = new Book();
                for (Field f : fields)
                {
                    f.setAccessible(true);
                    f.set(book, rs.getString(f.getName()));
                }
                bookList.add(book);
            }
            return bookList;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            //                        JdbcUtil.close();
        }
        return bookList;
    }

    @Override
    public int insertBook(Book book)
    {
        String sql = "insert into book(ID,NAME,PRICE) values(?,?,?)";
        try
        {
            PreparedStatement ptmt = JdbcUtil.preparedSQL(sql, book.getId(), book.getName(), book.getPrice());
            return ptmt.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            //            JdbcUtil.close();
        }
        return 0;
    }

    @Override
    public int deleteBook(Book book)
    {
        String sql = "delete from book where ID = ?";
        try
        {
            PreparedStatement ptmt = JdbcUtil.preparedSQL(sql, book.getId());
            return ptmt.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            //            JdbcUtil.close();
        }
        return 0;
    }

    @Override
    public int updateBook(Book book)
    {
        String sql = "update book set NAME = ?, PRICE = ? where ID = ?";
        try
        {
            PreparedStatement ptmt = JdbcUtil.preparedSQL(sql, book.getName(), book.getPrice(), book.getId());
            return ptmt.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            //            JdbcUtil.close();
        }
        return 0;
    }

}
