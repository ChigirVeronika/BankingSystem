function registrationFormValidation() {
    var name = document.Registration.name.value;
    var surname = document.Registration.surname.value;
    var card = document.Registration.pay_card_id.value;
    var email = document.Registration.email.value;
    var login = document.Registration.login.value;
    var password = document.Registration.password.value;


    if(userNameValidation(name)){
        if(userSurnameValidation(surname)){
            if(userEmailValidation(email)){
                if(userCardValidation(card)){
                    if(userLoginValidation(login)){
                        if(userPasswordValidation(password)){
                            return true;
                        }
                    }
                }
            }
        }
    }

    return false;
}

function userNameValidation(value){
    document.Registration.name.focus();
    var letters = /^[A-Za-z]+$/;
    if(value!=="") {
        if(value.length>1&&value.length<26){
            if(value.match(letters)){
                document.getElementById('userName-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('userName-msg').innerHTML="Please enter name from 2 till 25 letters";
    return false;
}

function userSurnameValidation(value){
    document.Registration.surname.focus();
    var letters = /^[A-Za-zА-Яа-я\-]+$/;
    if(value!=="") {
        if(value.length>1&&value.length<26){
            if(value.match(letters)){
                document.getElementById('userSurname-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('userSurname-msg').innerHTML="Please enter surname from 2 till 25 letters";
    return false;
}

function userEmailValidation(value){
    document.Registration.email.focus();
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(value!=="") {
        if(value.match(mailformat)){
            document.getElementById('userEmail-msg').innerHTML="";
            return true;
        }
    }
    document.getElementById('userEmail-msg').innerHTML="Please, enter correct email";
    return false;
}

function userCardValidation(value){
    document.Registration.pay_card_id.focus();
    var numbers = /^[0-9]+$/;
    if(value!=="") {
        if(value.length===16){
            if(value.match(numbers)){
                document.getElementById('userPaycard-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('userPaycard-msg').innerHTML="Please, enter correct pay card number";
    return false;
}

function userLoginValidation(value){
    document.Registration.login.focus();
    var letters = /^[0-9a-zA-ZА-Яа-я\-\s]+$/;
    if(value!=="") {
        if(value.length>5&&value.length<31) {
            if (value.match(letters)) {
                document.getElementById('userLogin-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('userLogin-msg').innerHTML="Please, enter login from 6 to 30 signs";
    return false;
}

function userPasswordValidation(value){
    document.Registration.password.focus();
    var letters = /^[0-9a-zA-Z]+$/;
    if(value!=="") {
        if(value.length>5&&value.length<31) {
            if (value.match(letters)) {
                document.getElementById('userPassword-msg').innerHTML="";
                return true;
            }
        }
    }
    document.getElementById('userPassword-msg').innerHTML="Please, enter password from 6 to 30 signs";
    return false;
}


