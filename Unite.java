class  Unite  {
	private  boolean  enVie;
	private  int  pointsDeVie;
}

class  Hache  {}

class  Arc  {}

interface  Nain  {
	default void frappeAvecHache() {

	}

	final Hache hache= new Hache() ;
}

interface  Elfe  {

	final Arc arc=new Arc();
	default void tireFleche(){

	}
}

interface  Magicien  {
	default void lanceSort() {

	}
}

interface  Cavalier  {
	default void chevauche() {

	}
}

class  NainMagicien extends  Unite  implements Nain,  Magicien  {
	private  int  taille;

}

class  NainCavalier   extends  Unite  implements  Nain,  Cavalier  {
	private  int  taille;

}

class  ElfeMagicien   extends  Unite  implements  Elfe,  Magicien  {
	private  int  poids;

}

class  ElfeCavalier extends  Unite  implements Elfe,  Cavalier  {
	private  int  poids;

}