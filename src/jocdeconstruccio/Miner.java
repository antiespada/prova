package jocdeconstruccio;
import static java.lang.Thread.sleep;

public class Miner extends Huma {
    
    //Constructors
    public Miner(CuaMaterials cua) {super(cua);}
    public Miner(CuaMaterials cua, int força) {super(cua, força);}
    public Miner(CuaMaterials cua, int força,int temps) {super(cua, força,temps);}
    public Miner(CuaMaterials cua, int força,int temps, String nom) {super(cua, força,temps, nom);}
    public Miner(CuaMaterials cua, int força, int tempsc,int temps, String nom) {super(cua, força, tempsc, temps, nom);}
   
    @Override
    public void run() {
        int viatge = 0;
        while (true) {
            //Funcions especials
            successos();
            mercader();
            if (super.getSalut()) {     try {
            //Si te salut, treballa
                System.out.println("- Miner "+nom+" comença a picar pedra...");
                sleep(tempsc*1000);} catch (InterruptedException ex) {}
            
                System.out.println("> Miner "+nom+" agafa " + super.getForça() + " unitats de pedra");
                super.setInventari(new Materials(super.getInventari().fusta, super.getForça()));
                
                //Temps entre que agafa el material i el porta o espera es buidi el magatzem
                try {sleep(temps*1000);} catch (InterruptedException ex) {}
                
                //S'afegeix a la cua
                try {
                    super.getCua().set(nom,super.getInventari(), "miner");
                    viatge++;
                    if(viatge % 3 == 0){pagar();} //Cada 3 viatges, el pagaran
                    sleep(temps*1000);} 
                catch (InterruptedException ex) {}} 
            
            //Sino, la recupera al cap de 5 segons i torna
            else {                     
                try {sleep(5000);} catch (InterruptedException ex) {}
                System.out.println("O El miner "+nom+" torna a la feina");
                super.setSalut(true);}}
    }
}
