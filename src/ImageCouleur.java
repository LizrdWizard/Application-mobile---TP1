/**
 * Classe pour une image PPM
 */
public class ImageCouleur extends Image {
    /**
     * @author Félix Barré
     *
     * Constructeur sans paramètres
     */
    public ImageCouleur() {
        super();
    }

    /**
     * @author Félix Barré
     *
     * Constructeur avec paramètres
     */
    public ImageCouleur(String nomFichier) {
        super(nomFichier);
    }

    /**
     * @author Félix Barré
     *
     * Lire une image à partir du fichier
     */
    public void lire() {
        super.lire("P3");
    }

    /**
     * @author Félix Barré
     *
     * Écrire l'image dans un fichier
     */
    public void ecrire() {
        super.ecrire("P3");
    }

    /**
     * @param x1 Position x du point 1
     * @param x2 Position x du point 2
     * @param y1 Position y du point 1
     * @param y2 Position y du point 2
     * @return Retourne une nouvelle image en couleur correspondante à la section extraite
     * @author Joel Tidjane
     *
     * Extrait une section déterminée de l'image
     */
    public ImageCouleur extraire(int x1, int y1, int x2, int y2) {
        int newWidth = x2 - x1 +1;
        int newHeight = y2 - y1 +1;

        ImageCouleur nouvelleImage = new ImageCouleur();
        nouvelleImage._width = (short) newWidth;
        nouvelleImage._height = (short) newHeight;
        nouvelleImage._nomFichier = _nomFichier;
        nouvelleImage._pixel = new PixelCouleur[newWidth][newHeight];

        for (int i = y1; i <= y2; i++) { //ligne
            for (int j = x1; j <= x2; j++) { //colonne
                nouvelleImage._pixel[i - y1][j - x1] = this._pixel[i][j];
            }
        }

        return nouvelleImage;
    }
}
