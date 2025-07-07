package inf.bak;

public class Bak2774 {

    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        String s = "WrongAnswer";
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int code = (int) c;

            if (code >= 97) {
                System.out.println("소문자" + c);
                answer.append((char) (code - 32));
            } else {
                System.out.println("대문자" + c);
                answer.append((char) (code + 32));
            }
        }
        System.out.println(answer.toString());
    }

}
