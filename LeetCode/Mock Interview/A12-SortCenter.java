/*
Sort Center (LeetCode 01 Two Sum)
*/

/*
Input: truckSpace = 90, packagesSpace = [1,10,25,35,60]
Output: [2, 3]
Explaination: Given a truck of `90` space units, a list of packages space units `[1,10,25,35,60]`.
Your method should select the thrid(ID-2) and fouth (ID-3) package since you have to reserve exactly 30 space units.

Return a list of integers representing the IDs of two packages who combine space will leave exactly 30 space units on the truck.
*/

public int[] findTwoPackages(int truckSpace, List<Integer> packagesSpace){

	// 1. since we need to return index of two packages, we should choose other ways rather than sorting.
	// we don't know given packages is in ascending order or not.
	// (If we are given a sorted list, then just can easily solve it using two pointer)

	// 2. using hashmap to store <value, index> pair
	HashMap<Integer, Integer> hashmap = new HashMap<>();
	int target = truckSpace-30;

	for(int i=0; i<packagesSpace.size(); i++){
		int curr = packagesSpace.get(i);
		if(hashmap.containsKey(target-curr)){
			return new int[] {hashmap.get(target-curr), i};
		}
		hashmap.put(curr, i);
	}
	return new int[] {-1, -1}
}/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
