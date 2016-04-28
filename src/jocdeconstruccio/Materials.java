package jocdeconstruccio;
public class Materials {
    int pedra;
    int fusta;
    public Materials() {
        pedra = 0;
        fusta = 0;}

    public Materials(int fusta, int pedra) {
        this.fusta = fusta;
        this.pedra = pedra;}
    public Materials(int fusta, int pedra, String nom) {
        this.fusta = fusta;
        this.pedra = pedra;}

    
}
