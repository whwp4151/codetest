package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak16987 {

    private static int N;
    private static Egg[] arr;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recursive(0);

        System.out.println(max);
    }

    private static void recursive(int index) {
        if (index == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i].isBreak()) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        if (!arr[index].isBreak()) {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (i == index) continue;
                if (!arr[i].isBreak()) {
                    flag = true;
                    arr[index].attack(arr[i]);
                    recursive(index + 1);
                    arr[index].restore(arr[i]);
                }
            }
            if (!flag) {
                recursive(index + 1);
            }
        } else {
            recursive(index + 1);
        }
    }

    private static class Egg {
        int weight;
        int durability;

        public Egg(int durability, int weight) {
            this.weight = weight;
            this.durability = durability;
        }

        public void attack(Egg other) {
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        public void restore(Egg other) {
            this.durability += other.weight;
            other.durability += this.weight;
        }

        public boolean isBreak() {
            return this.durability <= 0;
        }
    }

}
