package Entity;

import java.time.LocalDate;

public class AmexProvider extends Provider {
    @Override
    public double calculateFee() {
        double serviceFee= LocalDate.now().getMonth().getValue()*0.1;
        return serviceFee;
    }

    public AmexProvider() {
        providerName="AMEX";
    }
}
