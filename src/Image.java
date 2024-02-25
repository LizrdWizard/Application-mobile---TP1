import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

/**
 * Classe mère image
 */
public class Image {
    protected Pixel[][] _pixel;

    protected short _width;
    protected short _height;
    protected String _nomFichier;

    /**
     * @author Félix Barré
     *
     * Constructeur sans paramètre
     */
    public Image() {
        _pixel = null;
        _width = _height = 0;
        _nomFichier = "";
    }

    /**
     * @param nomFichier Chemin du fichier
     * @author Félix Barré
     *
     * Constructeur avec paramètre
     */
    public Image(String nomFichier) {

        _pixel = null;
        _width = _height = 0;
        _nomFichier = nomFichier;
    }

    /**
     * @param type Type d'image écrit au début du fichier
     * @author Félix Barré
     *
     * Écrit l'image dans un fichier
     */
    public void ecrire(String type) {
        try {
            FileWriter writer = new FileWriter(_nomFichier);

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

    /**
     * @param typeVoulu Le type qui devrait être écrit au début du fichier lu
     * @author Félix Barré
     *
     * Va lire l'image dans un fichier
     */
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
     * @param image Image à copier
     * @author Félix Barré
     *
     * Copie l'entièreté du contenu d'une image
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
     * @param valeur Valeur appliquée à l'image
     * @author Félix Barré
     *
     * Éclaircir ou noircir l'image selon la valeur passée en paramètre
     */
    public void eclaircir_noircir(short valeur) {
        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                _pixel[i][j].eclaircir_noircir(valeur);
            }
        }
    }

    /**
     * @param image Image à comparer
     * @return Retourne une valeur booléenne (true si les images sont identiques)
     * @author Joel Tidjane
     *
     * Détecte si les deux images sont identiques pixel par pixel.
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
     * @author      : Joel Tidjane
     *
     * Permet de tourner de 90 degrés l’image.
     */
    public void pivoter90() {
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

    /**
     * @author Félix Barré
     *
     * Réduit la résolution de l'image de moitié
     */

    public void reduire() {
        int newHeight = _height / 2;
        int newWidth = _width / 2;


        Pixel[][] pixel = new Pixel[newHeight][newWidth];

        for (int i = 0; i < _height; i += 2) {
            for (int j = 0; j < _width; j += 2) {
                List<Pixel> listePixels = new ArrayList<Pixel>();

                if (j + 1 < _width && i + 1 < _height) {
                    listePixels.add(_pixel[i + 1][j + 1]);
                }

                if (j + 1 < _width) {
                    listePixels.add(_pixel[i][j + 1]);
                }

                if (i + 1 < _height) {
                    listePixels.add(_pixel[i + 1][j]);
                }


                pixel[i / 2][j / 2] = _pixel[i][j].moyenne(listePixels);
            }
        }

        _pixel = pixel;
        _height = (short)newHeight;
        _width = (short)newWidth;
    }

    /**
     * @author Jasmin Dubuc
     * @return Retourne une copie du Pixel le plus commun
     *
     * Trouve le pixel le plus commun dans l'image
     * */
   public Pixel couleur_preponderante() {

       HashMap<Pixel, Integer> myMap = new HashMap<Pixel, Integer>();
       HashMap.Entry<Pixel, Integer> maxEntry = null;
       Integer count;

       for (int i = 0; i < _height; i++) {
           for (int j = 0; j < _width; j++) {

               if (!myMap.containsKey(_pixel[i][j])) {
                   myMap.put(_pixel[i][j], 1);
               }
               else {
                   count = myMap.get(_pixel[i][j]);
                   myMap.put(_pixel[i][j], count + 1);
               }
           }
       }

       for (HashMap.Entry<Pixel, Integer> entry : myMap.entrySet()) {

           if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
               maxEntry = entry;
           }
       }

       return maxEntry.getKey();
   }
}