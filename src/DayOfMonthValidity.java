public class DayOfMonthValidity implements IValidity {
    @Override
    public int getStartingValidity() {
        return 1;
    }

    @Override
    public int getEndingValidity() {
        return 31;
    }

    @Override
    public boolean checkForValidity(String value) {
        int dayOfMonth = Integer.parseInt(value);
        return checkForValidity(dayOfMonth);
    }

    @Override
    public boolean checkForValidity(int dayOfMonth) {
        if (dayOfMonth < 0 || dayOfMonth > 31) {
            throw new CronParseException("Incorrect day of the month input. Hour should have values [" + getStartingValidity() + " ," + getEndingValidity() + "]");
        }
        return true;
    }
}
