/* global google */

// Load google charts
google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(vulnerabilityChart);
google.charts.setOnLoadCallback(severityChart);

// Draw the chart and set the chart values
function vulnerabilityChart(obj) {
    var basicInfo = obj["3"];
    var allDependencies = basicInfo.allDependencies;
    var vulnerableDependencies = basicInfo.vulnerableDependencies;
    var notvulnerable = allDependencies - vulnerableDependencies;

    var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Not Vulnerable', notvulnerable],
        ['Vulnerable', vulnerableDependencies]
    ]);

    // Optional; add a title and set the width and height of the chart
    var options = {'title': 'Overall Dependencies Analysis',
        'width': 750,
        'height': 400,
        'fontSize': 20,
        'fontName': 'Source Sans Pro',
        'colors': ['#3dbfff', '#ff6d6d']
    };

    // Display the chart inside the <div> element with id="piechart"
    var chart = new google.visualization.PieChart(document.getElementById('vulnerabilityChart'));
    chart.draw(data, options);
}

function severityChart(obj) {
    var vulnerableDependencies = obj["4"];
    var low = 0;
    var medium = 0;
    var high = 0;

    for (i = 0; i < vulnerableDependencies.severity.length; i++) {
        if (vulnerableDependencies.severity[i] === 'Low') {
            low++;
        } else if (vulnerableDependencies.severity[i] === 'Medium') {
            medium++;
        } else {
            high++;
        }
    }

    if((high === 0) || (low === 0) || (medium === 0)){
        return false;
    }
    
    var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Low', low],
        ['Medium', medium],
        ['High', high]
    ]);

    // Optional; add a title and set the width and height of the chart
    var options = {'title': 'Overall Severity Analysis',
        'width': 750,
        'height': 400,
        'fontSize': 20,
        'fontName': 'Source Sans Pro',
        'colors': ['#48ffa7', '#ffdb6b', '#ff6d6d']
    };

    // Display the chart inside the <div> element with id="piechart"
    var chart = new google.visualization.PieChart(document.getElementById('severityChart'));
    chart.draw(data, options);
}