<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/13
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<>

<style type="text/css">
  #input_radios {
    font: 14px arial;
    white-space: nowrap;
    padding-left: 35px
  }
</style>
<!-- #input_radios a, #input_radios strong {
display: inline-block;
vertical-align: text-bottom;
height: 66px;
text-align: center;
line-height: 34px;
text-decoration: none;
overflow: hidden;
margin-right: 9px;
background: #fff
}

#input_radios a {
cursor: pointer
}

#input_radios a:hover {
background: 0 0
}

#input_radios .n:hover, #input_radios a:hover .pc {
background: #f2f8ff;
border: 1px solid #38f
}

#input_radios .n {
height: 34px;
padding: 0 18px;
border: 1px solid #e1e2e3
}

#input_radios span {
display: block
}

#input_radios .pc {
width: 34px;
height: 34px;
border: 1px solid #e1e2e3;
cursor: pointer
}

#input_radios .fk {
width: 24px;
height: 24px;
margin-bottom: 6px;
margin-left: 6px;
cursor: pointer
}

#input_radios strong .fk, #input_radios strong .pc {
cursor: auto
}

#input_radios .fk .c-icon-bear-pn {
top: -3px;
position: relative
}

#input_radios .fkd .c-icon-bear-pn {
top: 3px;
position: relative
}

#input_radios .fk_cur .c-icon-bear-p {
top: -2px;
position: relative
}

#input_radios strong .pc {
border: 0;
width: 36px;
height: 36px;
line-height: 36px
}

#input_radios .nums {
display: inline-block;
vertical-align: text-bottom;
height: 36px;
line-height: 36px;
margin-left: 10px
}
-->
<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="../../js/utils.js"></script>

<head>
  <title>ForumList</title>
  <script type="text/javascript">
    function onBottomClick() {
      $.ajax({
        url: 'http://localhost:8080/forum',
        type: 'POST',
        data: {index: $(this).attr("value")},
        async: true,
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
      });

      function LoadFunction(data) {

      }

      function erryFunction(XMLHttpRequest, textStatus, errorThrown) {
        alert("status:" + XMLHttpRequest.status);
        alert("state:" + XMLHttpRequest.readyState);
        alert("error textStatus:" + textStatus);
      }

      function succFunction(data, textStatus) {
        if (data != null) {
          //解析json
          $(".content_tbody [class^=tr_]").remove();
          var decodeData = $.parseJSON(data);
          var result = decodeData.result;
          var resultData = decodeData.resultData;
          if (result != 0) {
            return;
          }
          for (var i = 1; i <= resultData.length; i++) {
            var tr_node = $("<tr class=tr_" + i + "></tr>").appendTo($(".content_tbody"));

            $("<td class=td_name_" + i + ">" + resultData[i - 1].userId + "</td>").appendTo(tr_node);

            $("<td class=td_desc_" + i + ">" + resultData[i - 1].descWord + "</td>").appendTo(tr_node);

            $("<td class=td_time_" + i + ">" + FormatDate(resultData[i - 1].publishTime) + "</td>").appendTo(tr_node);
          }
        }
      }
    }

    $(function () {
      for (var i = 1; i <= $("input[name='bottom_radio']").length; i++) {
        $("#bottom_radio_" + i).click(onBottomClick);
      }
    });
  </script>
</head>


<body>
<h1>BolgList</h1>

<div class="content">
  <table class="table_conent" width="100%" border="3" cellpadding="0" cellspacing="0">
    <colgroup>
      <col width="100px"/>
      <col/>
      <col width="100px"/>
    </colgroup>
    <tbody class="content_tbody">
    <tr class="tr">
      <th class="th">用户名</th>
      <th class="th">标题</th>
      <th class="th">时间</th>
    </tr>

    <%
      String msgInfoUrl = "http://localhost:8080/oneforummsg/?userId=";
      String msgList = (String) request.getAttribute("msgList");
      JSONObject msgListJson = (JSONObject) JSONObject.parse(msgList);
      Object resultData = msgListJson.get("resultData");

      System.out.println(resultData.toString());
    %>

    <c:forEach var="msg" varStatus="status" items="<%=resultData%>">
      <tr class="tr_${status.count}">
        <td class="td_name_${status.count}">${msg.userId}
        </td>
        <td class="td_desc_${status.count}">
          <a href="http://localhost:8080/oneforummsg/?userId=${msg.userId}" target="_blank">
              ${msg.descWord}</a>
        </td>
        <td class="td_time_${status.count}">${msg.publishTime}</td>
      </tr>
    </c:forEach>
    </tbody>
    <br/>
  </table>
</div>

<input id="intput_test_button" type="button" value="Hello">

<br/><br/>
<!-- 底部切换 -->
<div id="div_container">
  <div id="div_image" class="imageshow">
    <div id="input_radios">
      <input name="bottom_radio" id="bottom_radio_1" type="radio" value="1" width="30">
      <span class="fk">
          <i class="c-icon c-icon-bear-pn"></i>
        </span>
      <span class="pc">1</span>
      </input>
      <input name="bottom_radio" id="bottom_radio_2" type="radio" value="2" width="30">
      <span class="fk fkd">
          <i class="c-icon c-icon-bear-pn"></i>
        </span>
      <span class="pc">2</span>
      </input>
      <input name="bottom_radio" id="bottom_radio_3" type="radio" value="3" width="30">
      <span class="fk">
          <i class="c-icon c-icon-bear-pn"/>
        </span>
      <span class="pc">3</span>
      </input>
    </div>
  </div>
</div>
</body>
</html>
