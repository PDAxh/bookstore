// Denna fungerar
function createAuthor() {
    var xhr = new XMLHttpRequest();

    xhr.onload = function() {
        if(xhr.status == 200) {
            var responseObject = JSON.parse(xhr.responseText);
            console.log(responseObject);
        }
    }

    xhr.open('POST', 'http://localhost:3300/api/addAuthor', true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = function () {
        if( xhr.readyState=== 4 && xhr.status===200){
            var json = JSON.parse(xhr.responseText);
            console.log(json.name )
        }
    };

    var inputName = document.getElementById("InputAddAuthorName").value;
    console.log(inputName);
    var data = JSON.stringify({"name": inputName});
    xhr.send(data);
}



