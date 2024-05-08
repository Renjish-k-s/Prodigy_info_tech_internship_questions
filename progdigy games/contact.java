import java.util.*;
import java.io.*;


class contact {

        public static void main(String[] args)
        {
            Scanner s = new Scanner(System.in);

            
            System.out.println("Enter the no. of contacts  added");
            int limit = s.nextInt();
            s.nextLine();
            String[][] contact = new String[limit][4];
            String name,email,phoneno;
            int slno,j,i;
            

            for(i=0;i<limit;i++)gi 
            {
                j=0;
                contact[i][j]=String.valueOf(i+1);
                j+=1;
                System.out.println("Enter the name");
                contact[i][j]=s.nextLine();
                j+=1;
                System.out.println("Enter the phone no.");
                contact[i][j]=s.nextLine();
                j+=1;
                System.out.println("Enter the email");
                contact[i][j]=s.nextLine();
                
            }
            j=0;
            for(i=0;i<limit;i++)
            {
                System.out.println(contact[i][j]+"-----"+contact[i][j+1]+"-----"+contact[i][j+2]+"-----"+contact[i][j+3]);
            }

            String filename="contact.csv";

            try
            {
                FileWriter writer = new FileWriter(filename);

                for(String[] rowDate : contact)
                {
                    int x =rowDate.length;
                    for(i=0;i<x;i++)
                    {
                        writer.append(rowDate[i]);
                        if (i<rowDate.length-1) {

                            writer.append(",");
                            
                        }
                    }

                    writer.append("\n");
                }
                writer.flush();;
                writer.close();
            }
            catch(IOException ex)
            {
                System.out.println(ex);
            }

        }
}
