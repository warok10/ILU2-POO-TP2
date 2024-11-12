package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder questionForce = new StringBuilder();
					questionForce.append("Bienvenue villageois ");
					questionForce.append(nomVisiteur);
					questionForce.append("\nQuelle est votre force ?");
					int force = Clavier.entrerEntier(questionForce.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Bienvenue druide ");
		questionForce.append(nomVisiteur);
		questionForce.append("\nQuelle est votre force ?");
		int forceDruide = Clavier.entrerEntier(questionForce.toString());
		int effetPotionMin = 0;
		int effetPotionMax = -1;
		while (effetPotionMax < effetPotionMin) {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide, vous vous êtes trompé entre le minimum et le maximum !");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}