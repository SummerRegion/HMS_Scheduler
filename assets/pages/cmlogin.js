
function loginValidation() {
    
    var jsonData = {
        userId: $("#txtUserID").val(),
        userPassword:  $("#txtPassword").val()
    };

    var $this = $(this);
    if ($this.data("execute_login")) return;
        $this.data("execute_login", true);
    $.ajax({
        url:"/hms-scheduler/webapi/users/login",
        type:"POST",
        async:false,
        cache:false,
        contentType:"application/json",
        data:  JSON.stringify(jsonData),
        processData: false

    }).done(function(response) {
        $this.removeData("execute_login");
        if("token" in response) {
            window.sessionStorage.setItem("authToken",response.token);
            window.location.replace("/hms-scheduler/index.jsp");

        }
    }).fail(function(){
        $this.removeData("execute_login");
    });
};
    
jQuery().ready(function () {
    $("#btnLogin").on("click", function(){
        loginValidation();
    });    
    
    $("#txtUserID").keypress(function(e) {
        if(e.which === 13) {
            loginValidation();
        }
    });
    
    $("#txtPassword").keypress(function(e) {
        if(e.which === 13) {
            loginValidation();
        }
    });
});

