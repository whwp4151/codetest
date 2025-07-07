package inf;

import java.util.*;

public class Yearning {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};

        System.out.println(solution(name, yearning, photo));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> scoreList = new ArrayList<>();
        Map<String, Integer> nameMap = new HashMap<>();

        for (int i=0; i<name.length; i++) {
            nameMap.put(name[i], yearning[i]);
        }

        for (String[] strings : photo) {
            int score = 0;
            Arrays.stream(strings).forEach(s -> System.out.print(s + " "));
            System.out.println();
            for (String string : strings) {
                if (nameMap.containsKey(string)) {
                    score += nameMap.get(string);
                }
            }
            scoreList.add(score);
        }

        int[] answer = new int[scoreList.size()];
        for (int i=0; i<scoreList.size(); i++) {
            answer[i] = scoreList.get(i);
        }

        return answer;
    }

}
