package model;

public class HTMLDisplay {

    private String projectName;
    private String reportDate;
    private String totalDependenciesScanned;
    private int allDependencies;
    private int vulnerableDependencies;
    private int vulnerabilityFound;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getTotalDependenciesScanned() {
        return totalDependenciesScanned;
    }

    public void setTotalDependenciesScanned(String totalDependenciesScanned) {
        this.totalDependenciesScanned = totalDependenciesScanned;
    }

    public int getAllDependencies() {
        return allDependencies;
    }

    public void setAllDependencies(int allDependencies) {
        this.allDependencies = allDependencies;
    }

    public int getVulnerableDependencies() {
        return vulnerableDependencies;
    }

    public void setVulnerableDependencies(int vulnerableDependencies) {
        this.vulnerableDependencies = vulnerableDependencies;
    }

    public int getVulnerabilityFound() {
        return vulnerabilityFound;
    }

    public void setVulnerabilityFound(int vulnerabilityFound) {
        this.vulnerabilityFound = vulnerabilityFound;
    }

    public HTMLDisplay(String projectName, String reportDate, String totalDependenciesScanned, int allDependencies, int vulnerableDependencies, int vulnerabilityFound) {
        this.projectName = projectName;
        this.reportDate = reportDate;
        this.totalDependenciesScanned = totalDependenciesScanned;
        this.allDependencies = allDependencies;
        this.vulnerableDependencies = vulnerableDependencies;
        this.vulnerabilityFound = vulnerabilityFound;
    }
    
}
