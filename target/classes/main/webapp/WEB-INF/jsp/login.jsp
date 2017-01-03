<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/6
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <!-- 导入jquery 库 -->
  <script type="text/javascript" src="../../js/jquery-2.1.4.js"/>

  <script type="text/javascript">
    function login() {
      //简单验证数据有效性
      var userName = $("#loginform input[name='username']").val()
      var password = $("#loginform input[name='password']").val()
      if (userName == "" || password == "") {
        alert("输入账号或者名字");
        return;
      }

      $.ajax({
        url: 'http://localhost:8080/login',
        type: 'GET',
        data: $("#loginform").serialize(),
        async: true,
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
      })
      function LoadFunction() {

      }

      function erryFunction() {
        alert("error");
      }

      function succFunction(data) {
        //跳转页面
        alert("good");
      }
    }

    function resetLogin() {
    }

    $(function () {
      $("#login_btn").click(login);
      $("#reset_login").click(resetLogin);
    });
  </script>
</head>
<body>

<div id="logindiv">
  <form action="" method="" id="loginform">
    Name:<input type="text" name="username" placeholder="please enter username"><br/><br/>
    PassWord:<input type="password" name="password" placeholder="please enter password">
  </form>
  <br/><br/>
  <button id="login_btn">LoginBtn</button>
  <button id="reset_login">Reset</button>
</div>
</body>
</body>
</html>
