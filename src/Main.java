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
        ImageNoirBlanc copie = new ImageNoirBlanc();

        imageNB.lire();
        imageNB.pivoter90();
        imageNB.eclaircir_noircir((short)50);

        //imageNB.ecrire();

        imageCouleur.lire();
        System.out.println(imageCouleur.couleur_preponderante());
        //imageCouleur.ecrire();

        imageCouleur.reduire();
        imageCouleur.ecrire();

        imageCouleur.pivoter90();
        imageCouleur.pivoter90();
        imageCouleur.eclaircir_noircir((short)-100);
        //imageCouleur.ecrire();

        copie.copier(imageNB);

        System.out.println("Est égale : " + copie.estIdentique(imageNB));

        copie.pivoter90();
        System.out.println("Est égale (après modif) : " + copie.estIdentique(imageNB));
        //copie.ecrire();

        ImageCouleur extrait = new ImageCouleur();
        //extrait = imageCouleur.extraire(10, 10, 100, 30);
        //extrait.ecrire();
    }
}