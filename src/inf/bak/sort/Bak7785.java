package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> em = new HashSet<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String method = st.nextToken();
            if (method.equals("enter")) {
                em.add(name);
            } else if (method.equals("leave")) {
                em.remove(name);
            }
        }
        br.close();

        List<String> emp = new ArrayList<>(em);
        emp.sort((e1, e2) -> e2.compareTo(e1));

        for (String name : emp) {
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
    }

}
