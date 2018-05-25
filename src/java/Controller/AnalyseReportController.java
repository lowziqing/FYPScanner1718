/*
    Read the JSON file
    Convert to GSON and create it to ReportData.class
*/

package Controller;

import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import model.MyFolder;
import model.ReportData;

public class AnalyseReportController {

    public static ReportData reportData;

    public static Object deserialiseJSONReport(String folderID) throws IOException {
        Gson gson = new Gson();
        MyFolder folder = FolderController.getFolder(folderID);
        try {
            FileReader file = new FileReader(folder.getFolderJSONDirectory() + "/dependency-check-report.json");
            reportData = gson.fromJson(file, ReportData.class);

        } catch (Exception e) {
            System.out.println("Error Message" + e);
        }
        return reportData;
    }

}
