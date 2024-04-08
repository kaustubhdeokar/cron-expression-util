package validity;

import parser.CronParseException;

import java.util.List;

public abstract class Validity implements IValidity {

    public void addRoundWrapCase(int startTime, int endTime, List<Integer> holder) {

        for (int i = startTime; i <= getEndingValidity(); i++) {
            holder.add(i);
        }

        for (int i = getStartingValidity(); i <= endTime; i++) {
            holder.add(i);
        }

    }

    public boolean checkForRoundWrapCase(int startRange, int endRange) {
        return startRange > endRange;
    }

    @Override
    public boolean supportsAlphanumericEntry() {
        return false;
    }

    @Override
    public int mapEntryToInteger(String entry) {
        if (!supportsAlphanumericEntry()) {
            throw new CronParseException("Invalid call. Only to be executed for clauses allowing alphabet entry.");
        }
        return 0;
    }
}
