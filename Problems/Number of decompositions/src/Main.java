import java.util.*;

class Main {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        // put your code here
        List<Integer> nan = new ArrayList<>();
        int n = new Scanner(System.in).nextInt();
        List<List<Integer>> decompose = decompose(n, nan);
        List<List<Integer>> decompose1 = decompose(decompose);
        //decompose(decompose1);
        //result.addAll(decompose1);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                if (integer != 0) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        }
    }


    private static List<List<Integer>> decompose(int n, List<Integer> others) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = n / 2; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(n - i);
            list.add(i);
            list.addAll(others);
            lists.add(list);
        }
        return lists;
    }

    private static List<List<Integer>> decompose(List<List<Integer>> superLists) {
        List<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> superList : superLists) {

            for (int i = 0; i < superList.size(); i++) {
                ArrayList<Integer> others = new ArrayList<>(superList);
                others.remove(i);
                List<List<Integer>> decompose = decompose(superList.get(i), others);
                lists.addAll(decompose);
            }

        }
        result.addAll(lists);
        return lists;
    }




}