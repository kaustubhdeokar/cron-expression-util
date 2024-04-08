package validity;

import parser.CronParseException;

public class HoursValidity extends Validity{
    @Override
    public int getStartingValidity() {
        return 0;
    }

    @Override
    public int getEndingValidity() {
        return 23;
    }

    @Override
    public boolean checkForValidity(String hourStr) {
        int hour = Integer.parseInt(hourStr);
        return checkForValidity(hour);
    }

    @Override
    public boolean checkForValidity(int hour) {
        if (hour < 0 || hour > 23) {
            throw new CronParseException("Incorrect hour input. Hour should have values [" + getStartingValidity() +" ,"+ getEndingValidity()+"]");
        }
        return true;
    }

}
