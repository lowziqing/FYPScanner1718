function generateReport(obj) {
    var basicInfo = obj["3"];
    var vulnerableDependencies = obj["4"];

    console.log("basic info " + basicInfo.projectName);
    console.log("basic info date " + basicInfo.reportDate);

    document.getElementById("projectName").innerHTML = basicInfo.projectName;
    document.getElementById("projectDate").innerHTML = basicInfo.reportDate;
    document.getElementById("dependenciesScanned").innerHTML = basicInfo.totalDependenciesScanned;
    document.getElementById("vulnerableDependencies").innerHTML = basicInfo.vulnerableDependencies;
    document.getElementById("vulnerabilityFound").innerHTML = basicInfo.vulnerabilityFound;

    console.log("xxxxxxxxxxxxxxxxxx" + vulnerableDependencies.CPE);
    console.log("check the remaining" + vulnerableDependencies);

    var html = "<table id='displayVulnerable'>";
    var counter = 1;
    html += "<tr><th>No.</th><th>Vulnerable Dependencies</th><th>CPEs</th><th>Severity</th><th>CVE Counts</th></tr>";

    if (vulnerableDependencies.dependenciesName.length > 0) {
        for (i = 0; i < vulnerableDependencies.dependenciesName.length; i++) {
            html += "<tr>";
            html += "<td><center>" + counter + "</center></td>";
            html += "<td>" + vulnerableDependencies.dependenciesName[i] + "</td>";
            html += "<td>";
            for (j = 0; j < vulnerableDependencies.CPE[i].length; j++) {
                html += vulnerableDependencies.CPE[i][j] + "<br>";
            }
            html += "</td>";
            html += "<td><center>" + vulnerableDependencies.severity[i] + "</center></td>";
            html += "<td><center>" + vulnerableDependencies.CVEcount[i] + "</center></td>";
            html += "</tr>";
            counter++;
        }

        html += "</table>";
        document.getElementById("dynamicContent").innerHTML = html;
    } else {
        return false;
    }
}