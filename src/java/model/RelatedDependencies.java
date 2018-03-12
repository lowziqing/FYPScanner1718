package model;

public class RelatedDependencies
{
    private Identifiers[] identifiers;

    private String filePath;

    private String md5;

    private String sha1;

    private String isVirtual;

    public Identifiers[] getIdentifiers ()
    {
        return identifiers;
    }

    public void setIdentifiers (Identifiers[] identifiers)
    {
        this.identifiers = identifiers;
    }

    public String getFilePath ()
    {
        return filePath;
    }

    public void setFilePath (String filePath)
    {
        this.filePath = filePath;
    }

    public String getMd5 ()
    {
        return md5;
    }

    public void setMd5 (String md5)
    {
        this.md5 = md5;
    }

    public String getSha1 ()
    {
        return sha1;
    }

    public void setSha1 (String sha1)
    {
        this.sha1 = sha1;
    }

    public String getIsVirtual ()
    {
        return isVirtual;
    }

    public void setIsVirtual (String isVirtual)
    {
        this.isVirtual = isVirtual;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [identifiers = "+identifiers+", filePath = "+filePath+", md5 = "+md5+", sha1 = "+sha1+", isVirtual = "+isVirtual+"]";
    }
}
	