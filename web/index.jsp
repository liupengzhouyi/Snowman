<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/6
  Time: 上午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table width="1300" border="0" align="center">
    <tr>
      <td colspan="2" style="background-color:#7479ff;">
        <h1 align="center">刘鹏学习网（测试版本）</h1>
      </td>
    </tr>

    <tr>
      <td style="background-color:#ff9499;width:100px;height:650" align="center">
        <b><p>菜单</p></b><br>
        <a href="/Clock/index.jsp"><p>打卡</p></a><br>
        日记<br>
        博客<br>
        记账<br>
        数据总结
      </td>

      <td style="background-color:#eeebbc;height:650px;width:400px;">
        内容在这里
        <table border="1" >
          <tr>
            <th>起床时间</th>
            <td>
              <select>
                <%
                  for(int i=1;i<24;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              时&nbsp;
              <select lang="10">
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              分&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              秒
            </td>
          </tr>
          <tr>
            <th>
              午睡时间
            </th>
            <td>
              <select>
                <%
                  for(int i=1;i<24;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              时&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              分&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              秒
            </td>
          </tr>
          <tr>
            <th>
              午睡起床时间
            </th>
            <td>
              <select>
                <%
                  for(int i=1;i<24;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              时&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              分&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              秒
            </td>
          </tr>
          <tr>
            <th>
              晚上上床时间
            </th>
            <td>
              <select>
                <%
                  for(int i=1;i<24;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              时&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              分&nbsp;
              <select>
                <%
                  for(int i=1;i<60;i++) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              秒
            </td>
          </tr>
          <tr>
            <th>
              今天，你记单词了吗？
            </th>
            <td>
              <select>
                <%
                  for(int i=0;i<60;i=i+5) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              个
            </td>
          </tr>
          <tr>
            <th>
              今天，你上传博客了吗？
            </th>
            <td>

            </td>
          </tr>
          <tr>
            <th>
              今天，你消费了吗？
            </th>
            <td>

            </td>
          </tr>
          <tr>
            <th>
              今天，你阅读外文了吗？
            </th>
            <td>
              <select>
                <%
                  for(int i=0;i<2000;i = i+ 100) {
                %>
                <option><%=i%></option>
                <%
                  }
                %>
              </select>
              词
            </td>
          </tr>
        </table>
      </td>
    </tr>

    <tr>
      <td colspan="2" style="background-color:#ff72af;text-align:center;">
        版权 © liupengstudy.cn
      </td>
    </tr>
  </table>

<%--  <form>
    <table border="1" >
      <tr>
        <th>起床时间</th>
        <td>
          <select>
            <%
              for(int i=1;i<24;i++) {
            %>
                <option><%=i%></option>
            <%
              }
            %>
          </select>
          时&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          分&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          秒
        </td>
      </tr>
      <tr>
        <th>
          午睡时间
        </th>
        <td>
          <select>
            <%
              for(int i=1;i<24;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          时&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          分&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          秒
        </td>
      </tr>
      <tr>
        <th>
          午睡起床时间
        </th>
        <td>
          <select>
            <%
              for(int i=1;i<24;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          时&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          分&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          秒
        </td>
      </tr>
      <tr>
        <th>
          晚上上床时间
        </th>
        <td>
          <select>
            <%
              for(int i=1;i<24;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          时&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          分&nbsp;
          <select>
            <%
              for(int i=1;i<60;i++) {
            %>
            <option><%=i%></option>
            <%
              }
            %>
          </select>
          秒
        </td>
      </tr>
      <tr>
        <th>
          今天，你记单词了吗？
        </th>
        <td>

        </td>
      </tr>
      <tr>
        <th>
          今天，你上传博客了吗？
        </th>
        <td>

        </td>
      </tr>
      <tr>
        <th>
          今天，你消费了吗？
        </th>
        <td>

        </td>
      </tr>
      <tr>
        <th>
          今天，你约炮了吗？
        </th>
        <td>

        </td>
      </tr>
    </table>
  </form>--%>
  </body>
</html>
