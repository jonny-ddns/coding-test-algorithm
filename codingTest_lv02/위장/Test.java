package level02.����;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] clothes = null;
		clothes = new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		int count = s.solution(clothes);
		System.out.println(count);
		
		
//		//hashSet test 
//		Set<String> hashSet = new HashSet<String>();
//		Map<String, Integer> hashMap = new HashMap<>();
//				
//		String str1 = "ȫ�浿1";
//		String str2 = "ȫ�浿2";
//		String str3 = "ȫ�浿2";
//		String str4 = "ȫ�浿2";
//		String str5 = "ȫ�浿3";
//		
//		hashSet.add(str1);
//		hashSet.add(str2);
//		hashSet.add(str3);
//		hashSet.add(str4);
//		hashSet.add(str5);
//		
//		Iterator<String> i = hashSet.iterator();
//		while(i.hasNext()) {
//			String t = i.next();
//			System.out.println(t);
//		}
//		
//		System.out.println(hashSet.size());
//		
//		
//		
//		//hashMap test
//		hashMap.put("test1", 1);
//		hashMap.put("test2", 2);
//		hashMap.put("test3", 3);
//		hashMap.put("test1", 10);
//		hashMap.put("test1", 20);
//		
//		int test = hashMap.get("test1");
//		System.out.println(test);
			
	}
}
