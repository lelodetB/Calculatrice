import java.util.Scanner;

public class Entrees {
	public static final String[] COMMANDE = {"trace","notrace","sommet","pile", "stop","help" }; // liste des commandes disponnibles

	public static boolean trace = true;  // mode trace (affiche la pile � chaque �tape)
	public static boolean stop = false;  // condition d'arret du programme 
	
	Calculateur calc;
	public static void main(String[] args) {
		
		new Entrees(args);
		
	}
	
	public Entrees(String[] args){
		calc=new Calculateur ();
		if(!(args.length == 0)){ // si il y a un param�tre
			if(!evaluer(args[0].toLowerCase()) ){  //on essaye de d'�valuer la chaine de caract�res 
			System.out.println("votre calcul est �ronn�");	
			}
		}
		else{
			entree(); // si'l n'y a pas de param�tres on lance le mode entr�e 
		}
	}
	
	public boolean evaluer(String arg){  
		String[] calcul = arg.split(" "); // on s�pare la chaine de carat�res en sous chaines qui sont s�par�s par ' '  
		for(int i=0;i<calcul.length;i++){ 
			System.out.println(calcul[i]);
			if(!calc.recevoir(calcul[i])){ // on envoie chaque sous chaine au calculateur
				return false;
			}
		}
		System.out.println(calc);
		return true;
	}
	
	public void entree(){

		Scanner sc = new Scanner(System.in);
		System.out.println("les op�rateurs acc�pt�s sont les suivants '+','-','/','*','sqrt','carr�','sin','tan','cos','inv','op','puiss'.");
		System.out.println("'trace' pour activer le mode trace\n'notrace' pour le d�sactiver\n'sommet' pour afficher le sommet de la pile\n'pile' pour afficher la pile\n'stop'\n'help'pour afficher la liste des commandes");
		
		while(!stop){
			String str = sc.nextLine().toLowerCase(); // lecture d'une chaine de caract�re et passage de chaque caract�re en minuscule 
			if(!isCommande(str)){ // si cette chaine n'est pas une commande on l'envoie au calculateur
				if(!calc.recevoir(str)){
					System.out.println("Erreur, votre chaine de caract�re est incorrecte ou le calcul que vous tentez de faire est 'impossible'(exemple division par 0).");
				}
			}
			if(trace){ // si le mode trace est activ�
				System.out.println(calc);
			}
		}
		sc.close();
	}
	

	public boolean isCommande(String str){ // test si la chaine est une commande, si c'est le cas execute la commande
		for(int i=0;i<COMMANDE.length;i++){
			if(str.equals(COMMANDE[i])){
				switch(str){
					case "trace" :
						trace = true;
						break;
					case "notrace" :
						trace = false;
						break;
					case "sommet" :
						System.out.println("Sommet : "+calc.sommet());
						break;
					case "stop" :
						stop = true;
						break;
					case "pile" :
						System.out.println(calc);
						break;
					case "help" :
						System.out.println("'trace' pour activer le mode\n'notrace' pour le d�sactiver\n'sommet' pour afficher le sommet de la pile\n'pile' pour afficher la pile\n'stop'\n'help'pour afficher la liste des commandes");
						break;
				}
				return true;
			}
		}
		return false;
	}
	

}
