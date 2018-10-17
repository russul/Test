package testA;

public class TestString {
	public static void main(String args[]) {
		String s = "sjkdsfjksjsikjfjskfjkkjfkdfjsajsjsjsjfslksjjsj";

//		int times = timeS(s, "js");
//		System.out.print(times);
		TestString t =null;
		TestString t1=new TestString();
		System.out.println(t);
		System.out.println(t1);

	}

	public static int timeS(String s, String t) {
		int count[] = new int[s.length() + 1];
		int[] r = new int[s.length()];
		int j = 0;

		for (int i = 0; i < s.length(); i++) {

			r[j] = s.indexOf(t, count[j]);
			if (r[j] != -1) {
				count[j + 1] = r[j] + t.length();
				j++;
			}

		}
		return j;
	}
}
