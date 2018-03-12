<!DOCTYPE html>
<html>
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://xmlns.jcp.org/jsf/html"> 

<head>

<link href='https://fonts.googleapis.com/css?family=Source Sans Pro' rel='stylesheet'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link href="CSS/stylecss.css" rel="stylesheet" type="text/css"> 

    <script type="text/javascript" src="JavaScript/jquery-3.2.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript" src="JavaScript/fileUpload.js"></script>
    <script type="text/javascript" src="JavaScript/generateReport.js"></script>
    <script type="text/javascript" src="JavaScript/scrollTo.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="JavaScript/generatePieChart.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Dependency Scanner (JAVA)</title>
</head>

<body>
    <div class="parallax"> 
        <h1>Java Application Dependency Scanner</h1>
        <center>
            <img src="Pictures/down.png" style="height:75px;" onclick="scroll_to_div('instruction')" class="goToInstruction">
        </center>
    </div>

    <div class="background2">

        <table id="instruction">
            <tr><td>Step 1: Choose Your Files</td></tr>
            <tr><td>Step 2: Upload Files</td></tr>
            <tr><td>Step 3: Wait For Scan</td></tr>
            <tr><td>Step 4: View or Download Report</td></tr>
        </table>

    </div>
    
    <div class="webcontent">

        <center>
            <div>
                <FORM method="POST" enctype="multipart/form-data" id="uploadForm">
                    <h3>Please Select Files to Upload : </h3>
                    <h5>*(File Extension of .JAR or .WAR)* </h5>
                    <input type="file" name="selectFile" multiple="multiple" id="files"/>

                    <input type="submit" height="30px" width="30px" value="Upload" class="button" id="submitUpload"/>
                    <label id="files-error" class="error" for="files"></label>
                </FORM>
            </div>

            <div class="progress">
                <div id="progressBar" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
                    0%
                </div>
            </div>

            <h4>Status: </h4>
            <div id="ajaxGetUserServletResponse" class="response"></div>

            <label id="display"></label>
            <div id="loader" class="loader"></div>

    </div>

    <div class="parallax">
        <div id="displayReport">
            <a id="reportLink" href="" class="download" target="_blank">
                <img src="Pictures/viewFile.png" style="height:180px;">
                    <h3> View Report Here </h3>
            </a>
        </div>

    </div>
    
    <div class="displayHTML" id="displayHTML">
        <center>
            <img src="Pictures/down.png" style="height:75px;" onclick="scroll_to_div('displayHTML')" class="goToInstruction">
            <p id="projectName">  </p> 
            <p id="projectDate">  </p>
            <hr>
            <table id="displayInformation">
                <tr>
                    <th>Dependencies Scanned</th>
                    <th>Vulnerable Dependencies</th>
                    <th>Vulnerability Found</th>
                </tr>
                <tr>
                    <td id="dependenciesScanned" class="displayStats"></td>
                    <td id="vulnerableDependencies" class="displayStats"></td>
                    <td id="vulnerabilityFound" class="displayStats"></td>
                </tr>
            </table>

            <table class="columns">
                <tr>
                    <td><div id="vulnerabilityChart"></div></td>
                    <td><div id="severityChart"></div></td>
                </tr>
            </table>
     
            <div id="dynamicContent">

            </div>               

            <img src="Pictures/return.png" style="height:75px;" onclick="scroll_to_div('instruction')" class="returnHome">
        </center>
    </div>
    
    <div class="webfooter"> Nanyang Technological University: School of Computer Science and Engineering </div>
    </center>

    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <script type="text/javascript" src="JavaScript/fileValidation.js"></script>
</body>
</html>




