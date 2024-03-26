import java.util.ArrayList;
import java.util.List;

public class HyphenOrRangeParser implements IParser {

    private HyphenOrRangeParser(){};

    public static HyphenOrRangeParser getInstance(){
        return new HyphenOrRangeParser();
    }

    public List<Integer> parseString(String str, IValidity validity) {


        List<Integer> resultMinutes = new ArrayList<>();

        String[] split = str.split(HYPHEN_PARSER_STR);

        int startTime = Integer.parseInt(split[0]);
        int endTime = Integer.parseInt(split[1]);

        validity.checkForValidity(startTime);
        validity.checkForValidity(endTime);
        validity.checkForRangeValidity(startTime, endTime);

        for (int i = startTime; i <= endTime; i++) {
            resultMinutes.add(i);
        }

        return resultMinutes;
    }

}
