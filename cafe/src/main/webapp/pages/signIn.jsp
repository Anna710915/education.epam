<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
    <form name="LoginForm" method="get" action="controller">
            <input type="hidden" name="command" value="sign_in"/>
            Login:<br/>
            <input type="text" name="login" value=""/>
            <br/>Password:<br/>
            <input type="password" name="password" value=""/>
                <br/>
                        ${errorLoginPassMessage}
                <br/>
                        ${wrongAction}
                <br/>
                        ${nullPage}
            <input type="submit" value="Log in"/>
    </form>

</body><hr/>
</html>
