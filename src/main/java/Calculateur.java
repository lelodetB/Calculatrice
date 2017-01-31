import java.util.ArrayList;

public class Calculateur {
	
	public ArrayList<Double> pile;
	
	private final String[] OPERATEUR = {"+","-","/","*","sqrt","carré","sin","tan","cos","inv","op","puiss"/*,"!"*/};
	
	public Calculateur(){
		this.pile = new ArrayList<Double>();
		
	}
	public boolean recevoir(String str){
		if(!isOperateur(str)){
			if(empiler(str)){
				return true;
			}
		}
		else{
			switch(str){
				case "+" :
					this.plus();
					break;
				case "-" :
					this.moin();
					break;
				case "/" :
					this.diviser();
					break;
				case "*" :
					this.multiplier();
					break;
				case "sqrt" :
					this.racineCarre();
					break;
				case "carré" :
					this.carre();
					break;
				case "sin" :
					this.sin();
					break;
				case "tan" :
					this.tan();
					break;
				case "cos" :
					this.cos();
					break;
				case "inv" :
					this.inv();
					break;
				case "op" :
					this.op();
					break;
				case "puiss" :
					this.puiss();
					break;/*
				case "!" :
					this.fact();
					break;*/	
					
			}
		}
		return false;
	}
	
	public boolean isOperateur(String str){
		for(int i=0;i<OPERATEUR.length;i++){
			if(str.equals(OPERATEUR[i])){
				return true;
			}
		}
		return false;
	}
	public boolean empiler(String str){
		try{
			this.pile.add(Double.parseDouble(str));
			System.out.println("empilage réussi, taille de la pile : "+ pile.size());
			return true;
		}
		catch(Exception e){
			System.out.println("empilage raté");
			return false;
		}
	}
	
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
	public Double sommet(){
		return pile.get(pile.size()-1);
	}
	public String toString(){
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
