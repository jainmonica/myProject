import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class testWords {

    @Test
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
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("work");
        expectedWords.add("king");
        expectedWords.add("row");
        expectedWords.add("know");
        expectedWords.add("ring");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    public void test2() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "abcd";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("bc");
        expectedWords.add("d");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    public void test3() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "a";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");

        // checking the length
    //    Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    public void test4() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
       //Expected List is empty,
        // expectedWords.add("");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    public void test5() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = null;
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = null;
        //expectedWords.add(null);

        // checking the length
        Assert.assertEquals(actualWords, expectedWords);

        System.out.println("done");
    }

    @Test
    public void test6() {
        List<String> validWords = new ArrayList<String>();
       //Dictionary is empty
        //validWords.add("");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "abcd";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        //Expected is Empty
        //expectedWords.add("");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    //Dictionary doesn't contain any valid word
    public void test7() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("bc");
        validWords.add("d");
        validWords.add("bcxyz");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "12345";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
//        expectedWords.add("");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    // 2 letters combination
    public void test8() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("b");
        validWords.add("ab");
        validWords.add("ba");


        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "ab";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("b");
        expectedWords.add("ab");
        expectedWords.add("ba");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }

    @Test
    // 2 letters combination
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
        List<String> actualWords = apw.Generate(input);

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

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }

        System.out.println("done");
    }
    @Test
    public void test10() {
        List<String> validWords = new ArrayList<String>();
        validWords.add("a");
        validWords.add("aa");

        Dictionary dictionary = new Dictionary(validWords);

        AllPossibleWords apw = new AllPossibleWords(dictionary);

        String input = "aa";
        List<String> actualWords = apw.Generate(input);

        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("a");
        expectedWords.add("a");
        expectedWords.add("aa");
        expectedWords.add("aa");

        // checking the length
        Assert.assertEquals(actualWords.size(), expectedWords.size());

        //To ignore ordering, enumerate and check each expected output
        for (int i = 0; i < actualWords.size(); i++) {
            System.out.println("Result: " + actualWords.get(i));
            Assert.assertTrue(actualWords.contains(expectedWords.get(i)));
        }
        System.out.println("done");
    }


}
