<html>
<head><title>Login Page</title></head>
<body onload='document.f.j_username.focus();'>
<h3>Login with Username and Password</h3>

<form name='f' action='process-login' method='POST'>
    ${message}<br/>
    <br/>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
</body>
</html>