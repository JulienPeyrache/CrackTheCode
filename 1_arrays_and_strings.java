//Import ArrayList, StringBuilder, and HashTable
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;

public interface 1_arrays_and_strings {
static ArrayList<String> merge(String[] words, String[] more) {
    ArrayList <String> sentence = new ArrayList <String>();
    for (String w : words) sentence.add(w);
    for (String w : more) sentence.add(w);
    return sentence;
};

static String[] joinWords(String[] words) {
    StringBuilder sentence = new StringBuilder();
    for (String w : words){
        sentence.append(w);
    }
    return sentence;
};

// Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
// Path: 1_arrays_and_strings.java

static boolean isUniqueChars(String str) {
    if (str.length() > 128) return false;
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (char_set[val]) return false;
        char_set[val] = true;
    }
    return true;
};

//Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
// Path: 1_arrays_and_strings.java

static boolean permutation(String s, String t) {
    if (s.length() != t.length()) return false;
    return sort(s).equals(sort(t));
};

static boolean isPermutation(String str1, String str2){
    if (str1.length() != str2.length()){
        return false;
    };
    int[] char_set = new int[str1.length()];
    for (int i = 0; i< str1.length(); i++){
        int val = str1.charAt(i);
        if (char_set[val] != 0) char_set[val] += 1;
        else char_set[val] = 1;
    }
    for (int i = 0; i< str2.length(); i++){
        int val = str2.charAt(i);
        if (char_set[val] != 0) char_set[val] -= 1;
        else char_set[val] = -1;
    }

    for (int i = 0; i < str1.length(); i++){
        if (char_set[i] != 0) return false;
    }
    return true;
};
// URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
// Path: 1_arrays_and_strings.java

static String URLify(String s){
    StringBuilder str = new Stringbuilder();
    for (int i = 0; i < s.length(); i++){
        String c = s.charAt(i);
        if (c == ' ') str.append('%20');
        else str.append(C);
    }
    return str.toString();

};

// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
// Path: 1_arrays_and_strings.java

//using a hash table
static boolean isPermutationOfPalindrome(String phrase) {
    int countOdd = 0;
    Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
    for (char c : phrase.toCharArray()) {
        if (c != ' ') {
            c = Character.toLowerCase(c);
            int count = table.containsKey(c) ? table.get(c) : 0;
            table.put(c, count + 1);
            if ((count + 1) % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }
    }
    return countOdd <= 1;
};

}




