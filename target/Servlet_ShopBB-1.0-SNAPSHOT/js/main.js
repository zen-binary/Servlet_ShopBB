var btnLoginRegister = document.querySelector('.btn_login-register');
var boxFormLogin = document.querySelector('.box_login-form');
var boxFormRegister = document.querySelector('.box_register-form');
var temp = true;
btnLoginRegister.addEventListener('click', function(e) {
    
    if(temp){
        if (boxFormRegister.classList.contains('hide')) {
        boxFormRegister.classList.remove('hide');
        }
        if (!boxFormLogin.classList.contains('hide')) {
            boxFormLogin.classList.add('hide');
        }
        boxFormRegister.classList.add('show');
        temp = false;
        btnLoginRegister.innerText = 'Login';
    }else{

        if (boxFormLogin.classList.contains('hide')) {
            boxFormLogin.classList.remove('hide');
        }
        if (boxFormRegister.classList.contains('show')) {
            boxFormRegister.classList.remove('show');
            boxFormRegister.classList.add('hide');

        }
        temp = true;
        btnLoginRegister.innerText = 'Sign up';

    }


});


// product
var btnfinss = document.getElementById('find1')
var btnFind1 = document.querySelector('.box_find-tile');
console.log(btnFind1);
btnFind1.addEventListener('click', function(e){
    console.log(btnFind1);
});