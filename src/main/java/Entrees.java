
public class Entrees {

	Calculateur calc;
	public static void main(String[] args) {
		new Entrees(args);
		
	}
	
	public Entrees(String[] args){
		calc=new Calculateur ();
		if(args[0] !=null){
			if(!evaluer(args[0]) ){
			System.out.println("votre calcul est éronné");	
			}
		}
		else{
			
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

}
