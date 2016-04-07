import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Main {
public static void Hashtag(AllTweets tweets,Console console){
    
    console.printf("Введите хешгэг:\n");
    String tag=console.readLine();
    ArrayList<Integer> list=tweets.have_hashtag(tag);
    if(list==null) console.printf("Нету совпадений\n");
    else {
        console.printf("Совпадения:\n");
        for(int i=0;i<list.size();i++)
        {
            tweets.Print(list.get(i));
            console.printf("\n");
        }
        }
}
public static void EmoVes(AllTweets tweets,Console console){
    String Ot,Do;
    console.printf("Введите промежуток времени (в формате YYYY.MM.DD.HH:MM:SS):\nОт:\n");
    Ot=console.readLine();
    console.printf("До:\n");
    Do=console.readLine();
    int ves=tweets.EmotionsInTime(new Time(Ot),new Time(Do));
    console.printf("Искомый вес: %d\n",ves);
}
public static void MostTweetsFromOneState(AllTweets tweets,Console console){
    String Ot,Do;
    console.printf("Введите промежуток времени (в формате YYYY.MM.DD.HH:MM:SS):\nОт:\n");
    Ot=console.readLine();
    console.printf("До:\n");
    Do=console.readLine();
    String state=tweets.MostTweets(new Time(Ot),new Time(Do));
    if(state==null) console.printf("Нет твитов в заданный промежуток времени\n");
    else console.printf("Штат: "+state+"\n");
}
public static void PrintAllTweets(AllTweets tweets,Console console){
    int n=tweets.n();
    for(int i=0;i<n;i++){
        console.printf("<<<<<\nТвит №%d\nТекст:\n",i+1);
        tweets.Print(i);
        console.printf("\nДата и время отправки: ");
        tweets.Get(i).Time.Print();
        console.printf("\nЭмоциональный вес: ");
        tweets.sentiments.Print(i);
        console.printf("\nШтат отправителя: "+tweets.states.GetStateByTweetNumber(i)+"\n>>>>>\n");
    }
}
	public static void main(String[] args) {
		
		AllTweets tweets=new AllTweets("D:\\Users\\User2\\Documents\\NetBeansProjects\\JavaApplication1\\src\\all_tweets.txt",
				"D:\\Users\\User2\\Documents\\NetBeansProjects\\JavaApplication1\\src\\sentiments.csv",
				"D:\\Users\\User2\\Documents\\NetBeansProjects\\JavaApplication1\\src\\states.json");
		Console console=System.console();
                
                Integer K;
                do{
                System.out.println("Выберите:");
                
                console.printf("1.Вывести все твиты и информацию о них\n");
                console.printf("2.Определить все твиты, содержащие хештэг\n");
                console.printf("3.Определить суммарный эмоц. вес твитов в зад. пром. времени\n");
                console.printf("4.Определить штат с наиб. кол. твитов\n");
                console.printf("0.Выход\n");
                K=Integer.parseInt(console.readLine());
                if(K==1) PrintAllTweets(tweets,console);
                if(K==2) Hashtag(tweets,console);
                if(K==3) EmoVes(tweets,console);
                if(K==4) MostTweetsFromOneState(tweets,console);
                }
                while(K!=0);
	}

}
