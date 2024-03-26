## Cron parser

### Input format 
#### "minute" "hour" "day of month" "month" "day of week"

#### Minute Input format (0-59) - should adhere to following standard
- specific minute
- multiple minutes - comma separated
- step / (for every..)
- asterisk * (every minute)
- range of minutes - hypen

Test cases for minute
- specific minute 
- - valid 5 
- - invalid 61 122 - specific minute
- multiple minutes separated by comma
- - valid 1,2,3,5
- - invalid 1,22,111
- Step function
- - */15
- - 60/1 (starting range incorrect)
- - 1/60 (step increment incorrect)
- Asterisk \*
- Range
- 11-22 (range) & 22-11 (invalid range)

- -  invalid inputs - (like mixing of . and *)

#### hour input 

- same 4-5 types of input.. 
- common checks - just validity is different.
- validity interface , parser class for each type of input. 

```
public interface IValidity {

    public int getStartingValidity();

    public int getEndingValidity();
}

public class MinuteValidity implements IValidity {

    public int getStartingValidity(){
        return 0;
    }

    public int getEndingValidity(){
        return 59;
    }

}

public interface IParser {

    public List<Integer> parseString(String str, IValidity validity);
}

public class StepParser implements IParser {

    @Override
    public List<Integer> parseString(String str, IValidity validity) {
        //logic
    }
}


```

### Similarly implemented hours validity

### Checked Test cases for hour 

- specific hour
- - valid 5
- - invalid 61 122 - specific minute
- multiple minutes separated by comma
- - valid 1,2,3,5
- - invalid 1,22,111
- Step function
- - */15
- - 60/1 (starting range incorrect)
- - 1/60 (step increment incorrect)
- Asterisk \*
- Range
- 11-22 (range) & 22-11 (invalid range)

- -  invalid inputs - (like mixing of . and *)


### Day of month
### Checked Test cases for day of month

- specific hour
- - valid 5
- - invalid 32 - specific minute
- multiple minutes separated by comma
- - valid 1,2,3,5
- - invalid 1,22,111
- Step function
- - */15
- - 32/1 (starting range incorrect)
- - 1/33 (step increment incorrect)
- Asterisk \*
- Range
- 11-22 (range) & 22-11 (invalid range)

- -  invalid inputs - (like mixing of . and *)


### month (1-12)
### Checked Test cases for day of month

- specific hour
- - valid 5
- - invalid 61 122 - specific minute
- multiple minutes separated by comma
- - valid 1,2,3,5
- - invalid 1,22,111
- Step function
- - */15
- - 13/1 (starting range incorrect)
- - 1/60 (step increment incorrect)
- Asterisk \*
- Range
- 11-22 (range) & 22-11 (invalid range)

- -  invalid inputs - (like mixing of . and *)



Each of the parser - basis on type of input have a different



Extra:
time zones - can we use library ?

Resources:
resources used: https://elmah.io/tools/cron-parser/