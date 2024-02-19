//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * @author      :
 * @param       :
 * @description :
 */

public class Main {
    public static void main(String[] args) {
        ImageNoirBlanc imageNB = new ImageNoirBlanc("C:/Users/felix/Git/Application-mobile---TP1/src/Sherbrooke_Frontenac_nuit.pgm");

        imageNB.lire();
        
        ImageNoirBlanc copieimage = imageNB.extraire(50, 50, 100, 100);

        copieimage.ecrire();
    }
}