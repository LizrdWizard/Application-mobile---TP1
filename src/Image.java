public class Image {

    /**
     *
     * @param nomFichier
     */

    private Pixel[][] _pixel;

    private short _width;
    private short _height;
    private String _nomFichier;

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

    }

    /**
     * @param
     * @description:
     */
    public void copier(Image image) {

    }

    /**
     * @param
     * @description:
     */
    void eclaircir_noircir(int valeur) {

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
