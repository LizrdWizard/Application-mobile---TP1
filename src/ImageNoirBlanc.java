import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ImageNoirBlanc extends Image {
    public ImageNoirBlanc(String nomFichier) {
        super(nomFichier);
    }
    public void lire() {
        super.lire("P2");
    }

    /**
     * @param
     * @description:
     */
    public void ecrire() {
        super.ecrire("P2");
    }
}
