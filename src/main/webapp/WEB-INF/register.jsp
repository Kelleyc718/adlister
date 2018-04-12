<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input id="firstName" name="firstName" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input id="lastName" name="lastName" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="phone">Phone number</label>
                <input id="phone" name="phone" class="form-control" type="tel">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="user_pic">User Photo</label><br>
                <input id="user_pic" name="user_pic" type="file" >
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
