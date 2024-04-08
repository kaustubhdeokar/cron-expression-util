package validity;

import parser.CronParseException;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeekValidity extends Validity {

    private static final Map<String, Integer> mapDayOfWeekToInteger = new HashMap<>();

    static {
        instantiateAlphabeticEntry();
    }

    public DayOfWeekValidity() {

    }

    private static void instantiateAlphabeticEntry() {
        mapDayOfWeekToInteger.put("MON", 1);
        mapDayOfWeekToInteger.put("TUE", 2);
        mapDayOfWeekToInteger.put("WED", 3);
        mapDayOfWeekToInteger.put("THU", 4);
        mapDayOfWeekToInteger.put("FRI", 5);
        mapDayOfWeekToInteger.put("SAT", 6);
        mapDayOfWeekToInteger.put("SUN", 7);
    }

    @Override
    public int getStartingValidity() {
        return 1;
    }

    @Override
    public int getEndingValidity() {
        return 7;
    }

    @Override
    public boolean checkForValidity(String value) {
        int dayOfWeek = Integer.parseInt(value);
        return checkForValidity(dayOfWeek);
    }

    @Override
    public boolean checkForValidity(int value) {
        if (value < getStartingValidity() || value > getEndingValidity()) {
            throw new CronParseException("Incorrect day of week input. Day of week should have values [" + getStartingValidity() + " ," + getEndingValidity() + "]");
        }
        return true;
    }

    public int mapEntryToInteger(String dayOfWeek) {
        super.mapEntryToInteger(dayOfWeek);
        if (mapDayOfWeekToInteger.containsKey(dayOfWeek)) {
            return mapDayOfWeekToInteger.get(dayOfWeek);
        } else {
            throw new CronParseException("Incorrect input given.");
        }

    }

    @Override
    public boolean supportsAlphanumericEntry() {
        return true;
    }
}
