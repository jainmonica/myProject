import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary implements IDictionary{

    Set<String> dict = new HashSet<String>();

    public Dictionary(List<String> words)
    {
        for(int i = 0; i < words.size(); i++)
        {
            dict.add(words.get(i));
        }
    }

    public boolean isEnglishWord(String word)
    {
        //call third party api here, as applicable
        if(dict.contains(word))
        {
            return true;
        }
        return false;
    }
}
