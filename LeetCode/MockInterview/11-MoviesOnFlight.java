/*
Movies on Flight (1099. Two Sum Less Than K)
*/

/*
You are on a flight and wanna watch two movies during this flight.
You are given int[] movie_duration which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

Input: movie_duration = [90, 85, 75, 60, 120, 150, 125], d = 250
Output: [90, 125]
Explanation: 90min + 125min = 215 is the maximum number within 220 (250min - 30min)
*/

public int[] findMaxTwoMovies(int[] movie_duration, int d){
	//maximum movie duration - 30mins
	int target = d-30;

	Arrays.sort(movies);
	int start=0, end=movies.length-1;
    int max = Integer.MIN_VALUE;
	int[] ret = new int[2];

	while(start < max){
		currDuration = movie_duration[start] + movie_duration[end];
		if(currDuration == target){
			ret[0] = movie_duration[start], ret[1] = movie_duration[end];
			return ret;
		}

		else if(currDuration < target){
			max = Math.max(max, currDuration);
			ret[0] = movie_duration[start], ret[1] = movie_duration[end];
			start++;
		}
		else { // currDuration > target
			end--;
		}
	}
	if(max == Integer.MIN_VALUE) return new int {-1, -1};
	return ret;
}



// LeetCode 1099
class Solution {
    public int twoSumLessThanK(int[] A, int K) { 
        Arrays.sort(A);
        int start=0, end=A.length-1;
        int max = Integer.MIN_VALUE;
        
        while(start < end){
            int curr = A[start] + A[end];
            if(curr < K){
                max = Math.max(max, curr);
                start++;
            } else { // curr >= K
                end--;
            }
        }
        if(max==Integer.MIN_VALUE) return -1;
        
        return max;
    }
}
