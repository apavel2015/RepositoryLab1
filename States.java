import java.util.regex.*;
import java.io.*;
import java.util.*;
class States{
    private ArrayList<String> states;
    private ArrayList<Integer[]> messages;
    public int n(){return states.size();}
	States(String filename){
		ArrayList<String> Temp=new ArrayList<String>();
		String temp;
		try(FileReader fr=new FileReader(filename); BufferedReader br=new BufferedReader(fr)){
			while((temp=br.readLine())!=null){
                            Temp.add(temp);
                        }
		}
		catch(Exception ex){}
                try{Temp.remove(0);
                Temp.remove(Temp.size()-1);}
                catch(Throwable th){}
                Pattern pattern;
		Matcher matcher;
                Console console=System.console();
                ArrayList<Integer> temp2;
                states=new ArrayList<String>();
                messages=new ArrayList<Integer[]>();
                pattern=Pattern.compile("(\\w|\\s)+");
                Integer temp3;
                Integer[] temp4;
                for(int i=0;i<Temp.size();i++) {
                    matcher=pattern.matcher(Temp.get(i));
                    matcher.find();
                    states.add(matcher.group());
                    temp2=new ArrayList<Integer>();
                    try{
                        while(true){
                        matcher.find();
                        temp3=Integer.parseInt(matcher.group());
                        temp2.add(temp3);
                        }
                    }
                    catch(Throwable th){
                        temp4=new Integer[temp2.size()];
                        for(int j=0;j<temp4.length;j++) temp4[j]=temp2.get(j);
                        messages.add(temp4);
                    }
                }
	}
	public void PrintAll(){
            Integer[] temp;
            Console console=System.console();
            for(int i=0;i<states.size();i++){
                console.printf(states.get(i)+": ");
                temp=messages.get(i);
                for(int j=0;j<temp.length;j++) {
                    console.printf("%d", temp[j]);
                    if(j!=temp.length-1) console.printf(", ");
                    else console.printf("\n");
                }
                
            }
        }
        public String GetStateByTweetNumber(int number){
            Integer[] temparray;
            for(int i=0;i<messages.size();i++){
                temparray=messages.get(i);
                for(int j=0;j<temparray.length;j++){
                    if(temparray[j]==number) {return states.get(i);}
                }
            }
            return null;
        }
        public String GetState(int statenumber){
            return String.format(states.get(statenumber));
        }
        public Integer[] GetMessages(int statenumber){return messages.get(statenumber).clone();}
}
