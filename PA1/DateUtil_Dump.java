import DateUtil.DateUtil;
public class DateUtil_Dump {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]),
            month = Integer.parseInt(args[1]),
            day = Integer.parseInt(args[2]);
        if (!DateUtil.isValidDate(year, month, day))
            System.out.println("{\"Valid\": false}");
        else
            System.out.println("{" + String.join(",", new String[]{
                "\"Valid\": true",
                "\"DayOfWeek\": " + Integer.toString(DateUtil.getDayOfWeek(year, month, day)),
                "\"Formatted\": \"" + DateUtil.formatDate(year, month, day) + "\""
            }) + "}");
    }
}
