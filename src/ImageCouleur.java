import java.io.FileReader;
import java.util.Scanner;

public class ImageCouleur extends Image {
    public ImageCouleur(String nomFichier) {
        super(nomFichier);
    }

    public void lire() {
        try {
            Scanner scanner = new Scanner(new FileReader(_nomFichier));

            if (!scanner.hasNext()) {
                throw new Exception("Type d'image non trouvé");
            }

            String type = scanner.next();

            if (!"P3".equals(type)) {
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

            _pixel = new Pixel[_width][_height];

            for (int i = 0; i < _width; i++) {
                for (int j = 0; j < _height; j++) {
                    _pixel[i][j] = new PixelCouleur();
                    _pixel[i][j].lire(scanner);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
