<!DOCTYPE html>
<html>
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://xmlns.jcp.org/jsf/html"> 

<head>

<link href='https://fonts.googleapis.com/css?family=Source Sans Pro' rel='stylesheet'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link href="CSS/HowItWorks.css" rel="stylesheet" type="text/css"> 

    <script type="text/javascript" src="JavaScript/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="JavaScript/scrollTo.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Dependency Scanner (JAVA)</title>
</head>

<body>
    <div class="parallax"> 
        <div class="navigation">
        <table class="menu">
            <tr>
                <td><a href="http://localhost:8080/FYPScanner-1718/"> HOME </a></td>
                <td><a href="http://localhost:8080/FYPScanner-1718/HowItWorks.jsp"> HOW IT WORKS </a></td>
                <td><a href="http://localhost:8080/FYPScanner-1718/Statistics.jsp"> STATISTICS </a></td>
            </tr>
        </table>
        </div>
        <h1>How It Works</h1>
    </div>

    <div class="webcontent">

        <h1 class="header"> Searching For Vulnerabilities </h1>
        
        <table class="logo">
            <tr class="pictures" align="center">
                <td><img src="Pictures/OWASP.png" style="height:150px;"></td>
                <td><img src="Pictures/DependencyCheck.PNG" style="height:150px;"></td>
                <td></td>
            </tr>
        </table>
        
        <p> Java Application Dependency Scanner is running on OWASP Dependency-check. A series of analyzers is executed to inspect the project dependencies, 
            collect pieces of information about the dependencies (referred to as evidence within the tool). 
            Collected evidence will be used to identify the Common Platform Enumeration (CPE) for the given dependency. 
            If a CPE is identified, a listing of associated Common Vulnerability and Exposure (CVE) entries are listed in a report.</p>

        <h1 class="header"> common platform enumeration </h1>
        <p> 
           CPE is a structured method to name software applications, hardware applications, 
           and packages. It references to the generic syntax of Uniform Resources Identifiers (URI), 
           CPE comprises of a name format, a method for checking names against a system, 
           and a formal description for binding text and tests to a name. 
        </p>

        <h1 class="header"> common vulnerabilities and exposures </h1>
        <p>
            CVE is a chronical list of known security threats for publicly disclosed cybersecurity vulnerabilities and exposures. 
            The aim of CVE is to simplify the sharing of data across separate platforms such as vulnerability capabilities 
            (tools, databases, and services) with this definition.
            <b>CVE entries comprise of:</b> <br>
                <ol>
                    <li>Identification numbers.</li>
                    <li>Brief Description.</li>
                    <li>At least one public reference.</li>
                    <li>Indication of status.</li>
                </ol> 
        </p>

    </div>

    <div class="parallax2">

    </div>
    
    <div class="webfooter"> Nanyang Technological University: School of Computer Science and Engineering </div>
    </center>

</body>
</html>




