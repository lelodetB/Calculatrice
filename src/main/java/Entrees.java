import java.util.Scanner;

public class Entrees {
	public static final String[] COMMANDE = {"trace","notrace","sommet","pile", "stop","help" };

	public static boolean trace = true;
	public static boolean stop = false;
	
	Calculateur calc;
	public static void main(String[] args) {
		
		new Entrees(args);
		
	}
	
	public Entrees(String[] args){
		calc=new Calculateur ();
		if(!(args.length == 0)){
			if(!evaluer(args[0]) ){
			System.out.println("votre calcul est éronné");	
			}
		}
		else{
			entree();
		}
	}
	
	public boolean evaluer(String arg){
		String[] calcul = arg.split(" "); 
		for(int i=0;i<calcul.length;i++){
			System.out.println(calcul[i]);
			if(!calc.recevoir(calcul[i])){
				return false;
			}
		}
		System.out.println(calc);
		return true;
	}
	
	public void entree(){

		Scanner sc = new Scanner(System.in);
		System.out.println("les opérateurs accéptés sont les suivants '+','-','/','*','sqrt','carré','sin','tan','cos','inv','op','puiss'.");
		System.out.println("'trace' pour activer le mode trace\n'notrace' pour le désactiver\n'sommet' pour afficher le sommet de la pile\n'pile' pour afficher la pile\n'stop'\n'help'pour afficher la liste des commandes");
		
		while(!stop){
			String str = sc.nextLine();
			if(!isCommande(str)){
				if(!calc.recevoir(str)){
					System.out.println("Erreur, votre chaine de caractère est incorrecte ou le calcul que vous tentez de faire est 'impossible'(exemple division par 0).");
				}
			}
			if(trace){
				System.out.println(calc);
			}
		}
		sc.close();
	}
	

	public boolean isCommande(String str){
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
						System.out.println("'trace' pour activer le mode\n'notrace' pour le désactiver\n'sommet' pour afficher le sommet de la pile\n'pile' pour afficher la pile\n'stop'\n'help'pour afficher la liste des commandes");
						break;
				}
				return true;
			}
		}
		return false;
	}
	

}
