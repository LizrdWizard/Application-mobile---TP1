import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Image {

    /**
     *
     * @param nomFichier
     */

    protected Pixel[][] _pixel;

    protected short _width;
    protected short _height;
    protected String _nomFichier;

    public Image() {
        _pixel = null;
        _width = _height = 0;
        _nomFichier = "";
    }

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
    public void ecrire(String type) {
        String nouveauNom = _nomFichier + "copie";

        if (type.equals("P3")) {
            nouveauNom += ".ppm";
        }
        else if (type.equals("P2")) {
            nouveauNom += ".pgm";
        }

        try {

            FileWriter writer = new FileWriter(nouveauNom);

            writer.write(type + "\n" + _width + " " + _height + "\n255\n");

            for (int i = 0; i < _height; i++) {
                for (int j = 0; j < _width; j++) {
                    writer.write(_pixel[i][j].ecrire());
                }
                writer.write("\n");
            }

            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lire(String typeVoulu) {
        try {
            Scanner scanner = new Scanner(new FileReader(_nomFichier));

            if (!scanner.hasNext()) {
                throw new Exception("Type d'image non trouvé");
            }

            String type = scanner.next();

            if (!typeVoulu.equals(type)) {
                throw new Exception("Mauvais type d'image en lecture");
            }

            if (!scanner.hasNextShort()) {
                throw new Exception("Largeur non trouvée");
            }
            _width = scanner.nextShort();

            if (!scanner.hasNextShort()) {
                throw new Exception("Hauteur non trouvée");
            }
            _height = scanner.nextShort();

            if (!scanner.hasNextShort()) {
                throw new Exception("Chiffre 255 non trouvé");
            }
            scanner.nextShort();

            _pixel = new Pixel[_height][_width];


            for (int i = 0; i < _height; i++) {
                for (int j = 0; j < _width; j++) {

                    if(typeVoulu.equals("P3")) {
                        _pixel[i][j] = new PixelCouleur();
                    } else if (typeVoulu.equals("P2")) {
                        _pixel[i][j] = new PixelNoirBlanc();
                    }

                    _pixel[i][j].lire(scanner);
                }
            }
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
        _pixel = new Pixel[image._height][image._width];
        for (int i = 0; i < image._height; i++) {
            for (int j = 0; j < image._width; j++) {
                _pixel[i][j] = image._pixel[i][j];
            }
        }
    }

    /**
     * @param
     * @description:
     */
    void eclaircir_noircir(short valeur) {
        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                _pixel[i][j].eclaircir_noircir(valeur);
            }
        }
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
        for(int i=0; i < _height;i++){
            for(int j=0; j<_width; j++){
                newPixel[j][_height - 1 - i]= _pixel[i][j];
            }
        }

        _width = (short) newWidth;
        _height = (short) newHeight;
        _pixel = newPixel;

    }
}
