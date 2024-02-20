import java.util.List;
import java.util.Scanner;

public class PixelCouleur implements Pixel {

    private short[] _pixel;

    private static final short _size = 3;

    public PixelCouleur() {
        _pixel = new short[_size];
    }

    /**
     * @param
     * @description:
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
     * @param
     * @description:
     */
    public String ecrire() {
        String sortie = "";

        for (int i = 0; i < _size; i++) {
            sortie += _pixel[i] + " ";
        }
        return sortie;
    }

    /**
     * @param
     * @description:
     */
    public void eclaircir_noircir(short valeur) {

        for (int i = 0; i < _size; i++) {
            _pixel[i] += valeur;

            if (_pixel[i] < 0) {_pixel[i] = 0;}
            if (_pixel[i] > 255) {_pixel[i] = 255;}

        }
    }

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
