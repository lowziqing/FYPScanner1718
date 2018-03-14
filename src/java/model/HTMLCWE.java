package model;

import java.util.ArrayList;

public class HTMLCWE {
    private ArrayList<String> CWE;
    private ArrayList<String> Severity;
    private String mostCommonHigh;
    private String mostCommonMedium;
    private String mostCommonLow;

    public ArrayList<String> getCWE() {
        return CWE;
    }

    public void setCWE(ArrayList<String> CWE) {
        this.CWE = CWE;
    }

    public ArrayList<String> getSeverity() {
        return Severity;
    }

    public void setSeverity(ArrayList<String> Severity) {
        this.Severity = Severity;
    }

    public String getMostCommonHigh() {
        return mostCommonHigh;
    }

    public void setMostCommonHigh(String mostCommonHigh) {
        this.mostCommonHigh = mostCommonHigh;
    }

    public String getMostCommonMedium() {
        return mostCommonMedium;
    }

    public void setMostCommonMedium(String mostCommonMedium) {
        this.mostCommonMedium = mostCommonMedium;
    }

    public String getMostCommonLow() {
        return mostCommonLow;
    }

    public void setMostCommonLow(String mostCommonLow) {
        this.mostCommonLow = mostCommonLow;
    }

    public HTMLCWE(ArrayList<String> CWE, ArrayList<String> Severity, String mostCommonHigh, String mostCommonMedium, String mostCommonLow) {
        this.CWE = CWE;
        this.Severity = Severity;
        this.mostCommonHigh = mostCommonHigh;
        this.mostCommonMedium = mostCommonMedium;
        this.mostCommonLow = mostCommonLow;
    }

}
