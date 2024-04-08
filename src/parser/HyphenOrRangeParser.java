package parser;

import validity.Validity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HyphenOrRangeParser implements IParser {

    private HyphenOrRangeParser() {
    }


    public static HyphenOrRangeParser getInstance() {
        return new HyphenOrRangeParser();
    }

    public List<Integer> parseString(String str, Validity validity) {


        List<Integer> resultMinutes = new ArrayList<>();

        String[] startAndEndValue = str.split(IParser.HYPHEN_PARSER_STR);

        int startTime;
        int endTime;


        if (validity.supportsAlphanumericEntry() &&
                checkForOnlyAlphabetInput(startAndEndValue[0]) && checkForOnlyAlphabetInput(startAndEndValue[1])) {
            String startVal = startAndEndValue[0];
            String endVal = startAndEndValue[1];
            startTime = validity.mapEntryToInteger(startVal);
            endTime = validity.mapEntryToInteger(endVal);
        }

        else {
            startTime = Integer.parseInt(startAndEndValue[0]);
            endTime = Integer.parseInt(startAndEndValue[1]);
        }


        validity.checkForValidity(startTime);
        validity.checkForValidity(endTime);

        if (validity.checkForRoundWrapCase(startTime, endTime)) {
            validity.addRoundWrapCase(startTime, endTime, resultMinutes);
        } else {
            for (int i = startTime; i <= endTime; i++) {
                resultMinutes.add(i);
            }
        }

        return resultMinutes;
    }



}
