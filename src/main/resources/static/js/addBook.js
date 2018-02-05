var xhr = new XMLHttpRequest();

xhr.onload = function () {
    if (xhr.status == 200) {
        var responseObject = JSON.parse(xhr.responseText);
        console.log(responseObject);
        createAddBookTable(responseObject);
    }
}

xhr.open('GET', 'http://localhost:3300/api/books', true);
xhr.send(null);

function createAddBookTable(data) {
    console.log(data);
    var addBookTable = '<table class="table"><thead><tr><th scope="col">Title</th><th scope="col">Genre</th><th scope="col">Published</th><th scope="col">Price</th><th scope="col">Inventory</th><th scope="col">Author</th><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></th><tr></thead><tbody>';

    $.each(data, function (key, item) {
        addBookTable += '<tr><td scope="row"><p>'
            + item.title + '</p></td><td scope="row"><p>'
            + item.genre + '</p></td><td scope="row"><p>'
            + item.published + '</p></td><td scope="row"><p>'
            + item.price + '</p></td><td scope="row"><p>'
            + item.inventory + '</p></td><td scope="row"> ' +
            '+ \'</p></td><td scope="row"><p>\' ' +
            '+ item.author <button type="button" class="btn btn-default">' +
            '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button><button type="button" class="btn btn-default">' +
            '<span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button><a href="editBook.html"><button type="button" class="btn btn-primary" aria-label="Left Align"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></a><button type="button" class="btn btn-danger" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button><button type="button" class="btn btn-warning" aria-label="Left Align" data-toggle="modal" href="#myModal"><span class="glyphicon glyphicon-star" aria-hidden="true"></span></button><a href="ratingStatistics.html"><button type="button" class="btn btn-info" aria-label="Left Align"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span></button></a></td></tr>';
    });
    console.log(addBookTable);
    addBookTable += '</tbody></table>';
    $('#addBookTableContainer').html(addBookTable);
}
