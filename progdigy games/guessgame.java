import java.util.*;

public class guessgame {

    public static void main(String[] args)

    {
        int i=0;
        int count=0;
        Scanner s = new Scanner(System.in);

        Random num = new Random();
        int toguess=num.nextInt(100);
        int success=0;

        while (i==0) {
           
            if (success==1) {
                toguess=num.nextInt(100);
                success=0;
                count=0;
            }
            count+=1;
            System.out.println(toguess);
            System.out.println("1.Try the game\n2.Quit the game");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                System.err.println("Enter the number");
                int tryno=s.nextInt();

                if(tryno==toguess)
                {
                    System.out.println("Sucesseed in"+count+"th attempt");
                    success=1;
                }
                else if ((toguess+10)<tryno) {

                    System.out.println("Too much high value");
                    
                }
                else if ((toguess-10)>tryno) {

                    System.out.println("Too much low value");
                    
                }
                else if ((toguess+10)>tryno && (toguess-10)<tryno) {
                    
                    System.out.println("You are comming closer.....\nTry again");
                }
                break;

                case 2:
                i=1;
                System.out.println("Stay motivated...\n come again... \n Have a nice day");
                break;
                default:
                System.out.println("Invalid input... \n try again");
                break;
            }
            
        }
    }
}