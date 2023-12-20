package inf.bak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mineral {

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.println("answer="+solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        List<MineralP> list = new ArrayList<>();

        int totalPicks = Arrays.stream(picks).sum();

        for (int i=0; i<minerals.length; i+=5) {
            if(totalPicks == 0) break;

            int dia = 0, iron = 0, stone = 0;
            for (int j=i; j<i+5; j++) {
                if(j == minerals.length) break;

                int val = 0;
                if (minerals[j].equals("diamond")) val = 0;
                else if (minerals[j].equals("iron")) val = 1;
                else if (minerals[j].equals("stone")) val = 2;

                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }

            list.add(new MineralP(dia, iron, stone));
            totalPicks--;
        }

        System.out.println("======= start =======");
        for (MineralP m : list) {
            System.out.println("dp="+m.diamond+", ip="+m.iron+", sp="+m.stone);
        }
        System.out.println("======= end =======");
        list.sort(((o1, o2) -> (o2.stone - o1.stone)));
        System.out.println("======= start =======");
        for (MineralP m : list) {
            System.out.println("dp="+m.diamond+", ip="+m.iron+", sp="+m.stone);
        }
        System.out.println("======= end =======");

        for(MineralP m : list) {
            System.out.println("dp="+m.diamond+", ip="+m.iron+", sp="+m.stone);
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            System.out.println("picks "+picks[0] + ", " + picks[1] + ", " + picks[2]);
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                System.out.println("dia answer="+answer + " picks[0]="+picks[0]);
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                System.out.println("iron answer="+answer + " picks[1]="+picks[1]);
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                System.out.println("stone answer="+answer + " picks[2]="+picks[2]);
                continue;
            }
        }

        return answer;
    }

}
class MineralP {
    int diamond;
    int iron;
    int stone;

    public MineralP(int diamond, int iron, int stone) {
        this.diamond = diamond;
        this.iron = iron;
        this.stone = stone;
    }
}
