document.getElementById('loginForm')
  .addEventListener('submit', function(event) {
  event.preventDefault();

  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  // Ssend the data to your server using AJAX or a traditional form POST
  console.log(`Trying to log in with email: ${email} and password: ${password}`)
});

document.getElementById('loginForm')
  .addEventListener('submit', function(event) {
  event.preventDefault();
  
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Basic verification against our mock database
    if(mockUsersDB[email] === password) {
        alert('Logged in successfully!');
    } else {
        alert('Invalid login credentials. Please try again.');
    }
  });


function RedirectSignup(){
  location.href = 'register.html';
}

function RedirectLanding(){
  location.href = 'account.html'
}

function SendPassword(){
  //Do stuff
}