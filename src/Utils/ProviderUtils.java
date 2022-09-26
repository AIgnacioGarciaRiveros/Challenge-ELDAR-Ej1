package Utils;

import Entity.AmexProvider;
import Entity.NaraProvider;
import Entity.Provider;
import Entity.VisaProvider;

public class ProviderUtils {

    private static final String NOT_A_BRAND ="Error.No se ha ingresado una marca sino que han sido numeros";
    private static final String NOT_A_KNOWN_BRAND ="Error.No se ha ingresado una marca correcta";

    public static Provider getCardBrand(String brand) throws Exception {
        //marca tiene numeros
        if(brand.matches(".*\\d.*")) throw new Exception(NOT_A_KNOWN_BRAND);

        if(!brand.equals("VISA")&&!brand.equals("NARA")&&!brand.equals("AMEX"))
            throw new Exception(NOT_A_KNOWN_BRAND);

        Provider provider=new Provider();
        if(brand.equals(new AmexProvider().getProviderName())) provider = new AmexProvider();

        if(brand.equals(new VisaProvider().getProviderName())) provider = new VisaProvider();

        if(brand.equals(new NaraProvider().getProviderName())) provider = new NaraProvider();

        return provider;

    }
}
