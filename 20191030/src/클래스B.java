
public class 클래스B {
	
	int count = 0;
	int end = 1000;


	
	public 클래스B() {
	반복매소드();}


    public void 반복매소드() {
	count = count + 1;
	if(count > end) {return;}		
	System.out.println("매소드 호출 : " + count);
	반복매소드();
}

}
