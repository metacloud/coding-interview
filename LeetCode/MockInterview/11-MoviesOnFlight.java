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
	int m1=0, m2=0;

	while(start < max){
		currDuration = movie_duration[start] + movie_duration[end];
		if(currDuration == target){
			return new int[] {movie_duration[start], movie_duration[end]};
		}
		else if(currDuration < target){
			m1 = movie_duration[start];
			m2 = movie_duration[end];
			start++;
		}
		else { // currDuration > target
			end--;
		}
	}
	if(m1 == m2) return new int[] {-1, -1};
	return new int[] {m1, m2};
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
