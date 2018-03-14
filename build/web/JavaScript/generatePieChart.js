/* global google */

// Load google charts
google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(vulnerabilityChart);
google.charts.setOnLoadCallback(highestSeverityChart);
google.charts.setOnLoadCallback(CWEChart);


// Draw the chart and set the chart values
function vulnerabilityChart(obj) {
    var basicInfo = obj["3"];
    var allDependencies = basicInfo.allDependencies;
    var vulnerableDependencies = basicInfo.vulnerableDependencies;
    var notVulnerable = allDependencies - vulnerableDependencies;

    var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Not Vulnerable', notVulnerable],
        ['Vulnerable', vulnerableDependencies]
    ]);

    // Optional; add a title and set the width and height of the chart
    var options = {'title': 'Overall Dependencies Analysis',
        'width': 700,
        'height': 500,
        'fontSize': 20,
        'fontName': 'Source Sans Pro',
        'colors': ['#3b65c5', '#bdbbc3']
    };

    // Display the chart inside the <div> element with id="piechart"
    var chart = new google.visualization.PieChart(document.getElementById('vulnerabilityChart'));
    chart.draw(data, options);
}

function highestSeverityChart(obj) {
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

    if ((high > 0) || (low > 0) || (medium > 0)) {
        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['Low', low],
            ['Medium', medium],
            ['High', high]
        ]);

        // Optional; add a title and set the width and height of the chart
        var options = {'title': 'Highest Severity Analysis',
            'width': 700,
            'height': 500,
            'fontSize': 20,
            'fontName': 'Source Sans Pro',
            'colors': ['#48ffa7', '#ffdb6b', '#d97e78']
        };

        // Display the chart inside the <div> element with id="piechart"
        var chart = new google.visualization.PieChart(document.getElementById('severityChart'));
        chart.draw(data, options);
    }
}

function CWEChart(obj) {
    var CWEs = obj["5"];
    var low = 0;
    var medium = 0;
    var high = 0;
    var commonHigh = CWEs.mostCommonHigh;
    var commonMedium = CWEs.mostCommonMedium;
    var commonLow = CWEs.mostCommonLow;
    if (commonLow === null || commonLow === 0) {
        commonLow = "None";
    }
    if (commonMedium === null || commonMedium === 0) {
        commonMedium = "None";
    }
    if (commonHigh === null || commonHigh === 0) {
        commonHigh = "None";
    }
    
    console.log(commonHigh + "  " + commonMedium + "  " + commonLow);

    for (i = 0; i < CWEs.CWE.length; i++) {
        if (CWEs.Severity[i] === 'Low') {
            low++;
        } else if (CWEs.Severity[i] === 'Medium') {
            medium++;
        } else {
            high++;
        }
    }

    var data = google.visualization.arrayToDataTable([
        ['CWE', 'No. of CWEs', {role: 'style'}, {role: 'annotation'}],
        ['Low Severity', low, '#79b599', "Most Common CWE: \n" + commonLow],
        ['Medium Severity', medium, '#f1c454', "Most Common CWE: \n" + commonMedium],
        ['High Severity', high, '#d97e78', "Most Common CWE: \n" + commonHigh]
    ]);

//    var view = new google.visualization.DataView(data);
//    view.setColumns([0, 1,
//        {calc: "stringify",
//            sourceColumn: 1,
//            type: "string",
//            role: "annotation"},
//        2]);

    var options = {
        title: "Number of CWE per Severity",
        width: 1300,
        height: 500,
        fontSize: 20,
        fontName: 'Source Sans Pro',
        bar: {groupWidth: "60%"},
        legend: {position: "none"}
    };
    var chart = new google.visualization.ColumnChart(document.getElementById("CWEchart"));
    chart.draw(data, options);

}

