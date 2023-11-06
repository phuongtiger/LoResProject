<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>LoResProject - Register</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <section>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>
            <span></span> <span></span> <span></span> <span></span> <span></span>

            <div class="signin">
                <div class="content">
                    <h2>Register</h2>
                    <div class="form">
                        <form action="CreateAccount" method="POST">
                            <div class="inputBox">
                                <input type="text" name="firstname" required>
                                <i>First Name</i>
                            </div>
                            <div class="inputBox">
                                <input type="text" name="lastname" required>
                                <i>Last Name</i>
                            </div>
                            <div class="inputBox">
                                <input type="text" name="username" required>
                                <i>User Name</i>
                            </div>

                            <div class="inputBox" >
                                <input type="password" name="password" id="password" required>
                                <i>Password</i>
                            </div>

                            <div class="inputBox" >
                                <input type="password" name="confirm_password" id="confirm_password" required>
                                <i>Confirm Password</i>
                            </div>
                            <div id="password_error" style="color: red;"></div>
                            <div class="links">
                                <a href="./login.jsp">Already have an account? <strong>Login</strong></a>
                            </div>

                            <div class="inputBox">
                                <input type="submit" value="Register" id="myInput">
                            </div>
                            <div id="message"></div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <script>
            var errorMessage = "<%= request.getAttribute("errorMessage") %>";
            if (errorMessage == "null") {
                errorMessage = "";
            }
            document.getElementById("message").innerHTML = errorMessage;
            var passwordField = document.getElementById("password");
            var confirmPasswordField = document.getElementById("confirm_password");
            var passwordError = document.getElementById("password_error");
            var myInput = document.getElementById("myInput");
            // G?n s? ki?n ki?m tra khi ng??i dùng gõ
            confirmPasswordField.addEventListener('keyup', function () {
                var password = passwordField.value;
                var confirmPassword = confirmPasswordField.value;

                if (password == confirmPassword) {
                    passwordError.innerHTML = "";
                    myInput.disabled = false;
                } else {
                    passwordError.innerHTML = "Your password and confirm password is not match!";
                    myInput.disabled = true;
                }
            });
        </script>
    </body>
</html>
