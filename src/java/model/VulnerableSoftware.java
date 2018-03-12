package model;

public class VulnerableSoftware
{
    private String software;

    private String allPreviousVersion;

    public String getSoftware ()
    {
        return software;
    }

    public void setSoftware (String software)
    {
        this.software = software;
    }

    public String getAllPreviousVersion ()
    {
        return allPreviousVersion;
    }

    public void setAllPreviousVersion (String allPreviousVersion)
    {
        this.allPreviousVersion = allPreviousVersion;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [software = "+software+", allPreviousVersion = "+allPreviousVersion+"]";
    }
}
