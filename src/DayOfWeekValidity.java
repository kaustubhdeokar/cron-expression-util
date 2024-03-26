public class DayOfWeekValidity implements IValidity {
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
            throw new CronParseException("Incorrect day of week input. Day of week should have values [" + getStartingValidity() +" ,"+ getEndingValidity()+"]");
        }
        return true;
    }
}
