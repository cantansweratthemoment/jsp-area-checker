package lab2.servlets;

import lab2.models.Check;
import lab2.models.CheckList;
import lab2.models.Clock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Clock clock = new Clock();
        clock.start();
        double x = Double.parseDouble(req.getParameter("X_f"));
        double y = Double.parseDouble(req.getParameter("Y_f"));
        double r = Double.parseDouble(req.getParameter("R_f"));
        if (!checking(x, y, r)){
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        Check check = new Check(x, y, r);
        check.setResult(checkingTheArea(x, y, r));
        clock.stop();
        check.setClock(clock);
        CheckList answerList = (CheckList) getServletContext().getAttribute("answerList");
        if (answerList == null) {
            getServletContext().setAttribute("answerList", new CheckList());
            answerList = (CheckList) getServletContext().getAttribute("answerList");
        }
        answerList.add(check);
        getServletContext().setAttribute("answerList", answerList);
        PrintWriter writer = resp.getWriter();
        writer.write(answerPage(check));
        writer.close();
    }

    public String answerPage(Check check) {
        String result = check.isResult() ? "Yes!" : "No!";
        String answer = "<html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>answer</title>\n" +
                "  <link rel=\"stylesheet\" href=\"main.css\">\n" +
                "</head>\n" +
                "<table class=\"main-table\" align=\"center\">\n" +
                "  <th colspan=\"2\">\n" +
                "    <p title=\"It's me!\" class=\"main-table\">\n" +
                "      Ilinskaya Olga Vadimovna, P3214, v. 2535\n" +
                "    </p>\n" +
                "  </th>\n" +
                "  <tr>\n" +
                "    <td>\n" +
                "    </td>\n" +
                "    <td>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=\"2\">\n" +
                "      <div class=\"main-table\">\n" +
                "<p class='the_result'>" +
                "<table align=\"center\" class='the_result'>\n" +
                "    <tr>\n" +
                "        <th class=\"variable\">X=" + check.getX() + "</th>\n" +
                "        <th class=\"variable\">Y=" + check.getY() + "</th>\n" +
                "        <th class=\"variable\">R=" + check.getY() + "</th>\n" +
                "        <th>Result " + result + "</th>\n" +
                "    </tr>" + "</p>" + "<form action=\"controllerServlet\">\n" +
                "<button class=\"back_button\" type=\"submit\">Take me back.</button>\n" +
                "</form>\n" +
                "      </div>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        return answer;
    }

    public boolean checkingTheArea(double x, double y, double r) {
        return ((x >= -r) && (x <= 0) && (y >= 0) && (y <= r) && (x * x + y * y <= r * r)) ||
                ((x >= -r / 2) && (x <= 0) && (y >= -r) && (y <= 0)) ||
                ((x >= 0) && (x <= r) && (y >= -r) && (y <= 0) && (y >= x - r));
    }

    public boolean checking(double x, double y, double r) {
        return (x >= -3) && (x <= 5) && (y > -3) && (y < 5) && (r >= -1) && (r <= 5);
    }
}
