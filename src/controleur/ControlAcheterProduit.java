
package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] rechercherNomsVendeursProduit(String produit) {
		String[] nomVendeurs = null;
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs != null) {
			nomVendeurs = new String[vendeurs.length];
			for (int i = 0; i < vendeurs.length; i++) {
				nomVendeurs[i] = vendeurs[i].getNom();
			}
		}
		return nomVendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int quantiteVoulue) {
		int quantiteAchetee;
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		quantiteAchetee = etalVendeur.acheterProduit(quantiteVoulue);
		return quantiteAchetee;
	}
}
