import java.util.List;
import java.util.Scanner;

public interface Pixel {

    public void lire(Scanner scanner);

    public String ecrire();

    public void eclaircir_noircir(short valeur);

    public Pixel moyenne(List<Pixel> listePixels);
}
