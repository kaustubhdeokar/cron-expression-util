public class MonthValidity implements IValidity{
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
            throw new CronParseException("Incorrect month input. Month should have values [" + getStartingValidity() +" ,"+ getEndingValidity()+"]");
        }
        return true;
    }
}
