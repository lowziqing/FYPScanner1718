package model;

public class ReportData
{
    private ScanInfo scanInfo;

    private Dependencies[] dependencies;

    private ProjectInfo projectInfo;

    private String reportSchema;

    public ScanInfo getScanInfo ()
    {
        return scanInfo;
    }

    public void setScanInfo (ScanInfo scanInfo)
    {
        this.scanInfo = scanInfo;
    }

    public Dependencies[] getDependencies ()
    {
        return dependencies;
    }

    public void setDependencies (Dependencies[] dependencies)
    {
        this.dependencies = dependencies;
    }

    public ProjectInfo getProjectInfo ()
    {
        return projectInfo;
    }

    public void setProjectInfo (ProjectInfo projectInfo)
    {
        this.projectInfo = projectInfo;
    }

    public String getReportSchema ()
    {
        return reportSchema;
    }

    public void setReportSchema (String reportSchema)
    {
        this.reportSchema = reportSchema;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [scanInfo = "+scanInfo+", dependencies = "+dependencies+", projectInfo = "+projectInfo+", reportSchema = "+reportSchema+"]";
    }
}