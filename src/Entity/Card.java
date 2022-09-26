package Entity;

import Utils.ProviderUtils;

import java.time.LocalDate;

public class Card {
    private Provider brand;
    private long id;
    private String cardHolder;
    private LocalDate expirationDate;
    private double credit;

    public Card() {
    }

    public Card(String brand, long id, String cardHolder, LocalDate expirationDate, double credit) throws Exception {
        this.brand = ProviderUtils.getCardBrand(brand);
        this.id = id;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.credit = credit;
    }

    public Provider getBrand() {
        return brand;
    }

    public void setBrand(Provider brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public boolean isCardValid()
    {
        return getExpirationDate().isAfter(LocalDate.now());
    }

    public boolean isOperationValid(double amountOfMoney) throws Exception {
        return amountOfMoney<1000;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Card))
        {
            Card card = (Card) o ;
            if(card.brand.getProviderName().equals(card.getBrand().getProviderName()))
            {
                if(id ==card.id)
                {
                    if(cardHolder.equals(card.getCardHolder()))
                    {
                        if(expirationDate.isEqual(card.getExpirationDate()))
                        {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String cardInformation= "INFORMACION DE LA TARJETA"+"\n"+"MARCA : "+ getBrand().getProviderName()+"\n"
                                +"NUMERO : "+ getId()+"\n"+"DUEÑO: "+getCardHolder()+
                                "\n"+"FECHA DE VENCIMIENTO: "+getExpirationDate().toString()+"\n";

        return cardInformation;
    }


    public String obtainServiceFee(double amountOfMoney) throws Exception {
        if(!isCardValid()&&!isOperationValid(amountOfMoney)) return "ERROR: TARJETA/OPERACION NO VALIDA\n";

        double serviceFee=0;
        String informationServiceFee="";

        serviceFee= brand.calculateFee();

        informationServiceFee+="MARCA: "+ getBrand().getProviderName()+"\n"+"IMPORTE: "+amountOfMoney+"\n"+"TASA DE OPERACION: "+serviceFee;

        return informationServiceFee;
    }
}
