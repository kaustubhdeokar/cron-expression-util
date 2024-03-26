import java.util.ArrayList;
import java.util.List;

public class ExactValueParser implements IParser {

    private ExactValueParser() {
    }

    public static ExactValueParser getInstance() {
        return new ExactValueParser();
    }

    @Override
    public List<Integer> parseString(String str, IValidity validity) {

        List<Integer> result = new ArrayList<>();

        // a single string input denoting exact minute of an hour - ex "5"
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new CronParseException("If a single value is specified, should be an integer");
            }
        }
        validity.checkForValidity(str);
        result.add(Integer.parseInt(str));
        return result;
    }

}
