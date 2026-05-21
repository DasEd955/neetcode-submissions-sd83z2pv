class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord == endWord) {return 0;}
        
        int m = wordList.get(0).length();
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> qb = new ArrayDeque<>(), qe = new ArrayDeque<>();
        Map<String, Integer> fromBegin = new HashMap<>(), fromEnd = new HashMap<>(); 
        qb.offer(beginWord);
        qe.offer(endWord);
        fromBegin.put(beginWord, 1);
        fromEnd.put(endWord, 1);

        while(!qb.isEmpty() && !qe.isEmpty()) {
            if(qb.size() > qe.size()) {
                Deque<String> tempQ = qb;
                qb = qe;
                qe = tempQ;
                Map<String, Integer> tempM = fromBegin;
                fromBegin = fromEnd;
                fromEnd = tempM;;
            }

            for(int i = 0; i < qb.size(); i++) {
                String word = qb.pollFirst();
                int steps = fromBegin.get(word);
                for(int j = 0; j < m; j++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == word.charAt(j)) {continue;}
                        String neighbor = word.substring(0, j) + c + word.substring(j + 1);
                        if(!wordSet.contains(neighbor)) {continue;}
                        if(fromEnd.containsKey(neighbor)) {
                            return steps + fromEnd.get(neighbor);
                        }
                        if(!fromBegin.containsKey(neighbor)) {
                            fromBegin.put(neighbor, steps + 1);
                            qb.offer(neighbor);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
