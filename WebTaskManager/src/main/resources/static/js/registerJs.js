function confirmPassword() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;


    if (confirmPassword == "") {
        document.getElementById("message").innerHTML = "Fill the password please!";
        return false;
    }

    if (confirmPassword.length < 8) {
        document.getElementById("message").innerHTML = "Password length must be at least 8 characters";
        return false;
    }

    if (confirmPassword.length > 15) {
        document.getElementById("message").innerHTML = "Password length must not exceed 15 characters";
        return false;
    }
    //
    // if (password != confirmPassword) {
    //     document.getElementById("message").innerHTML = "Confirm password is incorrect";
    //     return false;
    // } else {
    //     alert("Successful account registration");
    // }

}