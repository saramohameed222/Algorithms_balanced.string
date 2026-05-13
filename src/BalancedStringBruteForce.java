public class BalancedStringBruteForce {

    public static String longestBalancedSubstring(String s) {

        if (s == null || s.length() < 2) {
            return "";
        }

        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int distinctCount = 0;

            for (int j = i; j < n; j++) {

                int charIdx = s.charAt(j) - 'a';

                if (freq[charIdx] == 0) {
                    distinctCount++;
                }

                freq[charIdx]++;

                if (distinctCount > 2) {
                    break;
                }

                if (distinctCount == 2) {

                    int count1 = -1;
                    int count2 = -1;

                    for (int k = 0; k < 26; k++) {

                        if (freq[k] > 0) {

                            if (count1 == -1) {
                                count1 = freq[k];
                            } else {
                                count2 = freq[k];
                                break;
                            }
                        }
                    }

                    if (count1 == count2) {

                        String current = s.substring(i, j + 1);

                        if (current.length() > longest.length()) {
                            longest = current;
                        }
                    }
                }
            }
        }

        return longest;
    }
}