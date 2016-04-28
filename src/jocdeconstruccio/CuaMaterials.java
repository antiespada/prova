package jocdeconstruccio;

public class CuaMaterials {

    private static Materials magatzem = new Materials(30,40);
    private final int LIMIT = 100; //Limit de cada tipus de material al magatzem

    public synchronized Materials get(String nom,Materials inventari, int força, int fusta, int pedra, Materials casa) throws InterruptedException {
        if (fusta != casa.fusta) {
            while (magatzem.fusta < força || magatzem.fusta < casa.fusta - fusta) {
                try {wait();} catch (InterruptedException e) {}}
            notifyAll();
            if (fusta + força > casa.fusta) {
                //En cas de que la casa necessiti menys materials dels que pot carregar
                //Agafarà els que manquin
                System.out.println("> Constructor "+nom+" agafa " + (casa.fusta - fusta) + " unitats de fusta");
                inventari.fusta = casa.fusta - fusta;
                magatzem.fusta = magatzem.fusta - inventari.fusta;} 
            else {
                //Sinó, omplira el seu inventari al màxim
                System.out.println("> Constructor "+nom+" agafa " + força + " unitats de fusta");
                inventari.fusta = força;
                magatzem.fusta = magatzem.fusta - força;}} 
            else if (pedra != casa.pedra) {             
                while (magatzem.pedra < força || magatzem.pedra < casa.pedra - pedra) {
                    try {wait();} catch (InterruptedException e) {}}
                if (pedra + força > casa.pedra) {
                    System.out.println("> Constructor "+nom+" agafa " + (casa.pedra - pedra) + " unitats de pedra");
                    inventari.pedra = casa.pedra - pedra;
                    magatzem.pedra = magatzem.pedra - inventari.pedra;} 
                else {
                    System.out.println("> Constructor "+nom+" agafa " + força + " unitats de pedra");
                    inventari.pedra = força;
                    magatzem.pedra = magatzem.pedra - força;}}
        return new Materials(fusta, pedra);}

    public synchronized void set(String nom, Materials inventari, String tipus) throws InterruptedException {
        if (tipus.equals("lenyador")) {
            //Mentre no estigui ple
            while (magatzem.fusta == LIMIT || magatzem.fusta + inventari.fusta > LIMIT) {
                try {wait();} catch (InterruptedException e) {}}     
            notifyAll();
            magatzem.fusta = magatzem.fusta + inventari.fusta;
            System.out.println("< Lenyador "+nom+" deixa " + inventari.fusta + " unitats de fusta al magatzem (" + magatzem.fusta + ")");
            inventari.fusta = 0;} 
        else if (tipus.equals("miner")) {
            //Mentre no estigui ple
            while (magatzem.pedra == LIMIT || magatzem.pedra + inventari.pedra > LIMIT) {
                try {wait();} catch (InterruptedException e) {}}
            notifyAll();
            magatzem.pedra = magatzem.pedra + inventari.pedra;
            System.out.println("< Miner "+nom+" deixa " + inventari.pedra + " unitats de pedra al magatzem (" + magatzem.pedra + ")");
            inventari.pedra = 0;}
    }
}
