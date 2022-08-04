function confirmPassword() {

    let password = document.myForm.password.value;
    let confirmPassword = document.myForm.confirmPassword.value;
    let result = true;

    if (password != confirmPassword) {
        document.getElementById("message").innerText = "Fill the password please!";
        result = false;
    }

    if (confirmPassword.length < 8 || confirmPassword.length > 15) {
        document.getElementById("message").innerText = "Password length must be at least 8 characters";
        result = false;
    }

    if (confirmPassword.length > 15) {
        document.getElementById("message").innerText = "Password length must not exceed 15 characters";
        result = false;
    }

    return result;

}