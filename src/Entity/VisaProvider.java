package Entity;

import java.time.LocalDate;

public class VisaProvider extends Provider {
    @Override
    public double calculateFee() {
        double serviceFee= LocalDate.now().getYear()/LocalDate.now().getMonth().getValue();
        return serviceFee;
    }

    public VisaProvider() {
        providerName="VISA";
    }
}
