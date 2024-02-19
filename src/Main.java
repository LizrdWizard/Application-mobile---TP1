//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * @author      :
 * @param       :
 * @description :
 */

public class Main {
    public static void main(String[] args) {
        ImageCouleur imageNB = new ImageCouleur("C:/Users/felix/Git/Application-mobile---TP1/src/Sherbrooke_Frontenac_nuit.ppmcopie.ppm");

        imageNB.lire();

        imageNB.pivoter90();

        imageNB.ecrire();
    }
}