import java.util.List;

public interface IParser {

    public final String HYPHEN_PARSER_STR = "-";
    public final String STEP_PARSER_STR = "/";
    public final String COMMA_PARSER_STR = ",";
    public final String ASTERISK_PARSER_STR = "*";


    public List<Integer> parseString(String str, IValidity validity);
}
