package model;

public class ScanInfo
{
    private DataSource[] dataSource;

    private String engineVersion;

    public DataSource[] getDataSource ()
    {
        return dataSource;
    }

    public void setDataSource (DataSource[] dataSource)
    {
        this.dataSource = dataSource;
    }

    public String getEngineVersion ()
    {
        return engineVersion;
    }

    public void setEngineVersion (String engineVersion)
    {
        this.engineVersion = engineVersion;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dataSource = "+dataSource+", engineVersion = "+engineVersion+"]";
    }
}