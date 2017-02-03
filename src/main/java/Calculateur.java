import java.util.ArrayList;

public class Calculateur {
	
	public ArrayList<Double> pile;
	
	private final String[] OPERATEUR = {"+","-","/","*","sqrt","carr�","sin","tan","cos","inv","op","puiss"/*,"!"*/}; // liste des op�rateurs disponibles dans le calculateur
	
	public Calculateur(){
		this.pile = new ArrayList<Double>(); // cr�ation de la pile
		
	}
	public boolean recevoir(String str){
		if(!isOperateur(str)){ // si la chaine recue n'est pas un op�rateur
			if(empiler(str)){ // on tente de l'empiler
				return true;
			}
		}
		else{
			switch(str){ // si la chaine est un op�rateur on trouve lequel, et lance le calcule
				case "+" :
					if(this.plus())
						return true;
					break;
				case "-" :
					if(this.moin())
					return true;
					break;
				case "/" :
					if(this.diviser())
					return true;
					break;
				case "*" :
					if(this.multiplier())
					return true;
					break;
				case "sqrt" :
					if(sommet()<0){
						return false;
					}
					if(this.racineCarre())
					return true;
					break;
				case "carr�" :
					if(this.carre())
					return true;
					break;
				case "sin" :
					if(this.sin())
					return true;
					break;
				case "tan" :
					if(this.tan())
					return true;
					break;
				case "cos" :
					if(this.cos())
					return true;
					break;
				case "inv" :
					if(this.inv())
					return true;
					break;
				case "op" :
					if(this.op())
					return true;
					break;
				case "puiss" :
				if(this.puiss())
					return true;
					break;/*
				case "!" :
					this.fact())
						return true;
					break;*/	
					
			}
		}
		return false;
	}
	
	public boolean isOperateur(String str){ // m�thode pour tester si une chaine est un op�rateur valide 
		for(int i=0;i<OPERATEUR.length;i++){
			if(str.equals(OPERATEUR[i])){
				return true;
			}
		}
		return false;
	}
	
	public boolean empiler(String str){ // on tente de convertire la chaine de caract�re en Double, puis de l'empiler
		try{
			this.pile.add(Double.parseDouble(str));
			return true;
		}
		catch(Exception e){
			System.out.println("empilage rat�");
			return false;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	// les m�thodes de calcules suivantes                                                //
	// r�cup�rent dans la pile le nombre d'op�randes n�cessaire � l'op�ration,           //
	// tentent d'effectuer l'op�ration demand�e ,                                        //
	// puis si cela r�ussi, supprimment les op�randes de la pile puis empile le r�sultat.//
	///////////////////////////////////////////////////////////////////////////////////////
	
	public boolean plus(){
		try{
			Double a = pile.get(pile.size()-1);
			Double b = pile.get(pile.size()-2);
			Double c = b + a ;
			pile.remove(pile.size()-1);
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean moin(){
		try{
			Double a = pile.get(pile.size()-1);
			Double b = pile.get(pile.size()-2);
			Double c = b - a ;
			pile.remove(pile.size()-1);
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean diviser(){
		try{
			Double a = pile.get(pile.size()-1);
			Double b = pile.get(pile.size()-2);
			if(a==0)return false;
			Double c = b / a ;
			pile.remove(pile.size()-1);
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean multiplier(){
		try{
			Double a = pile.get(pile.size()-1);
			Double b = pile.get(pile.size()-2);
			Double c = b * a ;
			pile.remove(pile.size()-1);
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean racineCarre(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c = Math.sqrt(a) ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean carre(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  a*a ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean sin(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  Math.sin(a) ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean tan(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  Math.tan(a) ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean cos(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  Math.cos(a) ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean inv(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  1/a ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean op(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  0-a ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public boolean puiss(){
		try{
			Double a = pile.get(pile.size()-1);
			Double b = pile.get(pile.size()-2);
			Double c =  Math.pow(b, a) ;
			pile.remove(pile.size()-1);
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/*public boolean fact(){
		try{
			Double a = pile.get(pile.size()-1);
			Double c =  Math. ;
			pile.remove(pile.size()-1);
			pile.add(c);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}*/
	public Double sommet(){ // retourne le sommet de la pile
		return pile.get(pile.size()-1);
	}
	
	public String toString(){ //affiche le contenue de la pile
		String str="";
		for(int i=0;i<=pile.size()-1;i++){
			str += "+--------";
		}
		str +="+\n";
		for(int i=0;i<=pile.size()-1;i++){
			
			str += "|" + String.format("%.6f",pile.get(i));
		}
		str += "|\n";
		for(int i=0;i<=pile.size()-1;i++){
			str += "+--------";
		}
		str +="+\n";
		return str;
	}
}
