package model;
                 
public class DataSource
{
    private String timestamp;

    private String name;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", name = "+name+"]";
    }
}
	