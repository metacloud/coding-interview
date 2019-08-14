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
		for(int i=0; i<s.length(); i++){
			char curr = s.charAt(i);

			if(map.containsKey(curr)){
				start = Math.max(map.get(curr)+1, start);
			}
			map.put(curr, i);
			if(i-start+1==k){
				String substr = s.substring(start, i+1);
				if(!ret.contains(substr)) ret.add(substr);
				start++;
			}
		}
		return ret;
	}
}
