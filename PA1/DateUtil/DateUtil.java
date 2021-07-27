package DateUtil;

/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */
// import java.util.Calendar;

public class DateUtil {

    /**
     * Returns true if the given year is a leap year. A year is a leap year if it is
     * divisible by 4 but not by 100, or it is divisible by 400.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * returns true if the given year, month and day constitute a given date. Assume
     * that year is between 1 and 9999, month is between 1 (Jan) to 12 (Dec) and day
     * shall be between 1 and 28|29|30|31 depending on the month and whether it is a
     * leap year.
     */
    public static boolean isValidDate(int year, int month, int day) {
        return (year >= 1 && year <= 9999) && (month >= 1 && month <= 12)
                && (day >= 1 && day <= numberOfDaysInMonth(year, month));
    }

    /**
     * Returns number of days in a given month. Leap year is considered.
     * 
     * @param year
     * @param month
     * @return
     */
    public static int numberOfDaysInMonth(int year, int month) {
        int tmp[] = { 31, 28 + (isLeapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return tmp[month - 1];
    }

    /**
     * Returns number of days since the century.
     * 
     * @param year
     * @param month
     * @return
     */
    public static int numberOfDaysSinceCentury(int year, int month, int day) {
        int total = 0;
        for (int i = 1; i < year; i++)
            total += 365 + (isLeapYear(i) ? 1 : 0);
        for (int i = 1; i < month; i++)
            total += numberOfDaysInMonth(year, i);
        return total + day;
    }

    /**
     * Returns the day of the week, where 0 for SUN, 1 for MON, ..., 6 for SAT, for
     * the given date. Assume that the date is valid.
     */
    public static int getDayOfWeek(int year, int month, int day) {
        return numberOfDaysSinceCentury(year, month, day) % 7;
    }

    /**
     * The calendar for the specified year/month is output on the screen according
     * to the calendar output format.
     */
    public static void printCalendar(int year, int month) {
        String cal = "MON  TUE  WED  THU  FRI  SAT  SUN\n";
        int day = 1, i = 1 - ((getDayOfWeek(year, month, 1) + 6) % 7);
        for (; i <= numberOfDaysInMonth(year, month); i ++){
            if (i <= 0) cal += toFixedLength("", 3);
            else cal += toFixedLength(Integer.toString(i), 3);
            cal += "  ";
            if (day++ == 7 || i == numberOfDaysInMonth(year, month)){
                day = 1;
                cal += "\n";
            }
        }
        System.out.print(cal);
    }

    /**
     * The Calendar for the specified year is output on the screen according to the
     * calendar output format.
     */
    public static void printCalendar(int year) {
        for (int i = 1; i <= 12; i++){
            System.out.println("\n" + Months[i - 1] + "\n---------------------------------");
            printCalendar(year, i);
        }
    }

    /**
     * prints the given date in the format "xxx day d mmm yyyy", e.g., "Tuesday 14
     * Feb 2012". Assume that the given date is valid
     */
    public static String formatDate(int year, int month, int day) {
        return 
            Days[getDayOfWeek(year, month, day)] + " "
            + day + " "
            + Months[month - 1] + " "
            + toFixedLength(Integer.toString(year), 4, '0');
    }

    private static final String Days[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday" };

    private static final String Months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
            "Nov", "Dec" };

    /**
     * Inserts given characters into the start of string to satisfy the given length
     */
    private static String toFixedLength(String str, int length, char buf) {
        if (str.length() >= length)
            return str;
        return toFixedLength(buf + str, length, buf);
    }

    private static String toFixedLength(String str, int length) {
        return toFixedLength(str, length, ' ');
    }
}
