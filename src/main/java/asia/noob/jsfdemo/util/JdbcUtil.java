package asia.noob.jsfdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtil
{
    private static Connection conn = null;
    private final static String url;
    private final static String user;
    private final static String password;
    
    static
    {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        url = bundle.getString("url");
        String driver = bundle.getString("driver");
        user = bundle.getString("user");
        password = bundle.getString("password");
        try
        {
            Class.forName(driver);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException
    {
        if (null == conn)
        {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }
    
    public static PreparedStatement preparedSQL(String sql, Object...objs) throws SQLException
    {
        PreparedStatement ptmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < objs.length; i++)
        {
            ptmt.setObject(i + 1, objs[i]);
        }
        return ptmt;
    }
    
    public static void close()
    {
        if (null != conn)
        {
            close(conn);
        }
    }
    @SafeVarargs
    public static <T extends AutoCloseable> void close(T...ts)
    {
        for (int i = 0; i < ts.length; i++)
        {
            close(ts[i]);
        }
    }
    
    public static <T extends AutoCloseable> void close(T t)
    {
        try
        {
            if (null != t)
            {
                t.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
