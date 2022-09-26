package Entity;

public class Provider {

    protected String providerName;
    public double calculateFee() {
        return 0;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
