$(document).ready(function () {
    $("#submitUpload").click(function (event) {

        event.preventDefault();//stop submit the form, we will post it manually.
        var form = $('#uploadForm')[0]; // Get form
        var data = new FormData(form);// Create an FormData object
        var formValidate = $("#uploadForm");

        if (formValidate.valid()) {
            $('a.download').css({"display": "none"});
            $.ajax({
                xhr: function () {
                    var xhr = new window.XMLHttpRequest();
                    xhr.upload.addEventListener('progress', function (e) {
                        if (e.lengthComputable) {
                            var percent = Math.round((e.loaded / e.total) * 100);
                            $('#progressBar').attr('aria-valuenow', percent).css('width', percent + '%').text(percent + '%');
                            $('#loader').css({"display": "block"});
                            if (percent === 100) {
                                $('#display').text("Scanning Files: Please Wait");
                                $('#ajaxGetUserServletResponse').text("");
                            }
                        }
                    });
                    return xhr;
                },
                type: 'POST',
                enctype: 'multipart/form-data',
                url: 'UploadServlet',
                data: data,
                processData: false,
                contentType: false,
                timeout: 600000,
                success: function (data) {
                    obj = JSON.parse(data);
                    generateReport(obj);
                    vulnerabilityChart(obj);
                    highestSeverityChart(obj);
                    CWEChart(obj);
                    var folder = obj["0"];
                    console.log(obj);
                    $("#reportLink").attr("href", 'http://localhost:8080/FYPScanner-1718/generatedJSON/'
                            + folder.folderName + '/dependency-check-report.html');
                    $("#submitUpload").prop("disabled", false);
                    $('#ajaxGetUserServletResponse').text("Scan Completed!");
                    $('#loader').css({"display": "none"});
                    $('#display').css({"display": "none"});
                    $('a.download').css({"display": "block"});
                    $('#displayHTML').css({"display": "block"});
                    scroll_to_div("reportLink");
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                    $("#submitUpload").prop("disabled", false);
                }
            });

        }
    });


});
