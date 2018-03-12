package model;

public class Vulnerabilities
{
    private String cvssAvailabilityImpact;

    private String cvssAuthenticationr;

    private String cvssIntegrityImpact;

    private String severity;

    private VulnerableSoftware[] vulnerableSoftware;

    private String cwe;

    private String cvssConfidentialImpact;

    private References[] references;

    private String description;

    private String name;

    private String cvssScore;

    private String cvssAccessVector;

    private String notes;

    private String cvssAccessComplexity;

    public String getCvssAvailabilityImpact ()
    {
        return cvssAvailabilityImpact;
    }

    public void setCvssAvailabilityImpact (String cvssAvailabilityImpact)
    {
        this.cvssAvailabilityImpact = cvssAvailabilityImpact;
    }

    public String getCvssAuthenticationr ()
    {
        return cvssAuthenticationr;
    }

    public void setCvssAuthenticationr (String cvssAuthenticationr)
    {
        this.cvssAuthenticationr = cvssAuthenticationr;
    }

    public String getCvssIntegrityImpact ()
    {
        return cvssIntegrityImpact;
    }

    public void setCvssIntegrityImpact (String cvssIntegrityImpact)
    {
        this.cvssIntegrityImpact = cvssIntegrityImpact;
    }

    public String getSeverity ()
    {
        return severity;
    }

    public void setSeverity (String severity)
    {
        this.severity = severity;
    }

    public VulnerableSoftware[] getVulnerableSoftware ()
    {
        return vulnerableSoftware;
    }

    public void setVulnerableSoftware (VulnerableSoftware[] vulnerableSoftware)
    {
        this.vulnerableSoftware = vulnerableSoftware;
    }

    public String getCwe ()
    {
        return cwe;
    }

    public void setCwe (String cwe)
    {
        this.cwe = cwe;
    }

    public String getCvssConfidentialImpact ()
    {
        return cvssConfidentialImpact;
    }

    public void setCvssConfidentialImpact (String cvssConfidentialImpact)
    {
        this.cvssConfidentialImpact = cvssConfidentialImpact;
    }

    public References[] getReferences ()
    {
        return references;
    }

    public void setReferences (References[] references)
    {
        this.references = references;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCvssScore ()
    {
        return cvssScore;
    }

    public void setCvssScore (String cvssScore)
    {
        this.cvssScore = cvssScore;
    }

    public String getCvssAccessVector ()
    {
        return cvssAccessVector;
    }

    public void setCvssAccessVector (String cvssAccessVector)
    {
        this.cvssAccessVector = cvssAccessVector;
    }

    public String getNotes ()
    {
        return notes;
    }

    public void setNotes (String notes)
    {
        this.notes = notes;
    }

    public String getCvssAccessComplexity ()
    {
        return cvssAccessComplexity;
    }

    public void setCvssAccessComplexity (String cvssAccessComplexity)
    {
        this.cvssAccessComplexity = cvssAccessComplexity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cvssAvailabilityImpact = "+cvssAvailabilityImpact+", cvssAuthenticationr = "+cvssAuthenticationr+", cvssIntegrityImpact = "+cvssIntegrityImpact+", severity = "+severity+", vulnerableSoftware = "+vulnerableSoftware+", cwe = "+cwe+", cvssConfidentialImpact = "+cvssConfidentialImpact+", references = "+references+", description = "+description+", name = "+name+", cvssScore = "+cvssScore+", cvssAccessVector = "+cvssAccessVector+", notes = "+notes+", cvssAccessComplexity = "+cvssAccessComplexity+"]";
    }
}