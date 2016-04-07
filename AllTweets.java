import java.io.*;
import java.util.*;
import java.util.regex.*;

class AllTweets implements IHelper {
        
        public int n(){return elements.size();}
	class Tweet{
                String inputstring;
		String text;
		Time Time;
		Tweet(String input){
                    inputstring=input;
			Pattern pattern=Pattern.compile("((\\s|\\S)*\")|(:(\\s|\\S)*)");
			Matcher matcher=pattern.matcher(input);
			matcher.find();
			text=matcher.group();
			text=text.substring(1,text.length()-1);
			matcher.find();
			Time=new Time(matcher.group());
		}
		
	}
	public Sentiments sentiments;
	public States states;
        private ArrayList<Tweet> elements=null;
        
	Boolean error=true;
	public Boolean IsError(){return error;}
	
	public int EmotionsInTime(Time Start,Time End){
		int S=-1,E=-1;
                int n=elements.size();
                if(Time.Sravnit(Start, End)==1) return 0;
                int i;
                if(Time.Sravnit(Start,elements.get(0).Time)==0 || 
                        Time.Sravnit(Start,elements.get(0).Time)==2) S=0;
                else{
                for(i=1;i<n;i++){
                    if(Time.Sravnit(Start,elements.get(i).Time)==0) break;
                    if(Time.Sravnit(Start, elements.get(i).Time)==1) break;
                }
                S=i;
                if(i==n) return 0;
                if(i==n-1) return sentiments.Get(i);
                }
                if(Time.Sravnit(End,elements.get(0).Time)==0) E=0;
                if(Time.Sravnit(End, elements.get(0).Time)==2) return 0;
                if(E==-1){
                for(i=1;E==-1 && i<n;i++){
                    if(Time.Sravnit(End,elements.get(i).Time)==0) break;
                    if(Time.Sravnit(End, elements.get(i).Time)==2) {i--;break;}
                }
                E=i;
                if(E==n) E--;
                }
                int sum=0;
                for(i=S;i<=E;i++) sum+=sentiments.Get(i);
                return sum;
	}
	AllTweets(String tweets,String sent,String st){
		Tweet TEMP;
		String temp;
		elements=new ArrayList<Tweet>();
		try(FileReader fr=new FileReader(tweets); BufferedReader br=new BufferedReader(fr)){
			while((temp=br.readLine())!=null) {
				TEMP=new Tweet(temp);
				elements.add(TEMP);}
		}
		catch(Exception ex){}
		error=false;
		sentiments=new Sentiments(sent);
		states=new States(st);
	}
        public String MostTweets(Time Start,Time End){
            int S=-1,E=-1;
                int n=elements.size();
                if(Time.Sravnit(Start, End)==1) return null;
                int i;
                if(Time.Sravnit(Start,elements.get(0).Time)==0 || 
                        Time.Sravnit(Start,elements.get(0).Time)==2) S=0;
                else{
                for(i=1;i<n;i++){
                    if(Time.Sravnit(Start,elements.get(i).Time)==0) break;
                    if(Time.Sravnit(Start, elements.get(i).Time)==1) break;
                }
                S=i;
                if(i==n) return null;
                }
                if(Time.Sravnit(End,elements.get(0).Time)==0) E=0;
                if(Time.Sravnit(End, elements.get(0).Time)==2) return null;
                if(E==-1){
                for(i=1;E==-1 && i<n;i++){
                    if(Time.Sravnit(End,elements.get(i).Time)==0) break;
                    if(Time.Sravnit(End, elements.get(i).Time)==2) {i--;break;}
                }
                E=i;
                if(E==n) E--;
                }
                ArrayList<Integer> list=new ArrayList<Integer>();
                n=states.n();
                int sum;
                Integer[] temp;
                for(i=0;i<n;i++){
                    sum=0;
                    temp=states.GetMessages(i);
                    for(int j=0;j<temp.length;j++){
                        if(temp[j]>=S && temp[j]<=E) sum++;
                    }
                    list.add(sum);
                }
                int max=0;
                for(i=0;i<n;i++) if(list.get(i)>list.get(max)) max=i;
                return states.GetState(max);
	}
	public Tweet Get(int index){
            /*
		try{return elements.get(index);}
		catch(Throwable th){return null;}*/
            try{
            return new Tweet(elements.get(index).inputstring);
            }
            catch(Throwable th){return null;}
            
	}
	public void Print(int index){
		Console console=System.console();
		try{console.printf((elements.get(index)).text);}
		catch(Throwable th){console.printf("False index");}
	}
	public ArrayList<Integer> have_hashtag(String tag){
		Pattern pattern=Pattern.compile(tag);
		ArrayList<Integer> indexes=new ArrayList<Integer>();
		for(int i=0;i<elements.size();i++){
			if(pattern.matcher(elements.get(i).text).find()==true) indexes.add(i);
		}
		if(indexes.isEmpty()) return null;
		return indexes;
		
	}
	
}