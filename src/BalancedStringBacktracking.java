public class BalancedStringBacktracking {

    private static String expandRecursive(
            String s,
            int start,
            int end,
            int[] freq,
            int distinctCount,
            String longest
    ) {

        if (end > s.length()) {
            return longest;
        }

        int charIdx = s.charAt(end - 1) - 'a';

        if (freq[charIdx] == 0) {
            distinctCount++;
        }

        freq[charIdx]++;

        if (distinctCount > 2) {
            freq[charIdx]--;
            return longest;
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

                String current = s.substring(start, end);

                if (current.length() > longest.length()) {
                    longest = current;
                }
            }
        }

        String result = expandRecursive(
                s,
                start,
                end + 1,
                freq,
                distinctCount,
                longest
        );

        freq[charIdx]--;

        return result;
    }

    private static String tryAllStartsRecursive(String s, int start) {

        if (start >= s.length() - 1) {
            return "";
        }

        int[] freq = new int[26];

        String currentBest = expandRecursive(
                s,
                start,
                start + 1,
                freq,
                0,
                ""
        );

        String nextBest = tryAllStartsRecursive(s, start + 1);

        if (currentBest.length() > nextBest.length()) {
            return currentBest;
        }

        return nextBest;
    }

    public static String longestBalancedSubstring(String s) {

        if (s == null || s.length() < 2) {
            return "";
        }

        return tryAllStartsRecursive(s, 0);
    }
}