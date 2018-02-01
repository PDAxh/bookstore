$(function() {

    var data = {};
    data.title = $('#InputTitle');
    data.genre = $('#InputGenre');
    data.published = $('#InputPub');
    data.price = $('#InputPrice');
    data.inventory = $('#InputInv');
    data.bookAuthor = $('#InputAuthor');

    $.ajax({
        type: 'POST',
        data: JSON.stingify(data),
        contentType: 'application/json',
        url: 'http://localhost:3300/api/addBook',
        success: function (data) {
            console.log('success');
            console.log(JSON.stringify(data));
        }
    });
});

