package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak1759 {

    private static int L;
    private static int C;
    private static char[] password;
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        password = new char[L];
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        recursive(0, 0, 0);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static void recursive(int length, int index, int vowelCount) {
        if (L == length) {
            if (vowelCount >= 1 && L - vowelCount >= 2) {
                System.out.println(password);
            }
            return;
        }

        if (index < C) {
            password[length] = arr[index];
            int n = isVowel(arr[index]) ? 1 : 0;
            recursive(length + 1, index + 1, n + vowelCount);
            password[length] = 0;
            recursive(length, index + 1, vowelCount);
        }
    }

}
