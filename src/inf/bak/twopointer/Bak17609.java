package inf.bak.twopointer;

import java.io.*;

public class Bak17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] arr = br.readLine().toCharArray();

            int l = 0;
            int r = arr.length - 1;
            int answer = 0;
            while (l < r) {
                if (arr[l] != arr[r]) {
                    if (isPalindrome(arr, l + 1, r) || isPalindrome(arr, l, r - 1)) {
                        answer = 1;
                    } else {
                        answer = 2;
                    }
                    break;
                }

                l++;
                r--;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
    }

    private static boolean isPalindrome(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
