import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String base = "BRL";
//        String target = "USD";
//        String amount = "100";
        String base = "";
        String target = "";

        Scanner input = new Scanner(System.in);
        int menuInput = 0;
        float amount = 0;

        ApiRequest apiRequest = new ApiRequest();

        String menu = """
                Pick a valid option:
                                
                1. US Dollar --> Argentine Peso
                2. Argentine Peso --> US Dollar
                3. US Dollar --> Brazilian Real
                4. Brazilian Real --> US Dollar
                5. US Dollar --> Colombian Peso           
                6. Colombian Peso --> US Dollar
                7. Customize
                8. End operations
                """;
        
        while (menuInput != 8) {
            System.out.print(menu);
            menuInput = input.nextInt();

            switch (menuInput) {
                case 1:
                    base = "USD";
                    target = "ARS";
                    break;

                case 2:
                    base = "ARS";
                    target = "USD";
                    break;

                case 3:
                    base = "USD";
                    target = "BRL";
                    break;

                case 4:
                    base = "BRL";
                    target = "USD";
                    break;

                case 5:
                    base = "USD";
                    target = "COP";
                    break;

                case 6:
                    base = "COP";
                    target = "USD";
                    break;

                case 7:
                    //custom currency input by user
                    System.out.println("What is the base currency?");
                    base = input.next();

                    System.out.println("What is the currency that is the target of conversion?");
                    target = input.next();
                    break;

                case 8:
                    System.out.println("Ending...");
                    break;

                default:
                    System.out.println("Invalid Option.");
            }

            System.out.println("How much would you like to convert? {" + base +"} --> {" + target + "}" );
            amount = input.nextFloat();

            Currency currency = apiRequest.pairConversion(base, target, amount);
            System.out.println(amount + " " +base + " --> " + currency.conversion_result() + " " + target);
        }
    }
}
