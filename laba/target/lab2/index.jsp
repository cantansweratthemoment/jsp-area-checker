<%@ page import="lab2.models.CheckList" %>
<%@ page import="lab2.models.Check" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>web_laba2</title>
    <link rel="stylesheet" href="main.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body onload="drawCanvas()">
<script src="canvas.js"></script>
<script src="main.js"></script>
<table class="main-table" align="center">
    <th colspan="2">
        <p title="It's me!" class="main-table">
            Ilinskaya Olga Vadimovna, P3214, v. 2535
        </p>
    </th>
    <tr>
        <td>
            <div id="masloo">
                <canvas id="canvas"></canvas>
            </div>
        </td>
        <td>
            <p class="main-table" id="enter-text">Enter values.</p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <div class="main-table">
                <form id="theform" method="post" action="controllerServlet">
                    <p class="variable">X=
                        <input type="checkbox" value="-3" name="X_f" onclick="changeX(this)">-3
                        <input type="checkbox" value="-2" name="X_f" onclick="changeX(this)">-2
                        <input type="checkbox" value="-1" name="X_f" onclick="changeX(this)">-1
                        <input type="checkbox" value="0" name="X_f" onclick="changeX(this)">0
                        <input type="checkbox" value="1" name="X_f" onclick="changeX(this)">1
                        <input type="checkbox" value="2" name="X_f" onclick="changeX(this)">2
                        <input type="checkbox" value="3" name="X_f" onclick="changeX(this)">3
                        <input type="checkbox" value="4" name="X_f" onclick="changeX(this)">4
                        <input type="checkbox" value="5" name="X_f" onclick="changeX(this)">5
                        <br></p>
                    <p class="variable">Y=<input type="text" placeholder=" " id="y" name="Y_f"><br></p>
                    <p class="variable">R=<select id="select" name="R_f">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select></p>
                    <button id="button" type="submit">✔️</button>
                </form>
            </div>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <table align="center" class="not-main-table">
                <tr>
                    <th class="variable">X</th>
                    <th class="variable">Y</th>
                    <th class="variable">R</th>
                    <th>Result</th>
                    <th>Time</th>
                </tr>
                <tbody>
                <%
                    CheckList checks = (CheckList) request.getServletContext().getAttribute("answerList");
                    if (checks != null) {
                        for (Check check : checks.getChecks()) {
                %>
                <tr>
                    <th class='the_X'><%=check.getX()%>
                    </th>
                    <th class='the_Y'><%=check.getY()%>
                    </th>
                    <th class='the_R'><%=check.getR()%>
                    </th>
                    <th class='the_Result'><%=check.isResult()%>
                    </th>
                    <th><%=check.getClock().getDate()%>
                    </th>
                </tr>
                <%
                        }
                    }
                %></tbody>
            </table>
</table>
</td>
</tr>
</table>
</body>
</html>