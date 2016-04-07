
import java.io.*;
import java.util.*;
class Sentiments implements IHelper<Integer> {
	Boolean error=true;
	private ArrayList<Integer> elements;
        public int n(){return elements.size();}
	Sentiments(String filename){
		String temp;
		int t;
		elements=new ArrayList<Integer>();
		try(FileReader fr=new FileReader(filename); BufferedReader br=new BufferedReader(fr)){
			while((temp=br.readLine())!=null) {
				try{t=Integer.parseInt(temp);
				elements.add(t);}
				catch(Throwable th){}
                                    
				}
		}
		catch(Exception ex){}
		error=false;
	}
	public Integer Get(int index){
		try{return elements.get(index);}
		catch(Throwable th){return -1;}
	}
	public void Print(int index){
		Console console=System.console();
		try{console.printf("%d",elements.get(index));}
		catch(Throwable th){console.printf("False index");}
	}
}
