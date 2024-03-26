import java.util.ArrayList;
import java.util.List;

public class CommaParser implements IParser {

    private CommaParser() {
    }

    public static CommaParser getInstance() {
        return new CommaParser();
    }

    @Override
    public List<Integer> parseString(String str, IValidity validity) {
        List<Integer> resultMinutes = new ArrayList<>();
        String[] minutes = str.split(COMMA_PARSER_STR);
        for (String minute : minutes) {
            validity.checkForValidity(minute);
            resultMinutes.add(Integer.parseInt(minute));
        }
        return resultMinutes;
    }
}
