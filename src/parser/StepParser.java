package parser;

import validity.Validity;

import java.util.ArrayList;
import java.util.List;

public class StepParser implements IParser {

    private StepParser() {
    }

    public static StepParser getInstance() {
        return new StepParser();
    }

    @Override
    public List<Integer> parseString(String str, Validity validity) {

        List<Integer> resultMinutes = new ArrayList<>();

        String[] range = str.split(IParser.STEP_PARSER_STR);
        // step parser can have input as */5, in such cases, starting point is 0.
        int startFrom = validity.getStartingValidity();
        if (!range[0].equals(IParser.ASTERISK_PARSER_STR)) {
            startFrom = Integer.parseInt(range[0]);
        }
        int recurrence = Integer.parseInt(range[1]);

        validity.checkForValidity(startFrom);
        validity.checkForValidity(recurrence);

        for (int i = startFrom; i < validity.getEndingValidity(); i += recurrence) {
            resultMinutes.add(i);
        }
        return resultMinutes;
    }
}
