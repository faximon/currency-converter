public class Main {
    public static void main(String[] args) {
        String base = "BRL";
        String target = "USD";
        String amount = "100";
        ApiRequest apiRequest = new ApiRequest();
        Currency currency = apiRequest.pairConversion(base, target, amount);
        System.out.println(currency);
    }
}
