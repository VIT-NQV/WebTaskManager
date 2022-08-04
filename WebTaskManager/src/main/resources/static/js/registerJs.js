
function confirmPassword() {

    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let message = "";
    let result = true;
    console.log(confirmPassword);

    if (!confirmPassword) {
        document.getElementById("messageConfirm").innerText = "Fill the password please!";
        result = false;
    } else if (confirmPassword.length < 8 || confirmPassword.length > 15) {
        document.getElementById("messageConfirm").innerText = "Password length must be at least 8-15 characters";
        result = false;
    } else {
        document.getElementById("messageConfirm").innerText = "";
    }

    if (password !== confirmPassword) {
        document.getElementById("messageConfirm").innerText = "Confirm password is incorrect";
        result = false;
    } else {
        document.getElementById("messageConfirm").innerText = "";
    }


    // document.getElementById("messageConfirm").innerText = message;
    return result;

}