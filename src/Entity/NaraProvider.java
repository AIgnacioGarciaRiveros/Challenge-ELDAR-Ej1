package Entity;

import java.time.LocalDate;

public class NaraProvider extends Provider {
    @Override
    public double calculateFee() {
        double serviceFee= LocalDate.now().getDayOfMonth()*0.5;
        return serviceFee;
    }

    public NaraProvider() {
        providerName="NARA";
    }
}
