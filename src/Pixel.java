import java.util.Scanner;

public interface Pixel {

    public void lire(Scanner scanner);

    public void ecrire(Scanner scanner);

    public void eclaircir_noircir(short valeur);
}
