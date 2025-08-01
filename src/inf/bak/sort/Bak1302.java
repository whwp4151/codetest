package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            String book = br.readLine();
            map.merge(book, 1, Integer::sum);
        }
        br.close();

        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        List<String> books = new ArrayList<>();
        for (String book : map.keySet()) {
            if (max == map.get(book)) {
                books.add(book);
            }
        }

        if (books.size() == 1) {
            bw.write(books.get(0));
            bw.flush();
            return;
        }

        books.sort((b1, b2) -> b1.compareTo(b2));

        bw.write(books.get(0));
        bw.flush();
    }

}
