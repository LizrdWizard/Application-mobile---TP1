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
        return "";
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
}
