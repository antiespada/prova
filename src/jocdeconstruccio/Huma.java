package jocdeconstruccio;

import java.util.Random;

public class Huma extends Thread {
    private Materials inventari = new Materials();
    private boolean salut = true;
    private CuaMaterials cua = new CuaMaterials();
    private int força = 1;
    protected int temps = 10;
    protected int tempsc = 13;
    protected String nom;
    protected int diners  = 0;
    private static final int PREU = 30;

    //Getters i Setters
    public int getTemps() {return temps;}
    public void setInventari(Materials inventari) {this.inventari = inventari;}
    public void setSalut(boolean salut) {this.salut = salut;}
    public void setCua(CuaMaterials cua) {this.cua = cua;}
    public void setForça(int força) {this.força = força;}
    public Materials getInventari() {return inventari;}
    public boolean getSalut() {return salut;}
    public CuaMaterials getCua() {return cua;}
    public int getForça() {return força;}
    
    //Constructors
    public Huma() {}
    public Huma(CuaMaterials cua) {this.cua = cua;}
    public Huma(CuaMaterials cua, int força) {
        this.cua = cua; 
        this.força = força;}
    public Huma(CuaMaterials cua, int força, int temps) {
        this.cua = cua;
        this.força = força;
        this.temps = temps;}
    public Huma(CuaMaterials cua, int força, int temps, String nom) {
        this.cua = cua;
        this.força = força;
        this.temps = temps;
        this.nom=nom;}
    public Huma(CuaMaterials cua, int força, int tempsc, int temps, String nom) {
        this.cua = cua;
        this.força = força;
        this.temps = temps;
        this.nom=nom;
        this.tempsc = tempsc;}
    
    
    
    public void successos() {          //Aquesta funció determina quan els treballadors es posen malalts
        boolean ale = aleatori(100);   //Ajudant-se de la funcio aleatori()
        if (ale && salut) {
            salut=false;
            if (this instanceof Lenyador) {System.out.println("! Un lenyador s'ha posat malalt!");} 
            else if (this instanceof Miner) {System.out.println("! Un miner s'ha posat malalt!");}}}
    public void mercader(){
        boolean ale = aleatori(5); 
        if(ale){
            System.out.println("M Ha vingut el mercader!");
            if(this.diners > PREU  && tempsc >= 3){
            if(this instanceof Lenyador){
                this.diners = diners - PREU ;
                System.out.println("^ El lenyador "+this.nom+" ha comprat una millora!");
                this.tempsc = tempsc - 2;}
            else if(this instanceof Constructor){
                this.diners = diners - PREU ;
                System.out.println("^ El constructor "+this.nom+" ha comprat una millora!");
                this.tempsc = tempsc - 2;}
            else if(this instanceof Miner){
                this.diners = diners - PREU ;
                System.out.println("^ El miner "+this.nom+" ha comprat una millora!");
                this.tempsc = tempsc - 2;}}
            else{
                if(this instanceof Lenyador) System.out.println("X El lenyador "+this.nom+" no pot comprar cap millora!");
                else if(this instanceof Constructor) System.out.println("X El constructor "+this.nom+" no pot comprar cap millora!");
                else if(this instanceof Miner) System.out.println("X El miner "+this.nom+" no pot comprar cap millora!");}}
           
    }
    public void pagar(){diners = diners + 20;}
    
    public boolean aleatori(int numero) {        //Retorna un boleà amb una probabilitat baixa de ser cert
                                       //S'haurà de comprovar l'execució per veure el percentatge i ajustar-lo
        Random rand = new Random();
        int aleatori1 = rand.nextInt(numero);
        int aleatori2 = rand.nextInt(numero);
        if (aleatori1 == aleatori2) {return true;} 
        else {return false;}
    }
}
