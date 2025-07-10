package inf.bak;

import java.util.Scanner;

public class Bak13223 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = sc.nextLine();
        String target = sc.nextLine();

        String[] c = current.split(":");
        int currentHour = Integer.parseInt(c[0]);
        int currentMinute = Integer.parseInt(c[1]);
        int currentSecond = Integer.parseInt(c[2]);

        String[] t = target.split(":");
        int targetHour = Integer.parseInt(t[0]);
        int targetMinute = Integer.parseInt(t[1]);
        int targetSecond = Integer.parseInt(t[2]);

        int currentTime = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int targetTime = targetHour * 3600 + targetMinute * 60 + targetSecond;

        int diffTime = targetTime - currentTime;
        if (diffTime <= 0) {
            diffTime += (24 * 3600);
        }
        int diffHour = diffTime / 3600;
        int diffMinute = diffTime % 3600 / 60;
        int diffSecond = diffTime % 60;

        System.out.printf("%02d:%02d:%02d\n", diffHour, diffMinute, diffSecond);
    }

}
