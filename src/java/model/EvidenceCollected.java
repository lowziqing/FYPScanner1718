package model;

public class EvidenceCollected
{
    private ProductEvidence[] productEvidence;

    private VersionEvidence[] versionEvidence;

    private VendorEvidence[] vendorEvidence;

    public ProductEvidence[] getProductEvidence ()
    {
        return productEvidence;
    }

    public void setProductEvidence (ProductEvidence[] productEvidence)
    {
        this.productEvidence = productEvidence;
    }

    public VersionEvidence[] getVersionEvidence ()
    {
        return versionEvidence;
    }

    public void setVersionEvidence (VersionEvidence[] versionEvidence)
    {
        this.versionEvidence = versionEvidence;
    }

    public VendorEvidence[] getVendorEvidence ()
    {
        return vendorEvidence;
    }

    public void setVendorEvidence (VendorEvidence[] vendorEvidence)
    {
        this.vendorEvidence = vendorEvidence;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [productEvidence = "+productEvidence+", versionEvidence = "+versionEvidence+", vendorEvidence = "+vendorEvidence+"]";
    }
}