<%--
  Created by IntelliJ IDEA.
  User: sanjoy
  Date: 1/15/16
  Time: 6:51 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Dashboard</title>
</head>
<body>

<div class="table-responsive">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Account</th>
            <th>Total Balance</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${entries}">
            <tr>
                <td>${it[0]}</td>
                <td>${it[1]}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

</body>
</html>