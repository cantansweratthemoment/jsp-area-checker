package lab2.models;

public class TableMaker {
    public static String createTable(Object checkList) {
        if(checkList==null){
            return "";
        }
        CheckList checking=(CheckList) checkList;
        StringBuilder table = new StringBuilder("<table align=\"center\" class=\"not-main-table\">\n" +
                "    <tr>\n" +
                "        <th class=\"variable\">X</th>\n" +
                "        <th class=\"variable\">Y</th>\n" +
                "        <th class=\"variable\">R</th>\n" +
                "        <th>Result</th>\n" +
                "        <th>Time</th>\n" +
                "    </tr>");
        for (Check check : checking.getChecks()) {
            table.append("<tbody><tr>");
            table.append("<th class='the_X'>").append(check.getX()).append("</th>");
            table.append("<th class='the_Y'>").append(check.getY()).append("</th>");
            table.append("<th class='the_R'>").append(check.getR()).append("</th>");
            table.append("<th class='the_Result'>").append(check.isResult()).append("</th>");
            table.append("<th>").append(check.getClock().getDate()).append("</th>");
            table.append("</tr></tbody>");
        }
        table.append("</table>");
        return table.toString();
    }
}