package model;

public class Dependencies {

    private String description;
    //private String[] identifiers;
    private String filePath;
    private EvidenceCollected evidenceCollected;
    private String md5;
    private String fileName;
    private String sha1;
    private String isVirtual;
    private Vulnerabilities[] vulnerabilities;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Vulnerabilities[] getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Vulnerabilities[] vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

//    public String[] getIdentifiers() {
//        return identifiers;
//    }
//
//    public void setIdentifiers(String[] identifiers) {
//        this.identifiers = identifiers;
//    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public EvidenceCollected getEvidenceCollected() {
        return evidenceCollected;
    }

    public void setEvidenceCollected(EvidenceCollected evidenceCollected) {
        this.evidenceCollected = evidenceCollected;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    @Override
    public String toString() {
        return "ClassPojo [filePath = " + filePath + ", evidenceCollected = " + evidenceCollected + ", md5 = " + md5 + ", fileName = " + fileName + ", sha1 = " + sha1 + "description = " + description + ", isVirtual = " + isVirtual + ", vulnerabilities = " + vulnerabilities + "]";
    }
}
