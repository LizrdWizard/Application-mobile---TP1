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

    public PixelCouleur moyenne(PixelCouleur p1, PixelCouleur p2, PixelCouleur p3) {
        PixelCouleur pixelMoyen = new PixelCouleur();

        pixelMoyen._pixel[0] += (_pixel[0] + p1._pixel[0] + p2._pixel[0] + p3._pixel[0]) / 4;

        pixelMoyen._pixel[1] += (_pixel[1] + p1._pixel[1] + p2._pixel[1] + p3._pixel[1]) / 4;

        pixelMoyen._pixel[2] += (_pixel[2] + p1._pixel[2] + p2._pixel[2] + p3._pixel[2]) / 4;

        return pixelMoyen;
    }
}
