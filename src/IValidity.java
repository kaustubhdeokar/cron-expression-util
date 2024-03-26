public interface IValidity {

    public int getStartingValidity();

    public int getEndingValidity();

    public boolean checkForValidity(String value);

    public boolean checkForValidity(int value);

    public default boolean checkForRangeValidity(int startRange, int endRange) {
        if (startRange >= endRange) {
            throw new CronParseException("Start value of range should be LESSER than the end range value.");
        }
        return true;
    }

}
