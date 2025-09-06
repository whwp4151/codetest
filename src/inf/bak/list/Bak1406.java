package inf.bak.list;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Bak1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArray = br.readLine().toCharArray();
        List<String> list = new LinkedList<>();
        for (char c : charArray) {
            list.add(String.valueOf(c));
        }

        int M = Integer.parseInt(br.readLine());

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        while (M-- > 0) {
            String[] split = br.readLine().split(" ");
            String command = split[0];
            if (split.length > 1) {
                iterator.add(split[1]);
            } else {
                if (command.equals("L")) {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if (command.equals("D")) {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                } else if (command.equals("B")) {
                    if (iterator.hasPrevious()) {
                        iterator.remove();
                    }
                }
            }
        }

        for (String s : list) {
            bw.write(s);
        }
        bw.newLine();
        bw.flush();
    }

}
