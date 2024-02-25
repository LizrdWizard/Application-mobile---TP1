import java.util.List;
import java.util.Scanner;

/**
 * @author Jasmin Dubuc
 *
 * Interface Pixel
 */
public interface Pixel {

    /**
     * @param scanner Objet Scanner en cours de lecture du fichier
     * @author Jasmin Dubuc
     *
     * Le pixel lit le prochain mot dans le fichier et stocke sa valeure
     */
    public void lire(Scanner scanner);

    /**
     * @return Le string représentant la valeur du Pixel
     * @author Félix Barré
     *
     * Retourne la valeure en String du pixel
     */
    public String ecrire();

    /**
     * @param valeur Short valeur représentant les unités de luminosité à ajuster
     * @author Jasmin Dubuc
     *
     * Change la valeur du pixel pour ajuster la luminosité de l'image
     */
    public void eclaircir_noircir(short valeur);

    /**
     * @param listePixels Liste de Pixels à calculer
     * @return Retourne un pixel équivalent à la valeure moyenne de tous
     * @author Félix Barré
     *
     * Retourne la moyenne d'un ensemble de pixel incluant soi-même
     */
    public Pixel moyenne(List<Pixel> listePixels);
}
