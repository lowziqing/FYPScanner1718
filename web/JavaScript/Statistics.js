$(document).ready(function () {

    /* global google */

// Load google charts
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(CVETrend);
    function CVETrend() {

        var data = google.visualization.arrayToDataTable([
            ['CVEs', 'No. of CVEs'],
            ['2007', 6516],
            ['2008', 5632],
            ['2009', 5732],
            ['2010', 4639],
            ['2011', 4150],
            ['2012', 5288],
            ['2013', 5187],
            ['2014', 7937],
            ['2015', 6487],
            ['2016', 6447],
            ['2017', 14646]
        ]);

        var options = {
            title: "Number of CVEs per Year",
            width: 1300,
            height: 700,
            fontSize: 20,
            fontName: 'Source Sans Pro',
            bar: {groupWidth: "60%"},
            legend: {position: "none"},
            trendlines: {
            0: {
              type: 'linear',
              showR2: true,
              visibleInLegend: true
            }
        }
        };
        var chart = new google.visualization.LineChart(document.getElementById("CVEchart"));
        chart.draw(data, options);
    }

});
