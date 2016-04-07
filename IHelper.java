
import java.util.ArrayList;

interface IHelper<T> {
	Boolean error=true;
	ArrayList<Object> elements=new ArrayList<Object>();
	public T Get(int index);
	public void Print(int index);
}
