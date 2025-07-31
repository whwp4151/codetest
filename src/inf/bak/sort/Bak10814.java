package inf.bak.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak10814 {

    static class Human {
        int age;
        String name;
        int index;
        public Human(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Human[] humans = new Human[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            humans[i] = new Human(age, name, i);
        }
        br.close();

        Arrays.sort(humans, (o1, o2) -> {
            if (o1.age > o2.age) {
                return 1;
            } else if (o1.age < o2.age) {
                return -1;
            } else {
                if (o1.index > o2.index) {
                    return 1;
                } else if (o1.index < o2.index) {
                    return -1;
                }
                return 0;
            }
        });

        for (Human h : humans) {
            bw.write(h.age + " " + h.name + "\n");
        }

        bw.flush();
    }

}
