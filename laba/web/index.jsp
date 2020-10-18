<%@ page import="models.CheckList" %>
<%@ page import="models.TableMaker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>web_laba2</title>
  <link rel="stylesheet" href="main.css">
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
      <%String%>
      <canvas id="canvas" onclick="canvasWasClicked(this)"></canvas>
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
         <!-- <label for="y">Y=</label> -->
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
        <% if ((getServletConfig().getServletContext().getAttribute("answerList"))!=null){
          TableMaker.createTable((CheckList) getServletConfig().getServletContext().getAttribute("answerList"));}%>
      </table
    </td>
  </tr>
</table>
</body>
</html>