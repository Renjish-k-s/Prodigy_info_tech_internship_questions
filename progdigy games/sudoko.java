import java.util.*;
public class sudoko {


    static final int len = 9;

    public static void main(String[] args) {
        // int[][] board = {
        //     {5, 3, 0, 0, 7, 0, 0, 0, 0},
        //     {6, 0, 0, 1, 9, 5, 0, 0, 0},
        //     {0, 9, 8, 0, 0, 0, 0, 6, 0},
        //     {8, 0, 0, 0, 6, 0, 0, 0, 3},
        //     {4, 0, 0, 8, 0, 3, 0, 0, 1},
        //     {7, 0, 0, 0, 2, 0, 0, 0, 6},
        //     {0, 6, 0, 0, 0, 0, 2, 8, 0},
        //     {0, 0, 0, 4, 1, 9, 0, 0, 5},
        //     {0, 0, 0, 0, 8, 0, 0, 7, 9}
        // };

            // value taking
            Scanner s = new Scanner(System.in);
            int[][] board = new int[len][len];
            System.out.println("how manny values u want to enter");
            int count=s.nextInt();

            for(int i=0;i<count;i++)
            {
                System.out.println("Entrer the positions(r,c)");
                int row=s.nextInt();
                int col=s.nextInt();
                System.out.println("Enter the value to the position");
                board[row][col]=s.nextInt();
            }
           




        if(solver(board))
        {
            for(int i=0;i<len;i++)
            {
                    for(int j=0;j<len;j++)
                    {
                        System.out.print(board[i][j]+"\t");

                    }

                    System.out.println();
                    System.out.println();
            }
        }
        else
        {
            System.out.println("no result");
        }

    }
        public static boolean solver(int[][] board)
        {
        int[] cell_poss = find_pos(board);
        // System.out.println(cell_poss[0]);
        // System.out.println(cell_poss[1]);
        if (cell_poss==null) {
            return true;
        }
        int row=cell_poss[0];
        int col=cell_poss[1];

        for(int i=1;i<=len;i++)
        {
            if(is_valid(board,row,col,i))
            {
                board[row][col]=i;
                if (solver(board)) {
                    return true;
                }

                board[row][col]=0;
            }
        } 
        return false;
        }

        

   


    public static int[] find_pos(int[][] board)
    {
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                if (board[i][j]==0) {
                    return new int[]{i,j};
                }
                return null;
    }

    public static boolean is_valid(int[][] board,int row,int col,int num)
    {
        return  vaild_row(board,row,num) && valid_col(board,col,num)&&valid_subgrid(board,row,col,num);
    }

    public static boolean vaild_row(int[][] board,int row,int num)//valid row checking 

    {
        for(int i=0;i<len;i++)
        {
            if (board[row][i]==num) {
                return false;
            }

           
        }
        return true;
    }

    public static boolean valid_col(int[][] board,int col,int num)//valid column checking
    {

        for(int i=0;i<len;i++)
        {
            if(board[i][col]==num)
            {
                return false;
            }
        }  

        return true;

    }

    public static boolean valid_subgrid(int[][] board,int row,int col,int num)
    {

        int start_r=row-row%3;
        int start_c=col-col%3;

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if (board[start_r+i][start_c+j]==num) {
                   return false;
                }
        return true;
    }



}