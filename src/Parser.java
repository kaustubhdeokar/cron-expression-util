import java.util.List;

public class Parser{

    private static final String HYPHEN_PARSER_STR = "-";
    private static final String STEP_PARSER_STR = "/";
    public final String COMMA_PARSER_STR = ",";
    public final String ASTERISK_PARSER_STR = "*";

    public Parser(){}

    public List<Integer> parse(String str, IValidity validity){

        if (str.contains(COMMA_PARSER_STR)) {
            return CommaParser.getInstance().parseString(str, validity);
        }

        else if (str.contains(HYPHEN_PARSER_STR)) {
            return HyphenOrRangeParser.getInstance().parseString(str, validity);
        }

        else if (str.contains(STEP_PARSER_STR)) {
            return StepParser.getInstance().parseString(str, validity);
        }

        else if (str.contains(ASTERISK_PARSER_STR)) {
            return AsteriskParser.getInstance().parseString(str, validity);
        }

        else{
            return ExactValueParser.getInstance().parseString(str,validity);
        }


    }

}
