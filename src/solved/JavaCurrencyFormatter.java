import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class JavaCurrencyFormatter {

    public static void main(String[] args) {

        double payment = 10000005;

        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        usFormat.setCurrency(Currency.getInstance(Locale.US));
        usFormat.setMaximumFractionDigits(2);
        usFormat.setMinimumFractionDigits(2);

        String us = usFormat.getCurrency().getSymbol(Locale.US) + usFormat.format(payment);

        Locale indiaLocale = new Locale("en", "india");
        NumberFormat indiaFormat = NumberFormat.getInstance(indiaLocale);
        indiaFormat.setMaximumFractionDigits(2);
        indiaFormat.setMinimumFractionDigits(2);
        String india = "Rs." + indiaFormat.format(payment);

        NumberFormat chinaFormat = NumberFormat.getInstance(Locale.CHINA);
        // usFormat.setCurrency(Currency.getInstance(Locale.CHINA));
        chinaFormat.setMaximumFractionDigits(2);
        chinaFormat.setMinimumFractionDigits(2);
        String china = chinaFormat.getCurrency().getSymbol(Locale.CHINA) + chinaFormat.format(payment);

        NumberFormat franceFormat = NumberFormat.getInstance(Locale.FRANCE);
        franceFormat.setMaximumFractionDigits(2);
        franceFormat.setMinimumFractionDigits(2);
        String france = franceFormat.format(payment) + " " + franceFormat.getCurrency().getSymbol(Locale.FRANCE);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }
}
