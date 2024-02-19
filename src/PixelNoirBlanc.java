import java.util.Scanner;

public class PixelNoirBlanc implements Pixel {

    private short _pixel;

    public PixelNoirBlanc() {
        _pixel = 0;
    }

    /**
     * @param       :
     * @description :
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
     * @param       :
     * @description :
     */
    public String ecrire() {
        return "";
    }

    /**
     * @param       :
     * @description :
     */
    public void eclaircir_noircir(short valeur) {

        _pixel += valeur;

        if (_pixel < 0) {_pixel = 0;}
        if (_pixel > 255) {_pixel = 255;}
    }
}
