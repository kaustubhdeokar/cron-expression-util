package parser;

import validity.IValidity;
import validity.Validity;

import java.util.List;
import java.util.regex.Pattern;

public interface IParser {

    public final String HYPHEN_PARSER_STR = "-";
    public final String STEP_PARSER_STR = "/";
    public final String COMMA_PARSER_STR = ",";
    public final String ASTERISK_PARSER_STR = "*";


    public List<Integer> parseString(String str, Validity validity);

    default boolean checkForOnlyAlphabetInput(String weekDay) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        return pattern.matcher(weekDay).matches();
    }
}
