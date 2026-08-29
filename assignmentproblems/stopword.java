package assignmentproblems;
public class stopword {
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Stop words array to skip[cite: 6]
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Clean punctuation and normalize text to lower case[cite: 6]
        String cleaned = feedback.toLowerCase()
                                .replace(".", "")
                                .replace(",", "")
                                .replace("!", "")
                                .replace("?", "");

        // Split by whitespace pattern[cite: 6]
        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            // Skip stop words[cite: 6]
            if (stopWords.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1); // Count occurrences[cite: 6]
        }

        // Convert entry set to list to sort by count in descending order[cite: 6]
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print word frequency report[cite: 6]
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
        /* 
           Output:
           great: 2
           mentor: 1
           session: 1
           clear: 1
        */
    }
}
