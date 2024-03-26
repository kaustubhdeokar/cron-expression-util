import java.util.ArrayList;
import java.util.List;

public class CronParser {

    private static final String HYPHEN_STR = "-";
    private static final String STEP_STR = "/";
    public final String SPACE_STR = " ";
    public final String COMMA_STR = ",";

    public final String ASTERISK_STR = "*";

    public final String INVALID_INPUT_MIN_STR = "Invalid input for minute";



    public void parseCronExpression(String input) {

        String[] cronExpression = input.split(SPACE_STR);
        if (cronExpression.length != 5) {
            throw new CronParseException("Invalid input string, length should be according to the guidelines. Please refer readme.md");
        }

        List<Integer> minute = calculateMinutesToExecuteTask(cronExpression[0]);

        System.out.println();
        System.out.print("minute:");
        minute.forEach(s -> System.out.print(s + " "));

        List<Integer> hours = calculateHoursToExecuteTask(cronExpression[0]);

        System.out.println();
        System.out.print("hour:");
        minute.forEach(s -> System.out.print(s + " "));


        System.out.println();
    }

    private List<Integer> calculateHoursToExecuteTask(String hours) {
        return null;
    }

    private List<Integer> calculateMinutesToExecuteTask(String minuteStr) {

        List<Integer> resultMins = new ArrayList<>();
        try {
            if (minuteStr.contains(COMMA_STR)) {
                String[] minutes = minuteStr.split(COMMA_STR);
                for (String minute : minutes) {
                    checkForMinuteValidity(minute);
                    resultMins.add(Integer.parseInt(minute));
                }
            } else if (minuteStr.contains(HYPHEN_STR)) {
                String[] split = minuteStr.split(HYPHEN_STR);

                int startTime = Integer.parseInt(split[0]);
                int endTime = Integer.parseInt(split[1]);
                if (startTime > endTime) {
                    throw new CronParseException(INVALID_INPUT_MIN_STR + " Start time should be greater than or equal to the end time");
                }
                checkForMinuteValidity(startTime);
                checkForMinuteValidity(endTime);

                for (int i = startTime; i <= endTime; i++) {
                    resultMins.add(i);
                }
            } else if (minuteStr.contains(STEP_STR)) {
                String[] range = minuteStr.split(STEP_STR);
                int startFrom = 0;
                if (!range[0].equals(ASTERISK_STR)) {
                    startFrom = Integer.parseInt(range[0]);
                }
                int recurrence = Integer.parseInt(range[1]);
                checkForMinuteValidity(startFrom);
                checkForMinuteValidity(recurrence);

                for (int i = startFrom; i < 60; i += recurrence) {
                    resultMins.add(i);
                }

            } else if (minuteStr.contains(ASTERISK_STR)) {
                if (minuteStr.length() != 1) {
                    throw new CronParseException(INVALID_INPUT_MIN_STR);
                }
                for (int i = 0; i < 60; i++) {
                    resultMins.add(i);
                }
            } else { // a single string input denoting exact minute of an hour - ex "5"
                for (int i = 0; i < minuteStr.length(); i++) {
                    if (!Character.isDigit(minuteStr.charAt(i))) {
                        throw new CronParseException(INVALID_INPUT_MIN_STR);
                    }
                }
                checkForMinuteValidity(minuteStr);
                resultMins.add(Integer.parseInt(minuteStr));
            }
        } catch (Throwable th) {
            throw new CronParseException(th.getMessage());
        }
        return resultMins;
    }

    private void checkForMinuteValidity(String minuteStr) {
        int minute = Integer.parseInt(minuteStr);
        checkForMinuteValidity(minute);
    }

    private void checkForMinuteValidity(Integer minute) {
        if (minute < 0 || minute > 59) {
            throw new CronParseException(INVALID_INPUT_MIN_STR + "Minute should have values [0,59]");
        }
    }

    public static void main(String[] args) {

        CronParser cronParser = new CronParser();
        cronParser.parseCronExpression("21-20 * * * *");
    }


}
