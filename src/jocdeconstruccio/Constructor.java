package jocdeconstruccio;

import static java.lang.Thread.sleep;

public class Constructor extends Huma {
    
    int casa = 0; //Cases del constructor
    Materials[] tipus_casa
    
    //Constructors
    public Constructor(CuaMaterials cua) {super(cua);}
    public Constructor(CuaMaterials cua, int força, Materials[] tipus_casa) {super(cua, força);this.tipus_casa=tipus_casa;}
    public Constructor(CuaMaterials cua, int força,int temps, Materials[] tipus_casa) {super(cua, força,temps);this.tipus_casa=tipus_casa;}
    public Constructor(CuaMaterials cua, int força,int temps, String nom, Materials[] tipus_casa) {super(cua,força,temps,nom);this.tipus_casa=tipus_casa;}
    public Constructor(CuaMaterials cua, int força,int tempsc, int temps, String nom, Materials[] tipus_casa) {super(cua,força, tempsc,temps,nom);this.tipus_casa=tipus_casa;}

    @Override
    public void run() {
        Materials novaCasa = new Materials();
        while (casa!=tipus_casa.length) {
            //Funcions especials
            successos();
            mercader();
            if (super.getSalut()) {
                //Es fica a la cua per agafar materials per la casa
                try { 
                    novaCasa = super.getCua().get(nom,super.getInventari(), super.getForça(), novaCasa.fusta, novaCasa.pedra,tipus_casa[casa]);
                    sleep(temps*1000);}
                catch (InterruptedException ex) {}
                
                //Deixa els materials a la casa
                if (novaCasa.fusta !=tipus_casa[casa].fusta ) {
                    System.out.println("< Constructor "+nom+" deixa " + super.getInventari().fusta + " unitats fusta a la casa");
                    novaCasa.fusta = novaCasa.fusta + super.getInventari().fusta;
                    super.setInventari(new Materials(0, super.getInventari().pedra));
                    try {sleep(temps*1000);} catch (InterruptedException ex) {}} 
                else {
                    System.out.println("> Constructor "+nom+" deixa " + super.getInventari().pedra + " unitats pedra a la casa");
                    novaCasa.pedra = novaCasa.pedra + super.getInventari().pedra;
                    super.setInventari(new Materials(super.getInventari().fusta, 0));
                    try {sleep(temps*1000);} catch (InterruptedException ex) {}}
                                
                //Construir la casa
                if (novaCasa.fusta == tipus_casa[casa].fusta && novaCasa.pedra == tipus_casa[casa].pedra) {
                    System.out.println("- Constructor "+nom+" comença a construïr la casa...");
                    try {sleep(tempsc*1000);} catch (InterruptedException ex) {}
                    System.out.println("! Constructor "+nom+" acaba la casa");
                    novaCasa.fusta = 0;
                    novaCasa.pedra = 0;
                    casa++;
                    pagar();}} 
            else {try {sleep(5000);} catch (InterruptedException ex) {}
                    System.out.println("O El constructor "+nom+" torna a la feina");
                    super.setSalut(true);}}
      
        
    }
}
