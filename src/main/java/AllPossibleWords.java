import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPossibleWords {

    private IDictionary dictionary;

    public AllPossibleWords(IDictionary dict)
    {
        dictionary = dict;
    }

    public List<String> Generate(String str) {
        if(str == null)
        {
            return null;
        }

        List result = new ArrayList<String>();
        List<Character> candidates = new ArrayList<Character>();
        for (char ch : str.toCharArray()) {
            candidates.add(ch);
        }

        // generate words for each possible lengths
        for(int len = 1; len <= candidates.size(); len++)
        {
            char[] buffer = new char[len];
            Generate(candidates, 0, buffer, result);
        }

//        char[] buffer = new char[candidates.size()];
//        Generate(candidates, 0, buffer, result);

        return result;
    }

    private void Generate(List<Character> candidates, int writeIndex, char[] buffer, List<String> result)
    {
        //base condition
        if(writeIndex == buffer.length)
        {
            String word = new String(buffer,0, buffer.length);
            if(dictionary.isEnglishWord(word)) {
                result.add(word);
            }
            return;
        }

        // include prefix, if it is a valid word
//        if(writeIndex != 0)
//        {
//            String interimWord = new String(buffer, 0, writeIndex);
//            if(dictionary.isEnglishWord(interimWord)) {
//                result.add(interimWord);
//            }
//        }

        //backtracking
        for(int i = 0; i < candidates.size(); i++)
        {
            buffer[writeIndex]=candidates.get(i);
            candidates.remove(i); // ignore used character
            Generate(candidates, writeIndex +1, buffer, result);
            candidates.add(i, buffer[writeIndex]);
        }
    }
}
