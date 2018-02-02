var xhr = new XMLHttpRequest();

    xhr.onload = function() {
            if(xhr.status == 200) {
                var responseObject = JSON.parse(xhr.responseText);
                console.log(responseObject);
                createBookTable();
            }
        }

    xhr.open('GET', 'http://localhost:3300/api/books', true);
    xhr.send(null);

function createBookTable() {
    var bookTable = '<table><tr><th>';
    $.each(data, function()_,obj)
}
