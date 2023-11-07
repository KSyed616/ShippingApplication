var Username;
var CPassword;
var email;
var phonenumber;
var accounttype;
var Saddress;
var Baddress;

document
.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('signupForm');
    const errorModal = document.getElementById('errorModal');
    const closeModal = document.getElementById('closeModal');
    const errorText = document.getElementById('errorText');
  
    form.addEventListener('submit', function(event) {
      event.preventDefault();
  
      Username = document.getElementById('firstName').value;
      CPassword = document.getElementById('password').value;
      email = document.getElementById('email').value;
      phonenumber = '';
      accounttype = 'private';
      Saddress = '';
      Baddress = '';
  
      if (CPassword.length < 8) {
        errorText.textContent = 'Password should be at least 8 characters long.';
        errorModal.style.display = 'block';
      } 
      else {
        console.log('Form is valid, submit the data');
      }
    });
  
    closeModal.addEventListener('click', function() {
      errorModal.style.display = 'none';
    });
  
    window.addEventListener('click', function(event) {
      if (event.target === errorModal) {
        errorModal.style.display = 'none';
      }
    });
  });
  
function RedirectLogin(){
    location.href = 'index.html';
}