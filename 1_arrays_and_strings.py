## 1:  Implement an algorithm to determine f a string as all unique characters. What if you cannot use additional data structures?

# Solution 1: Using a dictionary (complexity is O(n))
def is_unique(string):
    char_dict = {}
    for char in string:
        if char in char_dict:
            return False
        else:
            char_dict[char] = 1
    return True

# Solution 2: Using a set (complexity is O(n))
def is_unique(string):
    char_set = set()
    for char in string:
        if char in char_set:
            return False
        else:
            char_set.add(char)
    return True

# Solution 3: without using any data structures (complexity is O(n^2)), could be improved if I sorted the string first (O(nlogn))
def is_unique(string):
    for i in range(len(string)):
        for j in range(i+1, len(string)):
            if string[i] == string[j]:
                return False
    return True

##2:  Given two strings, write a method to decide if one is a permutation of the other.

# Solution 1: Using a dictionary (complexity is O(n))
def is_permutation(string1, string2):
    char_dict = {}
    for char in string1:
        if char in char_dict:
            char_dict[char] += 1
        else:
            char_dict[char] = 1
    for char in string2:
        if char in char_dict:
            char_dict[char] -= 1
        else:
            return False
    for key in char_dict:
        if char_dict[key] != 0:
            return False
    return True

##3 URLify:  Write a method to replace all spaces in a string with '%20'. You may
# assume that the string has sufficient space at the end to hold the additional

# Solution 1: Using a list (complexity is O(n))
def urlify(string):
    new_string = []
    for char in string:
        if char == ' ':
            new_string.append('%20')
        else:
            new_string.append(char)
    return ''.join(new_string)

# Solution 2: Using a string (complexity is O(n))
def urlify(string):
    new_string = ''
    for char in string:
        if char == ' ':
            new_string += '%20'
        else:
            new_string += char
    return new_string

##4 Palindrome Permutation:  Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

# Solution 1: Using a dictionary (complexity is O(n))
def palindrome_permutation(string):
    char_dict = {}
    for char in string:
        if char in char_dict:
            char_dict[char] += 1
        else:
            char_dict[char] = 1
    odd_count = 0
    for key in char_dict:
        if char_dict[key] % 2 != 0:
            odd_count += 1
    if odd_count > 1:
        return False
    return True

##5 One Away:  There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

# Solution 1: Using a dictionary (complexity is O(n))
def one_away(string1, string2):
    char_dict = {}
    for char in string1:
        if char in char_dict:
            char_dict[char] += 1
        else:
            char_dict[char] = 1
    for char in string2:
        if char in char_dict:
            char_dict[char] -= 1
        else:
            char_dict[char] = -1
    count = 0
    for key in char_dict:
        if char_dict[key] != 0:
            count += 1
    if count > 2:
        return False
    return True

##6 String Compression:  Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).

# Solution 1: Using a string (complexity is O(n))
def string_compression(string):
    new_string = ''
    count = 1
    for i in range(len(string)):
        if i == len(string) - 1:
            new_string += string[i] + str(count)
        elif string[i] == string[i+1]:
            count += 1
        else:
            new_string += string[i] + str(count)
            count = 1
    if len(new_string) < len(string):
        return new_string
    return string

##7 Rotate Matrix:  Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

# Solution 1: Using a list (complexity is O(n^2))
def rotate_matrix(matrix):
    new_matrix = []
    for i in range(len(matrix)):
        new_matrix.append([])
        for j in range(len(matrix)):
            new_matrix[i].append(matrix[len(matrix)-1-j][i])
    return new_matrix

##8 Zero Matrix:  Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

# Solution 1: Using a list (complexity is O(n^2))
def zero_matrix(matrix):
    zero_rows = []
    zero_cols = []
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] == 0:
                zero_rows.append(i)
                zero_cols.append(j)
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if i in zero_rows or j in zero_cols:
                matrix[i][j] = 0
    return matrix

##9 String Rotation:  Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat").

# Solution 1: Using a string (complexity is O(n))
def string_rotation(string1, string2):
    if len(string1) != len(string2):
        return False
    new_string = string1 + string1
    if string2 in new_string:
        return True
    return False

