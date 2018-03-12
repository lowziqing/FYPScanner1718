package model;

public class Credits
{
    private String NSP;

    private String NVD;

    public String getNSP ()
    {
        return NSP;
    }

    public void setNSP (String NSP)
    {
        this.NSP = NSP;
    }

    public String getNVD ()
    {
        return NVD;
    }

    public void setNVD (String NVD)
    {
        this.NVD = NVD;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [NSP = "+NSP+", NVD = "+NVD+"]";
    }
}