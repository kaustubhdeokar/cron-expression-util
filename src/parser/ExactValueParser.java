package parser;

import validity.IValidity;
import validity.Validity;

import java.util.ArrayList;
import java.util.List;

public class ExactValueParser implements IParser {

    private ExactValueParser() {
    }

    public static ExactValueParser getInstance() {
        return new ExactValueParser();
    }

    @Override
    public List<Integer> parseString(String str, Validity validity) {

        List<Integer> result = new ArrayList<>();

        int limit;
        if (validity.supportsAlphanumericEntry() && checkForOnlyAlphabetInput(str)) {
            limit = validity.mapEntryToInteger(str);
        } else {
            limit = Integer.parseInt(str);
        }

        // a single string input denoting exact minute of an hour - ex "5"
        for (int i = validity.getStartingValidity(); i < limit; i++) {
            result.add(i);
        }
        validity.checkForValidity(str);
        result.add(Integer.parseInt(str));
        return result;
    }

}
