package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
			if (etalOccupe) {
				String produit = donneesEtal[2];
				int quantiteInitial = Integer.parseInt(donneesEtal[3]);
				int quantiteVendu = Integer.parseInt(donneesEtal[4]);
				StringBuilder chaine = new StringBuilder("");
				chaine.append("Vous avez vendu ");
				chaine.append(quantiteVendu);
				chaine.append(" sur ");
				chaine.append(quantiteInitial);
				chaine.append(" ");
				chaine.append(produit);
				chaine.append(".\nAu revoir ");
				chaine.append(nomVendeur);
				chaine.append(", passez une bonne journée.");
				System.out.println(chaine.toString());
			}
		}
	}

}