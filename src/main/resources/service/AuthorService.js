$(function() {

    var data = {};
    data.title = $('#InputName');

    $.ajax({
        type: 'POST',
        data: JSON.stingify(data),
        contentType: 'application/json',
        url: 'http://localhost:3300/api/addAuthor',
        success: function (data) {
            console.log('success');
            console.log(JSON.stringify(data));
        }
    });
});