$(function () {
    $("#uploadForm").validate({
        rules: {
            selectFile: {
                required: true,
                extension: "jar|war"
            }
        },
        messages: {
            selectFile: {
                required: "Please upload a file",
                extension: "Please select .JAR or .WAR files"
            }
        }
    });
});