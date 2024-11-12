package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut etre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			String[] nomVendeurs = controlAcheterProduit.rechercherNomsVendeursProduit(produit);
			if (nomVendeurs == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			} else {
				StringBuilder question = new StringBuilder("");
				question.append("Chez quel commerçant voulez-vous acheter des ");
				question.append(produit);
				question.append(" ?");
				for (int i = 0; i < nomVendeurs.length; i++) {
					question.append("\n");
					question.append(i+1);
					question.append(" - ");
					question.append(nomVendeurs[i]);
				}
				
				int choixUtilisateur;
				do {		
					choixUtilisateur = Clavier.entrerEntier(question.toString());
				} while (choixUtilisateur > nomVendeurs.length);
				String vendeur = nomVendeurs[choixUtilisateur-1];
				
				question.setLength(0);
				question.append(nomAcheteur);
				question.append(" se déplace jusqu'a l'étal du vendeur ");
				question.append(vendeur);
				question.append("...\nBonjour ");
				question.append(nomAcheteur);
				question.append("!\nCombien de ");
				question.append(produit);
				question.append(" voulez-vous acheter ?");
				
				int quantiteVoulue = Clavier.entrerEntier(question.toString());
				int quantiteAchetee = quantiteVoulue;
				
				quantiteAchetee = controlAcheterProduit.acheterProduit(vendeur, quantiteAchetee);
				
				StringBuilder chaine = new StringBuilder("");
				chaine.append(nomAcheteur);
				chaine.append(" veut acheter ");
				chaine.append(quantiteVoulue);
				chaine.append(" ");
				chaine.append(produit);
				chaine.append(", malheureusement ");
				if (quantiteAchetee == 0) {
					chaine.append("il n'y en a plus.");
				} else if (quantiteVoulue > quantiteAchetee) {
					chaine.append(vendeur);
					chaine.append(" n'en a plus que ");
					chaine.append(quantiteAchetee);
					chaine.append(". ");
					chaine.append(nomAcheteur);
					chaine.append(" achète tout le stock de ");
					chaine.append(vendeur);
				} else {
					chaine.setLength(0);
					chaine.append(nomAcheteur);
					chaine.append(" achète ");
					chaine.append(quantiteVoulue);
					chaine.append(" ");
					chaine.append(produit);
					chaine.append(" à ");
					chaine.append(vendeur);
				}
				System.out.println(chaine.toString());
			}
		}
	}
}