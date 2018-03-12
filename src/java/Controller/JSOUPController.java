package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.HTMLDisplay;
import model.HTMLVulnerability;
import model.MyFolder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUPController {

    public static HTMLDisplay HD;
    public static MyFolder folder;
    public static HTMLVulnerability HV;

    public static Object getInformation(String folderID) {
        folder = FolderController.getFolder(folderID);
        File input = new File("C://Users/Low Zi Qing/Documents/NetBeansProjects/FYPScanner-1718/web/generatedJSON/"
                + folder.getFolderName() + "/dependency-check-report.html");
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements reportName = doc.select("h2:contains(Project_)");
            Elements reportDate = doc.select("li:contains(Report Generated On)");
            Elements reportDependenciesScanned = doc.select("li:contains(Dependencies Scanned)");
            Elements reportVulnerableDependencies = doc.select("li:contains(Vulnerable Dependencies)");
            Elements reportVulnerabilitiesFound = doc.select("li:contains(Vulnerabilities Found)");

            String Names = getElement(reportName);
            String Dates = getElement(reportDate);
            String dependenciesScanned = getElement(reportDependenciesScanned);
            String vulnerableDependencies = getElement(reportVulnerableDependencies);
            String vulnerabilitiesFound = getElement(reportVulnerabilitiesFound);

            String[] dependenciesScannedSplit = dependenciesScanned.trim().split("\\s+");
            String[] vulnerableDependenciesSplit = vulnerableDependencies.trim().split("\\s+");
            String[] vulnerabilitiesFoundSplit = vulnerabilitiesFound.trim().split("\\s+");
            String totalDependenciesScanned = dependenciesScannedSplit[2] + " "
                    + dependenciesScannedSplit[3] + " " + dependenciesScannedSplit[4];

            HD = new HTMLDisplay(Names, Dates, totalDependenciesScanned, Integer.parseInt(dependenciesScannedSplit[2]),
                    Integer.parseInt(vulnerableDependenciesSplit[2]), Integer.parseInt(vulnerabilitiesFoundSplit[2]));

        } catch (IOException ex) {
            System.out.println("Error Message: " + ex);
        }
        return HD;
    }

    public static Object getVulnerableDependencies(String folderID) {
        folder = FolderController.getFolder(folderID);
        File input = new File("C://Users/Low Zi Qing/Documents/NetBeansProjects/FYPScanner-1718/web/generatedJSON/"
                + folder.getFolderName() + "/dependency-check-report.html");

        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements reportVulnerabilities = doc.select("tr.vulnerable");
            //Elements reportEnd = reportVulnerabilities.select("td:matches((?s)^((?!cpe:).)*$)");
            //Elements reportCPEs = reportVulnerabilities.select("td:contains(cpe:)");

            ArrayList<String> dependenciesNames = new ArrayList<>();
            ArrayList<ArrayList<String>> CPEs = new ArrayList<>();
            ArrayList<String> Severity = new ArrayList<>();

            int j = 0;
            for (Element element : reportVulnerabilities) {
                String storedCPE;
                String storedData;
                String storedSeverity;
                storedCPE = storedData = storedSeverity = "";
                String data = element.text();
                String[] splitStr = data.trim().split("\\s+");
                for (int i = 0; i < splitStr.length; i++) {
                    if (splitStr[i].contains("cpe:")) {
                        storedCPE += splitStr[i] + " ";
                    } else if (splitStr[i].contains("High") || splitStr[i].contains("Medium") || splitStr[i].contains("Low")) {
                        storedSeverity = splitStr[i];
                    } else {
                        storedData += splitStr[i] + " ";
                    }
                }

                String[] Str = storedData.trim().split("\\s+");
                String[] CPE = storedCPE.trim().split("\\s+");

                dependenciesNames.add(Str[0] + " " + Str[1]);
                Severity.add(storedSeverity);

                for (int m = 0; m < CPE.length; m++) {
                    CPEs.add(new ArrayList<String>());
                    CPEs.get(j).add(CPE[m]);
                }
                j++;
            }
            System.out.println("finish all the for loop");

            HV = new HTMLVulnerability(dependenciesNames, CPEs, Severity);
            for (int i = 0; i < CPEs.size(); i++) {
                for (int m = 0; m < CPEs.get(i).size(); m++) {
                    System.out.println("CPE " + i + ": " + CPEs.get(i).get(m));
                }
            }
            for (int i = 0; i < dependenciesNames.size(); i++) {
                System.out.println("Dependency Number " + i + " " + dependenciesNames.get(i));
            }

        } catch (IOException exception) {
            System.out.println("getVulnerableDependencies Parsing Error" + exception);
        }
        return HV;
    }

    public static String getElement(Elements HTMLTag) {
        String print = "";
        for (Element element : HTMLTag) {
            print = element.text();
        }
        return print;
    }

}
