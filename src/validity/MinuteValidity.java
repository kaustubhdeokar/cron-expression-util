package validity;

import parser.CronParseException;

public class MinuteValidity extends Validity {

    public int getStartingValidity() {
        return 0;
    }

    public int getEndingValidity() {
        return 59;
    }

    public boolean checkForValidity(String minuteStr) {
        int minute = Integer.parseInt(minuteStr);
        return checkForValidity(minute);
    }

    public boolean checkForValidity(int minute) {
        if (minute < 0 || minute > 59) {
            throw new CronParseException("Minute should have values [" + getStartingValidity() +" ,"+ getEndingValidity()+"]");
        }
        return true;
    }
}
