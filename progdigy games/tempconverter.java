import java.util.*;
class tempconverter 
{
    public static void main(String[] arg) 
    {
        Scanner s = new Scanner(System.in);

        System.out.println("enter the temperature(temperature space unit(format))");
        String temp = s.nextLine();
        String str[]=temp.split(" ");
        double temperaturetocovert = Double.parseDouble(str[0]);   
        String unit="";   

        try{    // try catch block to check is unit is present or not using ArrayIndexOutOfBoundsException
        unit = str[1].toLowerCase();
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Unit is not given try once more");
        }

        switch (unit) {
            case "c":
            System.out.println("Temperature in Fahrenheit: " +( temperaturetocovert * 9/5) + 32 +"°F");
            System.out.println("Temperature in Kelvin: " +  (temperaturetocovert+273.15) + " K"); // Changed temperature to t
            break;
        case "f":
            System.out.println("Temperature in Celsius: " + ((temperaturetocovert - 32) * 5/9) + " °C"); // Changed temperature to t
            System.out.println("Temperature in Kelvin: " + (temperaturetocovert - 32) * 5 / 9 +273.15 + " K"); // Changed temperature to t
            break;
        case "k":
            System.out.println("Temperature in Celsius: "+ (temperaturetocovert - 273.15)+ " °C"); // Changed temperature to t
            System.out.println("Temperature in Fahrenheit: "+(temperaturetocovert - 273.15)*9/5+32 + " °F"); // Changed temperature to t
            break;

            
    }

    s.close();
    }
    
    
}