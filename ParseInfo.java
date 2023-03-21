import java.util.Arrays;

public class ParseInfo {
    private String[] ccLocations = {"campus safety"
            , "gear"
            , "armstrong"
            , "dialogue"
            , "art"
            , "barnes"
            , "boettcher"
            , "cossitt"
            , "cutler"
            , "conerstone"
            , "olin"
            , "palmer"
            , "shove"
            , "tutt science"
            , "tutt library"
            , "spencer"
            , "blanca"
            , "fleming"
            , "hybl"
            , "JLK"
            , "lennox"
            , "loomis"
            , "mathias"
            , "south"
            , "mcgregor"
            , "montgomery"
            , "ticknor"
            , "worner"
            , "synergy"
            , "arthur"
            , "bemis"
    };

    public String parsingLocation(String userInput) {
        userInput = userInput.toLowerCase();
        String[] userInputParsed = userInput.split("\\W+");
        String keyWord = null;

        for (String word : userInputParsed) {
            if (Arrays.asList(this.ccLocations).contains(word)) {
                keyWord = word;
                break;
            }
        }
        return keyWord;
    }
}
