//Import ArrayList, StringBuilder, and HashTable
import java.util.ArrayList;
import java.util.Hashtable;

public interface arrays_and_strings {
static ArrayList<String> merge(String[] words, String[] more) {
    ArrayList <String> sentence = new ArrayList <String>();
    for (String w : words) sentence.add(w);
    for (String w : more) sentence.add(w);
    return sentence;
};

static String joinWords(String[] words) {
    StringBuilder sentence = new StringBuilder();
    for (String w : words){
        sentence.append(w);
    }
    return sentence.toString();
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
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (c == ' ') str.append("%20");
        else str.append(c);
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

// One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
// Path: 1_arrays_and_strings.java
static boolean oneEditReplace(String s1, String s2) {
    boolean foundDifference = false;
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            if (foundDifference) {
                return false;
            }
            foundDifference = true;
        }
    }
    return true;
};

static boolean oneEditInsert(String str1,String str2){
    boolean foundDifference = false;
    for (int i = 0; i< str1.length(); i++){
        if (foundDifference){
            if (str1.charAt(i) != str2.charAt(i+1)){
                return false;
            }}
        else {
            if (str1.charAt(i) != str2.charAt(i)){
                foundDifference = true;
            };
        }
    }
    return true;
}

static boolean oneEditAway(String first, String second) {
    if (first.length() == second.length()) {
        return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
        return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
        return oneEditInsert(second, first);
    }
    return false;
};

//String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
// Path: 1_arrays_and_strings.java

static String compress(String str){
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++){
        countConsecutive++;
        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
};

// Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
// Path: 1_arrays_and_strings.java

static boolean rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
    int n = matrix.length;
    for (int layer = 0; layer < n / 2; ++layer) {
        int first = layer;
        int last = n - 1 - layer;
        for(int i = first; i < last; ++i) {
            int offset = i - first;
            int top = matrix[first][i]; // save top
            // left -> top
            matrix[first][i] = matrix[last-offset][first];
            // bottom -> left
            matrix[last-offset][first] = matrix[last][last - offset];
            // right -> bottom
            matrix[last][last - offset] = matrix[i][last];
            // top -> right
            matrix[i][last] = top; // right <- saved top
        }
    }
    return true;
};

// Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
// Path: 1_arrays_and_strings.java

static void setZeros(int[][] matrix) {
    boolean[] row = new boolean[matrix.length];
    boolean[] column = new boolean[matrix[0].length];
    // Store the row and column index with value 0
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                row[i] = true;
                column[j] = true;
            }
        }
    };
    for (int i = 0; i < row.length; i++) {
        for (int j = 0; j < column.length; j++) {
            if (row[i] || column[j]) {
                matrix[i][j] = 0;
            }
        }
    
    }
};

// String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
// Path: 1_arrays_and_strings.java

static boolean isRotation(String s1, String s2) {
    int len = s1.length();
    /* check that s1 and s2 are equal length and not empty */
    if (len == s2.length() && len > 0) {
        /* concatenate s1 and s1 within new buffer */
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }
    return false;
}

static boolean isSubstring(String s1, String s2) {
    return false;
};
}
