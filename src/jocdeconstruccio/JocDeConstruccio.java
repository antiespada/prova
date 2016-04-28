package jocdeconstruccio;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
public class JocDeConstruccio {
    public static void main(String[] args) throws InterruptedException {
        Materials casa  = new Materials(8,10);     //Creació de les cases
        Materials casa1 = new Materials(5,6);      //Cadascuna amb els seus requisits de materials
        Materials casa2 = new Materials(0,10);
        Materials casa3 = new Materials(20,20);
        Materials[] cases = new Materials[]{casa,casa1,casa2};      
        
        CuaMaterials cua = new CuaMaterials();              //Cua de materials
        
        List<Huma> personatjes = new ArrayList<>();                   //Crida de Treballadors
        personatjes.add(new Lenyador(cua, 5,10,7, "Pep"));            //Cada treballador té accés a la cua
        personatjes.add(new Miner(cua, 5,8,6, "Joan"));               //Una força (Quantitat de materials que pot portar)
        personatjes.add(new Constructor(cua, 7,9,10,"Jesus",cases));  //I una velocitat
        personatjes.add(new Lenyador(cua, 7,11,5,"Daniel"));          //Els constructors tenen també un array de cases 
        personatjes.add(new Constructor(cua, 9,7,6,"Marc",cases));    //per a construir
        personatjes.add(new Miner(cua, 8,10,3,"Oriol"));
        //personatjes.add(new Lenyador(cua, força, velocitatMaterials,velocitatMoviment, nom));
        //personatjes.add(new Miner(cua, força, velocitatMaterials,velocitatMoviment, nom));
        //personatjes.add(new Constructor(cua, força, velocitatMaterials,velocitatMoviment, nom, arrayCases));
        
        System.out.println("\t\t ===============\n\t\t   CONSTRUCCIÓ\n\t\t ===============\n\t\t     El Joc");
        System.out.println("Llegenda:\n"
                + "- Acció\n"
                + "> Anada\n"
                + "< Tornada\n"
                + "! Esdeveniment important\n"
                + "M Mercader\n"
                + "X No poden comprar\n"
                + "^ Millora comprada\n"
                + "+ Creació de personatge\n");
        
        //Recorrem l'array de personatges per a començar els Threads
        for (Huma personatje : personatjes) {               
            if (personatje instanceof Constructor) {        
                ((Constructor) personatje).start();
                System.out.println("+ Constructor amb força "+personatje.getForça()+" i velocitat "+personatje.getTemps());} 
            else if (personatje instanceof Miner) {
                ((Miner) personatje).start();
                System.out.println("+ Miner amb força "+personatje.getForça()+" i velocitat "+personatje.getTemps());} 
            else if (personatje instanceof Lenyador) {
                ((Lenyador) personatje).start();
                System.out.println("+ Lenyador amb força "+personatje.getForça()+" i velocitat "+personatje.getTemps());}
            sleep(2000);
        }
    }
}
