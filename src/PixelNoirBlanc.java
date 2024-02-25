import java.util.List;
import java.util.Scanner;

/**
 * Classe Pixel noir et blanc
 */
public class PixelNoirBlanc implements Pixel {

    private short _pixel;

    /**
     * @author Jasmin Dubuc
     *
     * Constructeur sans paramètres
     */
    public PixelNoirBlanc() {
        _pixel = 0;
    }

    /**
     * @param scanner Object Scanner en cours de lecture du fichier
     * @author Jasmin Dubuc
     *
     * Le pixel lit le prochain mot dans le fichier et ajoute sa valeur à _pixel si c'est un short
     */
    public void lire(Scanner scanner) {

        try {

            if (!scanner.hasNextShort()) {
                throw new Exception("Valeur n'est pas un short");
            }

            _pixel = scanner.nextShort();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return Retourne le string représentant la valeur du Pixel
     * @author Félix Barré
     *
     * Retourne la valeur de _pixel en String
     */
    public String ecrire() {
        return String.valueOf(_pixel) + ' ';
    }

    /**
     * @param valeur Short valeur représentant les unités de luminosité à ajuster
     * @author Jasmin Dubuc
     *
     * Change la valeur de _pixel pour ajuster la luminosité de l'image
     */
    public void eclaircir_noircir(short valeur) {

        _pixel += valeur;

        if (_pixel < 0) {_pixel = 0;}
        if (_pixel > 255) {_pixel = 255;}
    }

    /**
     * @param listePixels Liste de Pixels à calculer
     * @return Retourne un pixel équivalent à la valeure moyenne de tous
     * @author Félix Barré
     *
     * Retourne la moyenne d'un ensemble de pixels noirs et blancs incluant soi-même
     */
    public Pixel moyenne(List<Pixel> listePixels) {
        PixelNoirBlanc pixelMoyen = this;

        for (int i = 0; i < listePixels.size(); i++) {
            if (listePixels.get(i) instanceof PixelNoirBlanc) {
                pixelMoyen._pixel += ((PixelNoirBlanc) listePixels.get(i))._pixel;
            }
        }

        pixelMoyen._pixel /= (listePixels.size() + 1);

        return pixelMoyen;
    }
}
