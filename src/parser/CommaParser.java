package parser;

import validity.IValidity;
import validity.Validity;

import java.util.ArrayList;
import java.util.List;

public class CommaParser implements IParser {

    private CommaParser() {
    }

    public static CommaParser getInstance() {
        return new CommaParser();
    }

    @Override
    public List<Integer> parseString(String str, Validity validity) {
        List<Integer> resultMinutes = new ArrayList<>();
        String[] minutes = str.split(IParser.COMMA_PARSER_STR);
        for (String minute : minutes) {
            validity.checkForValidity(minute);
            resultMinutes.add(Integer.parseInt(minute));
        }
        return resultMinutes;
    }
}
