<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/28
  Time: 下午8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus?">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>人人网注册账号</title>
</head>
<body>

<img src="renren_titile.gif">
<p>人人网，中国 <strong>最真实、最有效</strong>的社会平台，加入人人网，找回老朋友，结交新朋友。</p>
<form>
    电子邮箱:
    <input type="text" name="电子邮箱" maxlength="50"/><br />
    <br />
</form>
<form>
    创建密码: a
    <input type="text" name="创建密码" maxlength="16"/><br />
    <br />
</form>
<form>
    真实姓名:
    <input type="text" name="真实姓名" maxlength="8"/><br />
    <br />
</form>
<form>
    性别：
    <input type="radio" name="sex" value="male" />男
    <input type="radio" name="sex" value="female" /> 女
</form><br />
<form>
    生日：
    <select name="year">
        <option value="1990">1990</option>
        <option value="1991">1991</option>
        <option value="1992">1992</option>
        <option value="1993">1993</option>
    </select>
    <th>年</th>
    <select name="month">
        <option value="12">12</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="1">1</option>
    </select>
    <th>月</th>
    <select name="day">
        <option value="30">30</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="1">1</option>
    </select>
    <th>日</th><br />
</form><br />
<form>
    我现在：
    <select name="doing">
        <option value="teacher">老师</option>
        <option value="job">医生</option>
    </select>
</form><br />
<td>
    <img src="renren_code.gif">
</td>看不清换一张？
<form>
    验证码:
    <input type="text" name="验证码" maxlength="5"/>
    <br />
</form><br />
<td>

    <a href="#"><img src="image/renren.gif"></a>
</td>
</body>
</html>