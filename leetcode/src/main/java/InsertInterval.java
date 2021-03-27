import java.util.*;

/**
 * @Author glf
 * @Date 2021/3/17
 */
public class InsertInterval {
    public static void main(String[] args) {

    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        // intervals 有序不重叠
        ArrayList<int[]> intervalList = new ArrayList();
        for(int i=0;i<intervals.length;i++){
            intervalList.add(intervals[i]);
        }

        //到序
        for(int i= intervalList.size() -1; i>=0; i--){
            int L = intervalList.get(i)[0];
            int R = intervalList.get(i)[1];

            //后面插入
            if(R < newInterval[0]){
                intervalList.add(i+1,new int[]{newInterval[0],newInterval[1]});

                return intervalList.toArray(new int[intervalList.size()][]);
            }else if (L > newInterval[1]){
                continue;
            }else{
                //合并并删除
                newInterval[0] = Math.min(L,newInterval[0]);
                newInterval[1] = Math.max(R,newInterval[1]);
                intervalList.remove(i);
            }
        }
        //走到这里说明头部插入
        intervalList.add(0,new int[]{newInterval[0],newInterval[1]});
        return intervalList.toArray(new int[intervalList.size()][]);
    }
}
