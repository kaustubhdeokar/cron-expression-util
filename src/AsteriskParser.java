import java.util.ArrayList;
import java.util.List;

public class AsteriskParser implements IParser {

    private AsteriskParser(){}

    public static AsteriskParser getInstance(){
        return new AsteriskParser();
    }

    @Override
    public List<Integer> parseString(String str, IValidity validity) {

        List<Integer> resultMinutes = new ArrayList<>();

        if (str.length() != 1) {
            throw new CronParseException("Asterisk should have only one character - *");
        }
        for (int i = validity.getStartingValidity(); i <= validity.getEndingValidity(); i++) {
            resultMinutes.add(i);
        }

        return resultMinutes;

    }
}
