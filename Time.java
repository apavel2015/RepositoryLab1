/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
/**
 *
 * @author User2
 */
class Time{
    public void Print(){
        Console console=System.console();
        console.printf("%d.%d.%d.%d:%d:%d", year,month,day,hour,minute,second);
    }
			public static boolean isNullTime(Time t){
				if(t.year==0 && t.month==0 && t.day==0 && t.hour==0 && t.minute==0 && t.second==0) return true;
				return false;
			}
			public static short Sravnit(Time first,Time second){
				if(first.year>second.year) return 1;
				if(first.year<second.year) return 2;
				if(first.month>second.month) return 1;
				if(first.month<second.month) return 2;
				if(first.day>second.day) return 1;
				if(first.day<second.day) return 2;
				if(first.hour>second.hour) return 1;
				if(first.hour<second.hour) return 2;
				if(first.minute>second.minute) return 1;
				if(first.minute<second.minute) return 2;
				if(first.second>second.second) return 1;
				if(first.second<second.second) return 2;
				return 0;
			}
			Time(String TimeS){
                            try{
				Pattern pattern=Pattern.compile("\\d+");
				Matcher matcher=pattern.matcher(TimeS);
				matcher.find();
				year=Integer.parseInt(matcher.group());
				matcher.find();
				month=Integer.parseInt(matcher.group());
				matcher.find();
				day=Integer.parseInt(matcher.group());
				matcher.find();
				hour=Integer.parseInt(matcher.group());
				matcher.find();
				minute=Integer.parseInt(matcher.group());
				matcher.find();
				second=Integer.parseInt(matcher.group());
                            }
                            catch(Throwable th){System.console().printf("ERR: "+TimeS);}
			}
			int year,month,day,hour,minute,second;
		}
