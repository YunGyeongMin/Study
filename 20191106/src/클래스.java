
public class 클래스 {

	public static void main(String[] args) {
	
		 String 도형 = "■";

		int cnt = 1;
		int size = 3;
		 

		for(int i = 0; i < 9; i++){
			if(cnt > size) break;
			for(int j = 0; j <= i; j++){
				if((9 - i) <= j) break;
				
			System.out.print(도형);}
			System.out.println("");
			if(i >= 8) {
			i =1;
			cnt++;
		}
		}
		
      
//		
//		System.out.println(도형);
//		System.out.println(도형+도형);
//		System.out.println(도형+도형+도형);
//		System.out.println(도형+도형+도형+도형);
//		System.out.println(도형+도형+도형+도형+도형);
//		System.out.println(도형+도형+도형+도형);
//		System.out.println(도형+도형+도형);
//		System.out.println(도형+도형);
//		System.out.println(도형);					
}
}
