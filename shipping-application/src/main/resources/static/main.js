var accUsername
var accPassword
var accEmail
var loginUsername
var loginPassword

function registerAcc() {
    accUsername = document.getElementById("loginUsername").value;
    accPassword = document.getElementById("loginPassword").value;
    accEmail = document.getElementById("email").value;
    console.log(accUsername, accPassword, accEmail)
}

function login() {
    loginUsername = document.getElementById("username").value;
    loginPassword = document.getElementById("password").value;
    console.log(loginUsername, loginPassword);
}
