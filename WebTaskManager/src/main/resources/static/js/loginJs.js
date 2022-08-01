
function valiDate() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    if (username == "") {
        alert("Username connot be empty");
        return false;
    }

    if (username.length <= 3 || username.length >= 256){
        alert("Username must enter 3-256 characters");
        return false;
    }

    if (password == "") {
        alert("Password connot be empty");
        return false;
    }

    if (password.length < 3 || password.length > 256) {
        alert("loz must enter 8-256 characters");
        return false;
    }

}
