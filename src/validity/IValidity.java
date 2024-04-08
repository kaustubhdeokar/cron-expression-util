package validity;

import java.util.List;

public interface IValidity {

    public int getStartingValidity();

    public int getEndingValidity();

    public boolean checkForValidity(String value);

    public boolean checkForValidity(int value);

    public boolean supportsAlphanumericEntry();

    public int mapEntryToInteger(String entry);
}
