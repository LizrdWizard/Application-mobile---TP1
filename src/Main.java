//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * @author      :
 * @param       :
 * @description :
 */

public class Main {
    public static void main(String[] args) {
        ImageNoirBlanc imageNB = new ImageNoirBlanc(System.getProperty("user.dir") + "/src/Sherbrooke_Frontenac_nuit.pgm");
        ImageCouleur imageCouleur = new ImageCouleur(System.getProperty("user.dir") + "/src/Sherbrooke_Frontenac_nuit.ppm");
    }
}