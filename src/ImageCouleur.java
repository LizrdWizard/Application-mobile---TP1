import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ImageCouleur extends Image {
    public ImageCouleur() {
        super();
    }

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

    public ImageCouleur extraire(int x1, int y1, int x2, int y2) {
        int newWidth = x2 - x1 +1;
        int newHeight = y2 - y1 +1;

        ImageCouleur nouvelleImage = new ImageCouleur();
        nouvelleImage._width = (short) newWidth;
        nouvelleImage._height = (short) newHeight;
        nouvelleImage._pixel = new PixelCouleur[newWidth][newHeight];

        for (int i = y1; i <= y2; i++) { //ligne
            for (int j = x1; j <= x2; j++) { //colonne
                nouvelleImage._pixel[i - y1][j - x1] = this._pixel[i][j];
            }
        }

        return nouvelleImage;
    }
}
