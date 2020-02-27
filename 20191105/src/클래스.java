
public class 클래스 {

	public static void main(String[] args) {
		
		String a = "일어난다.";
		String b = "씻는다.";
		String c = "밥 먹는다.";
		String d = "출근한다.";
		String e = "퇴근한다.";
		String f = "쉰다.";
		String 조합값 = "";
		
		boolean 유형 = true;  // true (밥 먹는 사람) / false (밥 먹지 않는 사람)
		boolean 유형1 = false;  // true (씻는사람) / false (안씻는사람)
		boolean 유형2 = true;  // true (쉬는사람) / false (출근하는사람)
		
		switch (1) {
		case 1:
			조합값 += a;
			if(유형2) {
				System.out.println(f);
				break;
			}
//			System.out.println(조합값);
		case 2:
			if(유형1) {
			조합값 += b;}
//			System.out.println(조합값);
		case 3:
			if(유형) {
				조합값 += c;
			}
//			System.out.println(조합값);
		case 4:
			조합값 += d;
//			System.out.println(조합값);
		case 5:
			조합값 += e;
//			System.out.println(조합값);			
		default:						
			System.out.println(조합값);
	}
	}
}
