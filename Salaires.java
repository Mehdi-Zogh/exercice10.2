import java.util.ArrayList;

class Salaires {
	public static void main(String[] args) {
		Personnel p = new Personnel();
		//Employe pierre=new Vendeur("Pierre", "Business", 45, 1995, 30000);
		//System.out.println(pierre.calculerSalaire());
		//Representant leon=new Representant("Léon", "Vendtout", 25, 2001, 20000);
		//System.out.println(leon.getNom());
		//System.out.println(leon.calculerSalaire());

		p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, 1995, 30000));
		p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, 2001, 20000));
		p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, 1998, 1000));
		p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, 1998, 45));
		p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, 2000, 1000));
		p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, 2001, 45));

		p.afficherSalaires();
		System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
	}
}
abstract class Employe{
	private String nom;
	private String prenom;
	private int age ;
	private int dateEntree ;

	public abstract double calculerSalaire() ;

	public String getNom(){
		return prenom+" "+nom;
	}
	Employe (String nom,String prenom,int age,int dateEntree){
		this.prenom=prenom;
		this.nom=nom;
		this.age=age;
		this.dateEntree=dateEntree;
	}
}

class Employe_Vente_Representation extends Employe{
	private double chiffre_affaire;
	private double seuil_salaire ;

	Employe_Vente_Representation(String nom,String prenom,int age,int dateEntree,double chiffre_affaire){
		super( nom, prenom, age, dateEntree);
		this.chiffre_affaire =chiffre_affaire;

	}
	public double calculerSalaire(){
		double salaire=0;
		salaire=(chiffre_affaire)*0.2 ;
		return salaire;
	}

	public double getSeuil_salaire() {
		return seuil_salaire;
	}
}

class Vendeur extends  Employe_Vente_Representation{

	Vendeur(String nom, String prenom, int age, int dateEntree, double chiffre_affaire) {
		super(nom, prenom, age, dateEntree, chiffre_affaire);
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire()+400;
	}

	@Override
	public String getNom() {
		return "Employe à la vente "+super.getNom();

	}
}

class Representant extends  Employe_Vente_Representation{

	Representant(String nom, String prenom, int age, int dateEntree, double chiffre_affaire) {
		super(nom, prenom, age, dateEntree, chiffre_affaire);
	}

	@Override
	public String getNom() {
		return "Employe à la representation "+super.getNom();
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire()+800;
	}
}

class Technicien extends Employe{

	private int nb_unites ;

	Technicien(String nom, String prenom, int age, int dateEntree, int nb_unites) {
		super(nom, prenom, age, dateEntree);
		this.nb_unites=nb_unites;
	}

	@Override
	public double calculerSalaire() {
		return nb_unites*5;
	}

	@Override
	public String getNom() {
		return "Employe à la production "+super.getNom();
	}
}

class Manutentionnaire extends Employe{
	private int nb_heures ;
	Manutentionnaire(String nom, String prenom, int age, int dateEntree, int nb_heures) {
		super(nom, prenom, age, dateEntree);
		this.nb_heures = nb_heures;
	}

	@Override
	public double calculerSalaire() {
		return nb_heures*65;
	}

	@Override
	public String getNom() {
		return "Employé à la manutention "+super.getNom();
	}
}

class TechnARisque extends Technicien implements A_risque{

	TechnARisque(String nom, String prenom, int age, int dateEntree, int nb_unites) {
		super(nom, prenom, age, dateEntree, nb_unites);
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire()+ bonus(400);
	}
}
class ManutARisque extends Manutentionnaire implements A_risque{

	ManutARisque(String nom, String prenom, int age, int dateEntree, int nb_heures) {
		super(nom, prenom, age, dateEntree, nb_heures);
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire()+ bonus(300);
	}
}


interface A_risque{
	default double bonus( double prime){
		return prime;
	}
}

class Personnel {
	private ArrayList <Employe> collection= new ArrayList<Employe>();


	public void ajouterEmploye(Employe person){
		collection.add(person);
	}
	public void afficherSalaires(){
		int nbEmployes= collection.size();
		for(int i=0; i<nbEmployes;i++){

			System.out.println(collection.get(i).getNom()+" gagne "+collection.get(i).calculerSalaire());
		}

	}

	public double salaireMoyen(){
		double moyenne=0;
		int nbEmployes= collection.size();
		//System.out.println("nb employes");
		//System.out.println(nbEmployes);
		for(int i=0; i<nbEmployes;i++){
			//System.out.println("salaire");
			moyenne+=collection.get(i).calculerSalaire();
			//System.out.println(collection.get(i).calculerSalaire());
			//System.out.println("somme:");
			//System.out.println(moyenne);
		}
		return moyenne/nbEmployes;
	}
}