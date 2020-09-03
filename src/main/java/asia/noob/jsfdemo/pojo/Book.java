package asia.noob.jsfdemo.pojo;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "book")
public class Book
{
    private String id;
    private String name;
    private String price;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
