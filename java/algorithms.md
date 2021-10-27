## Algorithms in Java

1. Left Rotate An Array by n places

```java
class Scratch {
    private static void leftRotate(int[] inputArray, int n) {
        int temp;

        for (int i = 0; i < n; i++) {
            temp = inputArray[0];

            System.arraycopy(inputArray, 1, inputArray, 0, inputArray.length - 1);

            inputArray[inputArray.length - 1] = temp;
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void main(String[] args) {
        leftRotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }
}
```

2. Right Rotate an Array by n places

```java
public class Scratch {
    private static void rightRotate(int[] inputArray, int n) {
        int temp;

        for (int i = 1; i <= n; i++) {
            temp = inputArray[inputArray.length - 1];

            System.arraycopy(inputArray, 0, inputArray, 1, inputArray.length - 1);

            inputArray[0] = temp;
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void main(String[] args) {
        rightRotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }
}
```

3. Reverse a String

```java
public class Scratch {
    public static String reverse(String in) {
        if (in == null)
            throw new IllegalArgumentException("Null is not valid input");
        StringBuilder out = new StringBuilder();
        char[] chars = in.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--)
            out.append(chars[i]);
        return out.toString();
    }
}
```

4. Swap two numbers without using a third variable

```java
public class Scratch {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        b = b + a; // now b is sum of both the numbers
        a = b - a; // b - a = (b + a) - a = b (a is swapped)
        b = b - a; // (b + a) - b = a (b is swapped)
        System.out.println("a="+a+", b="+b);
    }
}
```

5. Check if a vowel is present in the string

```java
public class Scratch {
    public static boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
```

6. Check if the given number is Prime?

```java
public class Scratch {
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

7. Palindrome Check

```java
public class Scratch {
    boolean checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
```

8. Factorial of an integer

```java
public class Scratch {
    public static long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
```

9. Binary Search

```java
public class Scratch {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        if (low > high) {
            return -1;
        }
        return -1;
    }
}
```

10. Find second-largest number in an array

```java
public class Scratch {
    private static int findSecondHighest(int[] array) {
        int highest = Integer.MIN_VALUE; // -2 raise to 31
        int secondHighest = Integer.MIN_VALUE; // 2 raise to 31 - 1

        for (int i : array) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;
            }

        }
        return secondHighest;
    }
}
```

11. Sort HashMap by values

```java
public class Scratch {
    private static Map<String, Integer> sortByValue(Map<String, Integer> scores) {
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();

        // get the entry set 
        Set<Entry<String, Integer>> entrySet = scores.entrySet();
        System.out.println(entrySet);

        // create a list since the set is unordered 
        List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
        System.out.println(entryList);

        // sort the list by value 
        entryList.sort((x, y) -> x.getValue().compareTo(y.getValue()));
        System.out.println(entryList);

        // populate the new hash map 
        for (Entry<String, Integer> e : entryList)
            sortedByValue.put(e.getKey(), e.getValue());
        return sortedByValue;
    }
}
```

12. Get distinct characters and their count in a String?

```java
public class Scratch {
    public static void main(String[] args) {

        String str1 = "abcdABCDabcd";

        char[] chars = str1.toCharArray();
        Map<Character, Integer> charsCount = new HashMap<>();

        for (char c : chars) {
            if (charsCount.containsKey(c)) {
                charsCount.put(c, charsCount.get(c) + 1);
            } else
                charsCount.put(c, 1);
        }

        System.out.println(charsCount); // {a=2, A=1, b=2, B=1, c=2, C=1, d=2, D=1}
    }
}
```

13. Prove String is immutable programmatically?

```java
public class Scratch {
    public static void main(String[] args) {

        String s1 = "Java"; // "Java" String created in pool and reference assigned to s1

        String s2 = s1; //s2 is also having the same reference to "Java" in the pool

        System.out.println(s1 == s2); // proof that s1 and s2 have same reference

        s1 = "Python";
        //s1 value got changed above, so how String is immutable?

        //well, in the above case a new String "Python" got created in the pool
        //s1 is now referring to the new String in the pool 
        //BUT, the original String "Java" is still unchanged and remains in the pool
        //s2 is still referring to the original String "Java" in the pool

        // proof that s1 and s2 have different reference
        System.out.println(s1 == s2);

        System.out.println(s2);
        // prints "Java" supporting the fact that original String value is unchanged, hence String is immutable
    }
}
```
