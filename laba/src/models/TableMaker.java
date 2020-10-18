package models;

public class TableMaker {
    public static String createTable(CheckList checkList) {
        StringBuilder table = new StringBuilder("<table align=\"center\" class=\"not-main-table\">\n" +
                "    <tr>\n" +
                "        <th class=\"variable\">X</th>\n" +
                "        <th class=\"variable\">Y</th>\n" +
                "        <th class=\"variable\">R</th>\n" +
                "        <th>Result</th>\n" +
                "        <th>Time</th>\n" +
                "        <th>Script time</th>\n" +
                "    </tr>");
        for (Check check : checkList.getChecks()) {
            table.append("<tbody><tr>");
            table.append("<th>").append(check.getX()).append("</th>");
            table.append("<th>").append(check.getY()).append("</th>");
            table.append("<th>").append(check.getR()).append("</th>");
            table.append("<th>").append(check.isResult()).append("</th>");
            table.append("</tr></tbody>");
        }
        table.append("</table>");
        return table.toString();
    }
}
