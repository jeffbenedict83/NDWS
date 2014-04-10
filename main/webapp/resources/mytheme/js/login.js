// Login Form

$(function() {
    var loginBox = $('#loginBox');
    var signupBox = $('#signupBox');

    $('#loginButton').click(function(event){
        event.stopPropagation();
        loginBox.toggle();
        signupBox.toggle(false);
    });

    $('#signupButton').click(function(event){
        event.stopPropagation();
        loginBox.toggle(false);
        signupBox.toggle();
    });

    loginBox.click(function(event){
        event.stopPropagation();
    });

    signupBox.click(function(event){
        event.stopPropagation();
    });

    $(document).click(function() {
        loginBox.toggle(false);
        signupBox.toggle(false);
    });
});