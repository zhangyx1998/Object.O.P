/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 * ----------------------------------------
 * Task: Number to English
 * ----------------------------------------
 * Get a commandline argument input ranging
 * from -999999999 to 999999999, and print
 * the equivalent English expression.
 */

public class Num2Eng {
    public static class Level {
        long val;
        String unit;
        boolean self_explain = true;

        public Level(long _val, String _unit) {
            val = _val;
            unit = _unit;
            self_explain = true;
        }

        public Level(long _val, String _unit, boolean _self_explain) {
            val = _val;
            unit = _unit;
            self_explain = _self_explain;
        }
    }

    static Level[] levels = { new Level(0, "zero"), new Level(1, "one"), new Level(2, "two"), new Level(3, "three"),
            new Level(4, "four"), new Level(5, "five"), new Level(6, "six"), new Level(7, "seven"),
            new Level(8, "eight"), new Level(9, "nine"), new Level(10, "ten"), new Level(11, "eleven"),
            new Level(12, "twelve"), new Level(13, "thirteen"), new Level(14, "fourteen"), new Level(15, "fifteen"),
            new Level(16, "sixteen"), new Level(17, "seventeen"), new Level(18, "eighteen"), new Level(19, "nineteen"),
            new Level(20, "twenty"), new Level(30, "thirty"), new Level(40, "forty"), new Level(50, "fifty"),
            new Level(60, "sixty"), new Level(70, "seventy"), new Level(80, "eighty"), new Level(90, "ninety"),
            new Level(100, "hundred", false), new Level(1000, "thousand", false),
            new Level(1000000, "million", false) };

    public static void main(String[] args) {
        long val = Long.parseLong(args[0]);
        if (val == 0) {
            print("zero");
        } else {
            if (val < 0) {
                // render "negative" if necessary
                print("negative");
                val = Math.abs(val);
            }
            parse(val, false);
        }
        System.out.println();
    }

    public static void parse(long val, boolean self_explain) {
        int lv = levels.length - 1;
        // Find the nearest suitable level
        while (levels[lv].val > val) {
            lv--;
        }
        if (val > levels[lv].val) {
            parse(val / levels[lv].val, levels[lv].self_explain);
            print(levels[lv].unit);
            if (val % levels[lv].val > 0) {
                parse(val % levels[lv].val, self_explain);
            }
        } else if (val != 1 || !self_explain) {
            print(levels[lv].unit);
        }
    }

    // This is the print proxy that checks if a space
    // should be inserted before each call.
    static boolean first_print = true;

    public static void print(String str) {
        if (!first_print) {
            System.out.print(' ');
        } else {
            first_print = false;
        }
        System.out.print(str);
    }
}
