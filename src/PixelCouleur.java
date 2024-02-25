import java.util.List;
import java.util.Scanner;

/**
 * Classe Pixel couleur
 */
public class PixelCouleur implements Pixel {

    private short[] _pixel;

    private static final short _size = 3;

    /**
     * @author Jasmin Dubuc
     *
     * Constructeur sans paramètres
     */
    public PixelCouleur() {
        _pixel = new short[_size];
    }

    /**
     * @param scanner Object Scanner en cours de lecture du fichier
     * @author Jasmin Dubuc
     *
     * Le pixel lit le prochain mot dans le fichier et ajoute sa valeur à _pixel si c'est un short
     */
    public void lire(Scanner scanner) {

        try {
            for (int i = 0; i < _size; i++) {

                if (!scanner.hasNextShort()) {
                    throw new Exception("Valeur n'est pas un short");
                }

                _pixel[i] = scanner.nextShort();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @return Retourne le string représentant la valeur du Pixel
     * @author Félix Barré
     *
     * Retourne les trois valeur de _pixel en String
     */
    public String ecrire() {
        String sortie = "";

        for (int i = 0; i < _size; i++) {
            sortie += _pixel[i] + " ";
        }
        return sortie;
    }

    /**
     * @param valeur Short valeur représentant les unités de luminosité à ajuster
     * @author Jasmin Dubuc
     *
     * Change les trois valeurs de _pixel pour ajuster la luminosité de l'image
     */
    public void eclaircir_noircir(short valeur) {

        for (int i = 0; i < _size; i++) {
            _pixel[i] += valeur;

            if (_pixel[i] < 0) {_pixel[i] = 0;}
            if (_pixel[i] > 255) {_pixel[i] = 255;}

        }
    }

    /**
     * @param listePixels Liste de Pixels à calculer
     * @return Retourne un pixel équivalent à la valeure moyenne de tous
     * @author Félix Barré
     *
     * Retourne la moyenne d'un ensemble de pixels en couleur incluant soi-même
     */
    public Pixel moyenne(List<Pixel> listePixels) {
        PixelCouleur pixelMoyen = this;

        for (int i = 0; i < listePixels.size(); i++) {
            if (listePixels.get(i) instanceof PixelCouleur) {
                for (int j = 0; j < _size; j++) {
                    pixelMoyen._pixel[j] += ((PixelCouleur) listePixels.get(i))._pixel[j];
                }
            }
        }

        for (int j = 0; j < _size; j++) {
            pixelMoyen._pixel[j] /= (listePixels.size() + 1);
        }

        return pixelMoyen;
    }
}
