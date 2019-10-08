import org.junit.runner.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class testWords {

    @Test(description = "Test printing out all the valid words.")
    public void test1() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("work");
        validWords.add("king");
        validWords.add("row");
        validWords.add("know");
        validWords.add("ring");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "working";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("work");
        expectedWords.add("king");
        expectedWords.add("row");
        expectedWords.add("know");
        expectedWords.add("ring");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());
        for (String str : actualWords) {
            System.out.println("Result of Test1: " + str);
            Assert.assertTrue(expectedWords.contains(str));

        }
        System.out.println("done");
    }

    @Test(description = "Test printing out all the valid words with an extraneous.")
    public void test2() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "abcd";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("bc");
        expectedWords.add("d");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        for (String str : actualWords) {
            System.out.println("Result of Test2 " + str);
            Assert.assertTrue(expectedWords.contains(str));

        }
        System.out.println("done");
    }

    @Test(description = "Test the behavior with a single character in an input.")
    public void test3() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "a";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");

        // checking the length
        //    Assert.assertEquals(actualWords.size(), expectedWords.size());

        for (String str : actualWords) {
            System.out.println("Result of Test3 " + str);
            Assert.assertTrue(expectedWords.contains(str));
        }
        System.out.println("done");
    }

    @Test(description = "Test behavior with an empty input.")
    public void test4() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        //Expected List is empty,
        // expectedWords.add("");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());
        System.out.println("done");
    }

    @Test(description = "Test behavior with a null input.")
    public void test5() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = null;
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = null;
        //expectedWords.add(null);

        // checking the length
        Assert.assertEquals(actualWords, expectedWords);

        System.out.println("done");
    }

    @Test(description = "Test behavior with an empty dictionary.")
    public void test6() {
        List<String> validWords = new ArrayList<String>();
        //Dictionary is empty
        //validWords.add("");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "abcd";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        //Expected is Empty
        //expectedWords.add("");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());
        System.out.println("done");
    }

    @Test(description = "Test the behavior when Dictionary doesn't contain any valid word.")
    public void test7() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "12345";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
//        expectedWords.add("");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());
        System.out.println("done");
    }

    @Test(description = "Test the behavior with 2 letter combination.")
    public void test8() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("b");
        validWords.add("ab");
        validWords.add("ba");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "ab";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("b");
        expectedWords.add("ab");
        expectedWords.add("ba");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        for (String str : actualWords) {
            System.out.println("Result of Test8 " + str);
            Assert.assertTrue(expectedWords.contains(str));
        }
        System.out.println("done");
    }

    @Test(description = "Test the behavior with 3 letter combination.")
    public void test9() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("b");
        validWords.add("c");
        validWords.add("ab");
        validWords.add("ac");
        validWords.add("ba");
        validWords.add("bc");
        validWords.add("ca");
        validWords.add("cb");
        validWords.add("abc");
        validWords.add("acb");
        validWords.add("bac");
        validWords.add("bca");
        validWords.add("cab");
        validWords.add("cba");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "abc";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("b");
        expectedWords.add("c");
        expectedWords.add("ab");
        expectedWords.add("ac");
        expectedWords.add("ba");
        expectedWords.add("bc");
        expectedWords.add("ca");
        expectedWords.add("cb");
        expectedWords.add("abc");
        expectedWords.add("acb");
        expectedWords.add("bac");
        expectedWords.add("bca");
        expectedWords.add("cab");
        expectedWords.add("cba");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        for (String str : actualWords) {
            System.out.println("Result of Test9 " + str);
            Assert.assertTrue(expectedWords.contains(str));
        }
        System.out.println("done");
    }

    @Test(description = "Test the behavior to check the duplicate combination.")
    public void test10() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("aa");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "aa";
        Set<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("aa");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        Assert.assertEquals(actualWords.size(), expectedWords.size());
        for (String str : actualWords) {
            System.out.println("Result of Test10: " + str);
            Assert.assertTrue(expectedWords.contains(str));

        }
        System.out.println("done");
    }


}
