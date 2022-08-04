function validate() {

    let username = document.myForm.username.value;
    let password = document.myForm.password.value;
    let result = true;

    if (username == "") {
        document.getElementById("messageUsername").innerText = "Fill the Username please!";
        result = false;
    } else {
        document.getElementById("messageUsername").innerText = "";
    }

    if (username.length <= 3 || username.length >= 256) {
        document.getElementById("messageUsername").innerText = "Username must enter 3-256 characters";
        result = false;
    } else {
        document.getElementById("messageUsername").innerText = "";
    }

    if (password == "") {
        document.getElementById("messagePassword").innerText = "Fill the Password please!";
        result = false;
    } else {
        document.getElementById("messagePassword").innerText = "";
    }

    if (password.length < 3 || password.length > 15) {
        document.getElementById("messagePassword").innerText = "Password must enter 3-15 characters";
        result = false;
    } else {
        document.getElementById("messagePassword").innerText = "";
    }

    return result;
}
