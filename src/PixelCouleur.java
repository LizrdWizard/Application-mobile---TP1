import java.util.List;
import java.util.Scanner;

public class PixelCouleur implements Pixel {

    private short[] _pixel;

    private static final short _size = 3;

    public PixelCouleur() {
        _pixel = new short[_size];
    }

    /**
     * @param       : Object Scanner en cours de lecture du fichier
     * @description : Le pixel lit le prochain mot dans le fichier et ajoute sa valeur à _pixel si c'est un short
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
     * @description : Retourne les trois valeur de _pixel
     */
    public String ecrire() {
        String sortie = "";

        for (int i = 0; i < _size; i++) {
            sortie += _pixel[i] + " ";
        }
        return sortie;
    }

    /**
     * @param       : Short valeur représentant les unités de luminosité à ajuster
     * @description : Change les trois valeurs de _pixel pour ajuster la luminosité de l'image
     */
    public void eclaircir_noircir(short valeur) {

        for (int i = 0; i < _size; i++) {
            _pixel[i] += valeur;

            if (_pixel[i] < 0) {_pixel[i] = 0;}
            if (_pixel[i] > 255) {_pixel[i] = 255;}

        }
    }

    /**
     * @param       : Liste de Pixels
     * @description : Retourne la couleur moyenne de tous les Pixels dans l'image
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
