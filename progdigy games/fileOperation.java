import java.io.*;
import java.util.*;
public class fileOperation {

    public static List<String[]> gettable(String filename)
    {
       
        List<String[]> table = new ArrayList<>();
    
        try(BufferedReader  read = new BufferedReader(new FileReader(filename)))
        {
          
            String line;

           while((line=read.readLine())!=null)
            {
                String[] rowdata = line.split(",");
                table.add(rowdata);
               
            }
        
        }

        catch(IOException ex)
        {
            System.out.println(ex);
        }

        return table;

    }    // Resuable array returning file




    public static void main(String[] arg)

    {
        Scanner s = new Scanner(System.in);

        String filename ="contact.csv";

        int count=0;

       

        while (count==0) {


        System.out.println("\nMenu \n 1.Insert new contact \n 2.Edit new contact\n 3.Delete contact \n 4.Display my contacts \n 5.Exit");
        int ch = s.nextInt();
        int c=gettable(filename).size();
        switch (ch) {
            case 1:
                        System.out.println("Enter the no. of contacts  added");
                        int limit = s.nextInt();
                        s.nextLine();
                        int i;
                        
                      
                
                                try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true)))
                                {
                                    
                        
                                    for(i=0;i<limit;i++)
                                    {
                                    
                                        writer.write((c+=1)+",");
                                        System.out.println("Enter the name");
                                        writer.write(s.nextLine()+",");
                                        System.out.println("Enter the Phone number");
                                        writer.write(s.nextLine()+",");
                                        System.out.println("Enter the Email address");
                                        writer.write(s.nextLine()+",");
                                        writer.write("\n");
                                    }
                                    writer.close();
                                }
                                catch(IOException ex)
                                {
                                    System.out.println(ex);
                                }
            break;
            case 2:
                            s.nextLine();
                            List<String[]> realtobedit=gettable(filename);
                            
                            System.out.println("Enter the slno of person to be edited");
                            int editno=s.nextInt();
                            String ed[][] = new String[c][4];
                            int m=-1;
                            int r=0;
                            // System.out.println(c);
                            for(String[] row: realtobedit)
                            {
                                m+=1;
                                    for(String field : row)
                                    {
                                        ed[m][r]=field;
                                        
                                        // System.out.println(m +" "+ r);

                                        r+=1;
                                    }    
                                    r=0;
                                    
                            }
                            s.nextLine();
                            for(i=0;i<c;i++)
                            {
                                if(i+1 == editno)
                                {
                                    System.out.println("Enter the name");
                                    ed[i][1]=s.nextLine();
                                    System.out.println("Enter the phone number");
                                    ed[i][2]=s.nextLine();
                                    System.out.println("Enter the email address");
                                    ed[i][3]=s.nextLine();
                                    break;
                                }
                            }
                            try {
                               
                               
                                
                            FileWriter realedit = new FileWriter(filename);
                                
                               
                                for (i = 0; i < c; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        realedit.write(ed[i][j] + ",");
                                    }
                                    realedit.write("\n");
                                }
                                
                                // Close the FileWriter after writing
                                realedit.close(); 
                                
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                            

                            

            break;
            case 3:
                             s.nextLine();
                             List<String[]> edittable=gettable(filename);
                             System.out.println("Enter the Sl no of person to be deleted");

                             String delno = s.nextLine();
                             i=0;
                             try
                                               {
                                               
                             FileWriter editor = new FileWriter(filename);
                             for(String[] row : edittable)
                                    {
                                        if (!row[0].strip().equals(delno.strip())) {
                                            editor.write((i+1)+",");
                                          
                                            editor.write(row[1]+",");
                                            
                                            editor.write(row[2]+",");
                                          
                                            editor.write(row[3]+",");
                                            editor.write("\n");
                                        }
                                    }

                                    editor.flush();
                                    editor.close();
                                }
                                catch(IOException ex)
                                {
                                    System.out.println(ex);
                                }


            break;
            case 4:

                                List<String[]> table=gettable(filename);

                                    for(String[] row : table)
                                    {
                                        for(String field : row)
                                        {
                                            System.out.print(field+"\t");
                                        }
                                        System.out.println("\n");
                                    }
            break;
            case 5:
                                count=1;
                                System.out.println("Exiting.... Exited sucessfully");
            break;                    
        
            default:
                break;
        }
            
        

 
    
         }

         s.close();
    }
}