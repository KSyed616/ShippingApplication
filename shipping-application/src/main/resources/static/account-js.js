var Username;
var Cpassword;
var Npassword;
var Saddress;
var Baddress;
var email;
var phonenumber;
var accounttype;

window.onload = function() { //Need to be populated with current information from database, for now random values have been included.
    //Grab elements
    Username = document.getElementById('username');
    Cpassword = document.getElementById('Cpassword');
    Npassword = document.getElementById('Npassword');
    Saddress = document.getElementById('Saddress');
    Baddress = document.getElementById('Baddress');
    email = document.getElementById('Email');
    phonenumber = document.getElementById('Phonenumber');
    accounttype = document.getElementById('Accounttype');

    //Assign data to elements for the account page
    Username.value = 'Hai';
    Cpassword.value = '';
    Npassword.value = '';
    Saddress.value = 'House';
    Baddress.value = 'House';
    email.value = 'Hai@gmail.com';
    phonenumber.value = '123-456-7890';
    accounttype.value = 'private'; //Must be in lower case.

    //Assign data to elements for header
    var list = document.getElementById('accountoptions')
    var option = document.createElement('option');
    option.selected = true;
    option.hidden = true;
    option.text = 'Welcome ' + Username.value;
    list.add(option);
}

function SubmitChanges(){
    Username = document.getElementById('username').value;
    Cpassword = document.getElementById('Cpassword').value;
    Npassword = document.getElementById('Npassword').value;

    if (Cpassword == 'Yes') { //Check if password matches database password
        Cpassword = Npassword; //Change the password to be saved
    }

    Saddress = document.getElementById('Saddress').value;
    Baddress = document.getElementById('Baddress').value;
    email = document.getElementById('Email').value;
    phonenumber = document.getElementById('Phonenumber').value;
    accounttype = document.getElementById('Accounttype').value;
}

function RedirectHome(){ //Change to Home page
    location.href = 'index.html';
}

function RedirectShipment(){ //Change to shipment page
    location.href = 'index.html';
}

function RedirectAbout(){//Change to about page
    location.href = 'index.html';
}

function RedirectAccountOptions(){
    var list = document.getElementById('accountoptions')
    option = list.value;
    if (option == 'status'){ //Redirect to account page
        location.href = 'index.html';
    }
    else if (option == 'logout'){ //Redirect to login page.
        location.href = 'index.html';
    }
}