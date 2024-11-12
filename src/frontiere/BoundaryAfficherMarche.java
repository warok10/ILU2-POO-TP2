
package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marche est vide, revenez plus tard");
		} else {
			StringBuilder chaine = new StringBuilder("");
			chaine.append(nomAcheteur);
			chaine.append(", vous trouverez au marche :");
			String vendeur;
			String quantite;
			String produit;
			for (int i = 0; i < infosMarche.length; i += 3) {
				vendeur = infosMarche[i];
				quantite = infosMarche[i+1];
				produit = infosMarche[i+2];
				chaine.append("\n-");
				chaine.append(vendeur);
				chaine.append(" qui vend ");
				chaine.append(quantite);
				chaine.append(" ");
				chaine.append(produit);
			}
			System.out.println(chaine.toString());
		}
	}
}
