package jocdeconstruccio;

import static java.lang.Thread.sleep;
public class Lenyador extends Huma {
    private int viatje = 0;

    public Lenyador(CuaMaterials cua) {super(cua);}
    public Lenyador(CuaMaterials cua, int força) {super(cua, força);}
    public Lenyador(CuaMaterials cua, int força, int temps) {super(cua, força, temps);}
    public Lenyador(CuaMaterials cua, int força, int temps, String nom) {super(cua, força, temps, nom);}
    public Lenyador(CuaMaterials cua, int força,int tempsc, int temps, String nom) {super(cua, força, tempsc, temps, nom);}

    @Override
    public void run() {
        while (true) {
            successos();
            mercader();
            if (super.getSalut()) {     //Si te salut, treballa
                System.out.println("- Lenyador "+nom+" comença a talar fusta...");
                try {sleep(tempsc*1000);} catch (InterruptedException ex) {}
                System.out.println("> Lenyador "+nom+" agafa " + super.getForça() + " unitats de fusta");
                super.setInventari(new Materials(super.getForça(), super.getInventari().pedra));
                //temps entre que agafa el material i el porta o espera es buidi el magatzem
                try {sleep(temps*1000);} catch (InterruptedException ex) {}
                //s'afegeix a la cua
                try {
                    super.getCua().set(nom,super.getInventari(), "lenyador");
                    viatje++;
                    if(viatje % 3 == 0){pagar();} //Cada 3 viatges, el pagaran
                    sleep(temps*1000);} catch (InterruptedException ex) {}} 
            else {                      //Sino, la recupera al cap de 5 segons i torna
                try {sleep(5000);} catch (InterruptedException ex) {}
                System.out.println("O El lenyador torna a la feina");
                super.setSalut(true);}}
    }
}
