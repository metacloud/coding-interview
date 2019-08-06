/*
Substrings of size K with K distinct chars
*/

/*
Input: str = "awaglknagawunagwkwagl", k = 4
Output: [wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag]
Explanation: 
Substrings in order are: wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag, wagl 
"wagl" is repeated twice, but is included in the output once.
*/

public Solution {
	public List<String> distinctK(String s, int k){
		List<String> ret = new ArrayList<>();
		if(s==null || s.length()==0 || s.length() < k) return ret;

		//<char,Index>
		Map<Character, Integer> map = new HashMap<>();

		int start=0;
		for(int end=0; end<s.length(); end++){
			char added = s.charAt(end);

			if(map.containsKey(added)){
				start = Math.max(map.get(added)+1, start);
			}
			map.put(added, end);
			int len = end-start+1;
			if(len==k){
				String str = s.substring(start, end+1);
				if(!ret.contains(str)) ret.add(str);
				start++;
			}
		}
		return ret;
	}
}