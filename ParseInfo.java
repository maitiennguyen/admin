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
            else {
                keyWord = "other";
            }
        }
        return keyWord;
    }

    public String ParseIdentity(String userInput) {
        // Clean up the user input by removing punctuation and connecting words
        String cleanedInput = userInput.replaceAll("[^a-zA-Z0-9 ]", "")
                .replaceAll("\\b(and|or)\\b", "")
                .trim();

        // Normalize the capitalization of the cleaned input
        StringBuilder sb = new StringBuilder(cleanedInput.length());
        boolean toUpper = true;
        for (char c : cleanedInput.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                toUpper = false;
            } else {
                sb.append(c);
                toUpper = true;
            }
        }
        String normalizedInput = sb.toString();

        return normalizedInput;
    }
}
