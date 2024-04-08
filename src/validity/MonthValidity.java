package validity;

import parser.CronParseException;

import java.util.HashMap;
import java.util.Map;

public class MonthValidity extends Validity {

    private static final Map<String, Integer> monthValidity = new HashMap<>();

    static {
        monthValidity.put("JAN", 1);
        monthValidity.put("FEB", 2);
        monthValidity.put("MAR", 3);
        monthValidity.put("APR", 4);
        monthValidity.put("MAY", 5);
        monthValidity.put("JUN", 6);
        monthValidity.put("JUL", 7);
        monthValidity.put("AUG", 8);
        monthValidity.put("SEP", 9);
        monthValidity.put("OCT", 10);
        monthValidity.put("NOV", 11);
        monthValidity.put("DEC", 12);
    }

    @Override
    public int getStartingValidity() {
        return 1;
    }

    @Override
    public int getEndingValidity() {
        return 12;
    }

    @Override
    public boolean checkForValidity(String value) {
        int dayOfMonth = Integer.parseInt(value);
        return checkForValidity(dayOfMonth);
    }

    @Override
    public boolean checkForValidity(int value) {
        if (value < getStartingValidity() || value > getEndingValidity()) {
            throw new CronParseException("Incorrect month input. Month should have values [" + getStartingValidity() + " ," + getEndingValidity() + "]");
        }
        return true;
    }

    @Override
    public boolean supportsAlphanumericEntry() {
        return true;
    }

    public int mapEntryToInteger(String dayOfWeek) {
        super.mapEntryToInteger(dayOfWeek);
        if (monthValidity.containsKey(dayOfWeek)) {
            return monthValidity.get(dayOfWeek);
        } else {
            throw new CronParseException("Incorrect input given.");
        }

    }
}
