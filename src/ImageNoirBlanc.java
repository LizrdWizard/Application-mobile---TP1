import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ImageNoirBlanc extends Image {
    public  ImageNoirBlanc() {
        super();
    }
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

    public ImageNoirBlanc extraire(int x1, int y1, int x2, int y2) {
        int newWidth = x2 - x1 +1;
        int newHeight = y2 - y1 +1;

        ImageNoirBlanc nouvelleImage = new ImageNoirBlanc();
        nouvelleImage._width = (short) newWidth;
        nouvelleImage._height = (short) newHeight;
        nouvelleImage._pixel = new PixelNoirBlanc[newWidth][newHeight];

        for (int i = y1; i <= y2; i++) { //ligne
            for (int j = x1; j <= x2; j++) { //colonne
                nouvelleImage._pixel[i - y1][j - x1] = this._pixel[i][j];
            }
        }

        return nouvelleImage;
    }
}
