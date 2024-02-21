import java.util.List;
import java.util.Scanner;

public class PixelNoirBlanc implements Pixel {

    private short _pixel;

    public PixelNoirBlanc() {
        _pixel = 0;
    }

    /**
     * @param       : Object Scanner en cours de lecture du fichier
     * @description : Le pixel lit le prochain mot dans le fichier et ajoute sa valeur à _pixel si c'est un short
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
     * @description : Retourne la valeur de _pixel
     */
    public String ecrire() {
        return String.valueOf(_pixel) + ' ';
    }

    /**
     * @param       : Short valeur représentant les unités de luminosité à ajuster
     * @description : Change la valeur de _pixel pour ajuster la luminosité de l'image
     */
    public void eclaircir_noircir(short valeur) {

        _pixel += valeur;

        if (_pixel < 0) {_pixel = 0;}
        if (_pixel > 255) {_pixel = 255;}
    }

    /**
     * @param       : Liste de Pixels
     * @description : Retourne la couleur moyenne de tous les Pixels dans l'image
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
