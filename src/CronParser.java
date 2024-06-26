import parser.CronParseException;
import parser.Parser;
import validity.*;

import java.util.List;

public class CronParser {

    public final String SPACE_STR = " ";
    public final String INVALID_INPUT_MIN_STR = "Invalid input.";


    public void parseCronExpression(String input) {


        String[] cronExpression = input.split(SPACE_STR);

        //*/16 0 1,15 * FRI-MON
        String minuteString = cronExpression[0];
        String hourString = cronExpression[1];
        String dayOfTheMonthStr = cronExpression[2];
        String monthStr = cronExpression[3];
        String dayOfWeekStr = cronExpression[4];
        int commandIdx = input.indexOf(dayOfWeekStr) + dayOfWeekStr.length();

        List<Integer> minute = calculateMinutesToExecuteTask(minuteString);
        List<Integer> hours = calculateHoursToExecuteTask(hourString);
        List<Integer> dayOfTheMonth = calculateDayOfTheMonthToExecuteTask(dayOfTheMonthStr);
        List<Integer> month = calculateMonthToExecuteTask(monthStr);
        List<Integer> dayOfWeek = calculateDayOfWeekToExecuteTask(dayOfWeekStr);

        System.out.println();
        System.out.print("minute:");
        minute.forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.print("hour:");
        hours.forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.print("day of month:");
        dayOfTheMonth.forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.print("month:");
        month.forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.print("day of week:");
        dayOfWeek.forEach(s -> System.out.print(s + " "));

        System.out.println();
        System.out.println("Command: " + input.substring(commandIdx).trim());
    }

    private List<Integer> calculateDayOfWeekToExecuteTask(String dayOfWeekStr) {
        Parser parser = new Parser();
        DayOfWeekValidity dayOfWeekValidity = new DayOfWeekValidity();

        try {
            return parser.parse(dayOfWeekStr, dayOfWeekValidity);
        } catch (Throwable th) {
            throw new CronParseException(INVALID_INPUT_MIN_STR + th.getMessage());
        }
    }

    private List<Integer> calculateMonthToExecuteTask(String monthStr) {
        Parser parser = new Parser();
        MonthValidity monthValidity = new MonthValidity();

        try {
            return parser.parse(monthStr, monthValidity);
        } catch (Throwable th) {
            throw new CronParseException(INVALID_INPUT_MIN_STR + th.getMessage());
        }
    }

    private List<Integer> calculateDayOfTheMonthToExecuteTask(String hours) {
        Parser parser = new Parser();
        DayOfMonthValidity dayOfMonthValidity = new DayOfMonthValidity();

        try {
            return parser.parse(hours, dayOfMonthValidity);
        } catch (Throwable th) {
            throw new CronParseException(INVALID_INPUT_MIN_STR + th.getMessage());
        }
    }

    private List<Integer> calculateHoursToExecuteTask(String hours) {
        Parser parser = new Parser();
        HoursValidity hoursValidity = new HoursValidity();

        try {
            return parser.parse(hours, hoursValidity);
        } catch (Throwable th) {
            throw new CronParseException(INVALID_INPUT_MIN_STR + th.getMessage());
        }
    }

    private List<Integer> calculateMinutesToExecuteTask(String minuteStr) {

        Parser parser = new Parser();
        MinuteValidity minuteValidity = new MinuteValidity();

        try {
            return parser.parse(minuteStr, minuteValidity);
        } catch (Throwable th) {
            throw new CronParseException(INVALID_INPUT_MIN_STR + th.getMessage());
        }
    }

    public static void main(String[] args) {

//        String arg = args[0];
        CronParser cronParser = new CronParser();
        //"minute" "hour" "day of month" "month" "day of week"
        //"*/15 0 1,15 * 1-5"
        cronParser.parseCronExpression("*/16 5 1,15 JAN-MAR TUE-FRI /usr/bin/find -v foo");

    }


}
