package Controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import model.Dependencies;
import model.HTMLDisplay;
import model.HTMLVulnerability;
import model.MyFolder;
import model.ProjectInfo;
import model.ReportData;

public class JSONController {

    public static HttpServletResponse response;
    public static Gson gson = new Gson();

    public JSONController(HttpServletResponse response) {
        JSONController.response = response;
        response.setContentType("APPLICATION/JSON");
        response.setCharacterEncoding("UTF-8");
    }

    public static void convertObject(String folderID) throws IOException {
        List<Object> JSON = new ArrayList<>();
        MyFolder folder = FolderController.getFolder(folderID);
        ReportData reportData = (ReportData) AnalyseReportController.deserialiseJSONReport(folderID);
        ProjectInfo projectInfo = reportData.getProjectInfo();
        Dependencies dependencies[] = reportData.getDependencies();
        HTMLDisplay display = (HTMLDisplay) JSOUPController.getInformation(folderID);
        HTMLVulnerability vulnerability = (HTMLVulnerability) JSOUPController.getVulnerableDependencies(folderID);
        
        JSON.add(folder);
        JSON.add(projectInfo);
        JSON.add(dependencies);
        JSON.add(display);
        JSON.add(vulnerability);

        try {
            response.getWriter().write(gson.toJson(JSON));
            response.getWriter().flush();
        } catch (IOException ex) {
            System.out.println("error message: " + ex);
        }
    }

}

// once response is called, ajax will know it is successful.
