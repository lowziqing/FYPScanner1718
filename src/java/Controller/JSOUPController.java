/*
    Extract out all the information information generated In HTML format
*/

package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.HTMLDisplay;
import model.HTMLVulnerability;
import model.HTMLCWE;
import model.MyFolder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUPController {

    public static HTMLDisplay HD;
    public static MyFolder folder;
    public static HTMLVulnerability HV;
    public static HTMLCWE CWE;

    public static Object getInformation(String folderID) {
        try {
            Document doc = getDocument(folderID, "dependency-check-report.html");
            Elements reportName = doc.select("h2:contains(Project_)");
            Elements reportDate = doc.select("li:contains(Report Generated On)");
            Elements reportDependenciesScanned = doc.select("li:contains(Dependencies Scanned)");
            Elements reportVulnerableDependencies = doc.select("li:contains(Vulnerable Dependencies)");
            Elements reportVulnerabilitiesFound = doc.select("li:contains(Vulnerabilities Found)");

            String Names = getElement(reportName);
            String Dates = getElement(reportDate);

            String[] dependenciesScannedSplit = getElement(reportDependenciesScanned).trim().split("\\s+");
            String[] vulnerableDependenciesSplit = getElement(reportVulnerableDependencies).trim().split("\\s+");
            String[] vulnerabilitiesFoundSplit = getElement(reportVulnerabilitiesFound).trim().split("\\s+");
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

        try {
            Document doc = getDocument(folderID, "dependency-check-report.html");
            Elements reportVulnerabilities = doc.select("tr.vulnerable");
            //Elements reportEnd = reportVulnerabilities.select("td:matches((?s)^((?!cpe:).)*$)");
            //Elements reportCPEs = reportVulnerabilities.select("td:contains(cpe:)");

            ArrayList<String> dependenciesNames = new ArrayList<>();
            ArrayList<ArrayList<String>> CPEs = new ArrayList<>();
            ArrayList<String> Severity = new ArrayList<>();
            ArrayList<Integer> CVEcount = new ArrayList<>();

            int j = 0;
            for (Element element : reportVulnerabilities) {
                String storedCPE = "";
                String storedData = "";
                String storedSeverity = "";
                String storedNumber = "";
                String data = element.text();
                String[] splitStr = data.trim().split("\\s+");
                for (int i = 0; i < splitStr.length; i++) {
                    if (splitStr[i].contains("cpe:")) {
                        storedCPE += splitStr[i] + " ";
                    } else if (splitStr[i].contains("High") || splitStr[i].contains("Medium") || splitStr[i].contains("Low")) {
                        storedSeverity = splitStr[i];
                    } else if (splitStr[i].matches("\\d+")) {
                        storedNumber += splitStr[i] + " ";
                    } else {
                        storedData += splitStr[i] + " ";
                    }
                }

                String[] Str = storedData.trim().split("\\s+");
                String[] CPE = storedCPE.trim().split("\\s+");
                String[] number = storedNumber.trim().split("\\s+");

                CVEcount.add(Integer.parseInt(number[0]));
                dependenciesNames.add(Str[0] + " " + Str[1]);
                Severity.add(storedSeverity);

                for (int m = 0; m < CPE.length; m++) {
                    CPEs.add(new ArrayList<String>());
                    CPEs.get(j).add(CPE[m]);
                }
                j++;
            }
            System.out.println("finish all the for loop");

            HV = new HTMLVulnerability(dependenciesNames, CPEs, Severity, CVEcount);

        } catch (IOException exception) {
            System.out.println("getVulnerableDependencies Parsing Error" + exception);
        }
        return HV;
    }

    public static Object getCWE(String folderID) {
        try {
            Document doc = getDocument(folderID, "dependency-check-vulnerability.html");
            Elements reportCWEs = doc.select("tr");
            ArrayList<String> CWEs = new ArrayList<>();
            ArrayList<String> Severity = new ArrayList<>();
            ArrayList<String> highCWE = new ArrayList<>();
            ArrayList<String> mediumCWE = new ArrayList<>();
            ArrayList<String> lowCWE = new ArrayList<>();

            for (Element element : reportCWEs) {
                String storedCWEs = "";
                String storedSeverity = "";
                String data = element.text();
                String[] splitStr = data.trim().split("\\s+");

                for (int i = 0; i < splitStr.length; i++) {
                    if (splitStr[i].contains("CWE-")) {
                        System.out.println("Found String that Contains CWE- " + splitStr[i]);
                        storedCWEs += splitStr[i] + " ";
                        i++;
                        while (!(splitStr[i].contains("Medium") || splitStr[i].contains("Low") || splitStr[i].contains("High"))) {
                            storedCWEs += splitStr[i] + " ";
                            System.out.println("While not = severity " + splitStr[i]);
                            i++;
                        }
                        if (splitStr[i].contains("High")) {
                            System.out.println("High Value High Value " + storedCWEs);
                            highCWE.add(storedCWEs);
                        } else if (splitStr[i].contains("Medium")) {
                            System.out.println("Medium Value Medium Value " + storedCWEs);
                            mediumCWE.add(storedCWEs);
                        } else if (splitStr[i].contains("Low")) {
                            System.out.println("Low Value Low Value " + storedCWEs);
                            lowCWE.add(storedCWEs);
                        }
                        storedSeverity = splitStr[i];
                    }
                }
                CWEs.add(storedCWEs);
                Severity.add(storedSeverity);
            }

            CWE = new HTMLCWE(CWEs, Severity, mostCommonElement(highCWE), mostCommonElement(mediumCWE), mostCommonElement(lowCWE));
        } catch (IOException ex) {
            System.out.println("Error While Splitting String: " + ex);
        }
        return CWE;
    }

    public static String getElement(Elements HTMLTag) {
        String print = "";
        for (Element element : HTMLTag) {
            print = element.text();
        }
        return print;
    }

    public static Document getDocument(String folderID, String fileName) throws IOException {
        folder = FolderController.getFolder(folderID);
        File input = new File("C://Users/Low Zi Qing/Documents/NetBeansProjects/FYPScanner-1718/web/generatedJSON/"
                + folder.getFolderName() + "/" + fileName);
        Document doc = Jsoup.parse(input, "UTF-8");
        return doc;
    }

    private static String mostCommonElement(ArrayList<String> list) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < list.size(); i++) {

            Integer frequency = map.get(list.get(i));
            if (frequency == null) {
                map.put(list.get(i), 1);
            } else {
                map.put(list.get(i), frequency + 1);
            }
        }

        String mostCommonKey = null;
        int maxValue = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxValue) {
                mostCommonKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return mostCommonKey;
    }

}