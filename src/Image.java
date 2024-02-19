import java.io.FileWriter;

public class Image {

    /**
     *
     * @param nomFichier
     */

    protected Pixel[][] _pixel;

    protected short _width;
    protected short _height;
    protected String _nomFichier;

    public Image() {}

    /**
     * @param
     * @description:
     */
    public Image(String nomFichier) {

        _pixel = null;
        _width = _height = 0;
        _nomFichier = nomFichier;
    }

    /**
     * @param
     * @description:
     */
    public void lire() {

    }

    /**
     * @param
     * @description:
     */
    public void ecrire() {
        try {
            FileWriter writer = new FileWriter(_nomFichier);

            for (int i = 0; i < _width; i++) {
                for (int j = 0; j < _height; j++) {
                    writer.write(_pixel[i][j].ecrire());
                }
            }

            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @description:
     */
    public void copier(Image image) {
        _nomFichier = image._nomFichier;
        _width = image._width;
        _height = image._height;
        _pixel = new Pixel[image._width][image._height];
        for (int i = 0; i < image._width; i++) {
            for (int j = 0; j < image._height; j++) {
                _pixel[i][j] = image._pixel[i][j];
            }
        }
    }

    /**
     * @param
     * @description:
     */
    void eclaircir_noircir(short valeur) {
        for (int i = 0; i < _width; i++) {
            for (int j = 0; j < _height; j++) {
                _pixel[i][j].eclaircir_noircir(valeur);
            }
        }
    }

    /**
     * @param
     * @description:
     */
    public Image extraire(int x1, int y1, int x2, int y2) {
        return this;
    }

    /**
     * @param
     * @description:
     */
    void reduire() {

    }

    /**
     * @param
     * @description:
     */
    void estIdentique(Image image) {

    }

    /**
     * @param
     * @description:
     */
    void pivoter90() {

    }
}
