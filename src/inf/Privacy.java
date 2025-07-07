package inf;

import java.util.*;

public class Privacy {

    public static void main(String[] args) {

    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            System.out.println(isDestroyed(today, p[0]));
        }

        int[] answer = {};
        return answer;
    }

    private boolean isDestroyed(String today, String storeDate) {
        String t = today.replaceAll( "\\.", "" );
        String[] s = storeDate.split("\\.");

//        Arrays.stream(t).forEach(System.out::println);
        // for (int i=0; i<3; i++) {
        //     if (Integer.parseInt(t[i]) > Integer.parseInt(s[i])) {
        //         return true;
        //     }
        // }
        return false;
    }

}
