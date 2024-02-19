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
     * @description: Extraire un sous ensemble de l’image à partir de du point p1,c1 jusqu’à p2,c2
     * @author : Joel Tidjane
     */
    public Image extraire(int x1, int y1, int x2, int y2) {
        int newWidht = x2 - x1 +1;
        int newHeight = y2 - y1 +1;

        Image nouvelleImage = new Image();
        nouvelleImage._width = (short) newWidht;
        nouvelleImage._height = (short) newHeight;
        nouvelleImage._pixel = new Pixel[newWidht][newHeight];

        for (int i = y1; i <= y2; i++) { //ligne
            for (int j = x1; j <= x2; j++) { //colonne
                nouvelleImage._pixel[i - y1][j - x1] = this._pixel[i][j];
            }
        }

        return nouvelleImage;

    }

    /**
     * @param
     * @description:
     */


    void reduire() {

    }

    /**
     * @param
     * @description: Détecte si les deux images sont identiques pixel par pixel.
     * @author : Joel Tidjane
     */
    public boolean estIdentique(Image image) {
        if(image._width != _width || image._height != _height){
            return false;
        }

        for(int i = 0; i<_height; i++){
            for(int j=0; j<_width; j++){
                if(!image._pixel[i][j].equals(_pixel[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @param
     * @description: Permet de tourner de 90 degrés l’image.
     * @author : Joel Tidjane
     */
    void pivoter90() {
        int newWidth = _height;
        int newHeight = _width;
        Pixel[][] newPixel = new Pixel[newHeight][newWidth];
        for(int i=0; i<_height;i++){
            for(int j=0; j<_width; j++){
                newPixel[j][(_height-1)-i]= _pixel[i][j];
            }
        }

        _width = (short) newWidth;
        _height = (short) newHeight;
        _pixel = newPixel;

    }
}
