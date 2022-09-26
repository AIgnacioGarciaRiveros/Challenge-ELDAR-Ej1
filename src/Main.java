import Entity.AmexProvider;
import Entity.Card;
import Entity.Provider;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate fecha= LocalDate.of(2019, 07, 23);
        Card card = new Card("NARA",1234567,"Carlos arrubarena",fecha,15000);
        Card card2 = new Card("VISA",1234567,"Carlos martinez",fecha,15000);

        //es tarjeta distinta de otra
       if(card.equals(card2)) System.out.println("No son distintas");
       else System.out.printf("Son distintas");

        //es valida
        if(card.isCardValid()) System.out.println("Es valida");
        else System.out.println("No es valida");

        //imprimir informacion de la tarjeta
        System.out.println(card);
        System.out.println("Operacion valida");

        //es operacion valida
        if(card.isOperationValid(150)) System.out.println("Operacion valida");
        else System.out.println("Operacion no valida");


        System.out.println("Tasa de operacion: \n"+card.obtainServiceFee(750));
    }
}
