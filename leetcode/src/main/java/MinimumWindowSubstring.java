/**
 * @Author glf
 * @Date 2021/3/17
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t){

        int[] expected_count = new int[256];
        int[] appeared_count = new int[256];

        int win_start = 0;
        int appeared = 0;
        int minWidth = Integer.MAX_VALUE;
        int minStart = 0;

        for(int i=0;i<t.length();i++){
            expected_count[t.charAt(i)]++;
        }

        for(int win_end = 0; win_end<s.length();win_end++){
            // win_end in t
            if(expected_count[s.charAt(win_end)] > 0){
                appeared_count[s.charAt(win_end)]++;   //出现次数+1

                if(appeared_count[s.charAt(win_end)] <= expected_count[s.charAt(win_end)]){
                    appeared++;
                }
            }
            //窗中包含T
            if(appeared == t.length()){
                //移动win_start
                while(appeared_count[s.charAt(win_start)] > expected_count[s.charAt(win_start)]
                        || expected_count[s.charAt(win_start)] == 0){
                    appeared_count[s.charAt(win_start)]--;
                    win_start++;
                }
                //比较最小值
                if(minWidth > (win_end - win_start +1)){
                    minWidth = win_end - win_start + 1;
                    minStart = win_start;
                }
            }
        }
        if(minWidth == Integer.MAX_VALUE){return "";}
        return s.substring(minStart, minStart+minWidth);
    }
}
