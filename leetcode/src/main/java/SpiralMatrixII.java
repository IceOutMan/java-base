/**
 * @Author glf
 * @Date 2021/3/16
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        generateMatrix(3);
    }


    public static int[][] generateMatrix(int n){
        int num = 1;
        int[][] matrix = new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;

        while(top<=bottom && left <= right){

            //top
            for(int colums=left;colums <=right;colums++){
                matrix[top][colums] = num;
                num++;
            }

            // right
            for(int rows=top+1;rows<=bottom; rows++){
                matrix[rows][right] = num;
                num++;
            }

            // bottom
            for(int colums = right-1; colums >= left;colums--){
                matrix[bottom][colums] = num;
                num++;
            }

            //left
            for(int rows = bottom-1; rows >=top+1; rows--){
                matrix[rows][left] = num;
                num++;
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return matrix;
    }
}
