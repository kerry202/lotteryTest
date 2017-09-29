package app.wyth.com.mydemo;

/**
 * @author yangbo
 * @qq	903023560
 */
public class MathC{

	public static int number(int red,int blue){
		int re=c(red,6)*blue;
		return re;
	}
	

	public static int c(int n, int m){
		return chengfa(n, m)/jiecheng(m);
	}
	
	private static int jiecheng(int p){
		int a = 1;
		for(int i = 1; i < p+1; i++){
			a = i * a;
		}
		return a;
	}

	private static int chengfa(int b,int c){
		int d = 1;
		for(int i = b; i > b-c; i--){
			d = i * d;
		}
		return d;
	}	
}
