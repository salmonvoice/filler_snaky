import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HanoyTower {


    public static final int N = 5;
    public static int countOfMoves = 0;

    public static void main(String[] args) {
        List<Deque<Integer>> towers = new ArrayList<>();
        Deque<Integer> fullStack = new ArrayDeque<>();
        for (int i = N; i > 0; i--) {
            fullStack.add(i);
        }

        towers.add(fullStack); //source
        towers.add(new ArrayDeque<>());
        towers.add(new ArrayDeque<>()); // target

//        move(towers, N, 0, 2);
        moveCycle(towers, N, 0, 2);

        printTowers(towers);


        System.out.println("countOfMoves = " + countOfMoves);

    }

    private static void printTowers(List<Deque<Integer>> towers) {
        for (int i = 0; i < towers.size(); i++) {
            System.out.print("Tower " + i + ": ");
            for (Integer v : towers.get(i)) {
                System.out.print(v + ", ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    public static int getAuxIdx(int i1, int i2) {
        switch (i1) {
            case 0:
                return i2 == 1 ? 2 : 1;
            case 1:
                return i2 == 2 ? 0 : 2;
            case 2:
            default:
                return i2 == 1 ? 0 : 1;
        }
    }

    private static void move(List<Deque<Integer>> towers, int sourceStackSizeToMove, int sourcePoleIdx, int targetPoleIdx) {

        Deque<Integer> src = towers.get(sourcePoleIdx);
        if (sourceStackSizeToMove == 0) return;

        int auxIdx = getAuxIdx(sourcePoleIdx, targetPoleIdx);

        move(towers, sourceStackSizeToMove - 1, sourcePoleIdx, auxIdx);

        Deque<Integer> target = towers.get(targetPoleIdx);

        Integer popped = src.removeLast();
        target.addLast(popped);

        System.out.println("Moved " + popped + " from pole " + sourcePoleIdx + " to " + targetPoleIdx);
        countOfMoves++;
        printTowers(towers);


        move(towers, sourceStackSizeToMove - 1, auxIdx, targetPoleIdx);
    }


    private static void moveCycle(List<Deque<Integer>> towers, int sourceStackSizeToMove, int sourcePoleIdx, int targetPoleIdx) {
        int[][] opers = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        int idx = 0;
        while (towers.get(targetPoleIdx).size() < sourceStackSizeToMove) {
            move(towers, opers[idx][0], opers[idx][1]);
            idx = (idx + 1) % opers.length;
        }
    }

    private static void move(List<Deque<Integer>> towers, int i, int i1) {

        try {
            Deque<Integer> stack1 = towers.get(i);
            Integer v1 = stack1.isEmpty() ? Integer.MAX_VALUE : stack1.getLast();
            Deque<Integer> stack2 = towers.get(i1);
            Integer v2 = stack2.isEmpty() ? Integer.MAX_VALUE : stack2.getLast();

            if (v1 > v2) {
                int buf = i;
                i = i1;
                i1 = buf;
            }

            if (!towers.get(i).isEmpty()) {
                Integer popped = towers.get(i).removeLast();
                towers.get(i1).addLast(popped);
                countOfMoves++;
                printTowers(towers);
                System.out.println("Moved " + popped + " from pole " + i + " to " + i1);
            } else {
                System.out.println("EEEEE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
