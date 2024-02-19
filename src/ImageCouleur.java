import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ImageCouleur extends Image {
    public ImageCouleur(String nomFichier) {
        super(nomFichier);
    }

    public void lire() {
        super.lire("P3");
    }

    /**
     * @param
     * @description:
     */
    public void ecrire() {
        super.ecrire("P3");
    }
}
