/**
 * @description Classe pour une image PGM
 */
public class ImageNoirBlanc extends Image {
    /**
     * @description Constructeur sans paramètres
     * @author Félix Barré
     */
    public  ImageNoirBlanc() {
        super();
    }
    /**
     * @description Constructeur avec paramètres
     * @author Félix Barré
     */
    public ImageNoirBlanc(String nomFichier) {
        super(nomFichier);
    }

    /**
     * @description Lire une image à partir du fichier
     * @author Félix Barré
     */
    public void lire() {
        super.lire("P2");
    }

    /**
     * @description Écrire l'image dans un fichier
     * @author Félix Barré
     */
    public void ecrire() {
        super.ecrire("P2");
    }

    /**
     * @param x1 Position x du point 1
     * @param x2 Position x du point 2
     * @param y1 Position y du point 1
     * @param y2 Position y du point 2
     * @description Extrait une section déterminée de l'image
     * @author Joel Tidjane
     */
    public ImageNoirBlanc extraire(int x1, int y1, int x2, int y2) {
        int newWidth = x2 - x1 +1;
        int newHeight = y2 - y1 +1;

        ImageNoirBlanc nouvelleImage = new ImageNoirBlanc();
        nouvelleImage._width = (short) newWidth;
        nouvelleImage._height = (short) newHeight;
        nouvelleImage._nomFichier = _nomFichier;
        nouvelleImage._pixel = new PixelNoirBlanc[newWidth][newHeight];

        for (int i = y1; i <= y2; i++) { //ligne
            for (int j = x1; j <= x2; j++) { //colonne
                nouvelleImage._pixel[i - y1][j - x1] = this._pixel[i][j];
            }
        }

        return nouvelleImage;
    }
}
