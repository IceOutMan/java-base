import java.util.*;

/**
 * @Author glf
 * @Date 2021/3/16
 */
public class MergeIntervals {

    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals){
        //先排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        for(int i=0; i< intervals.length; i++){

            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < L ){
                merged.add(new int[]{L,R});
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
