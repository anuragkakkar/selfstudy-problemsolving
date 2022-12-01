package leetcodequestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroOrOneLosses {

	public static void main(String[] args) {

		int[][] matches = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 },
				{ 10, 4 }, { 10, 9 } };
		System.out.println(findWinners(matches));

		matches = new int[][] { { 2, 3 }, { 1, 3 }, { 5, 4 }, { 6, 4 } };
		System.out.println(findWinners(matches));

		matches = new int[][] { { 26651, 85186 }, { 19790, 34845 }, { 20238, 59388 }, { 12788, 40994 },
				{ 46703, 28184 }, { 49936, 83960 }, { 76158, 33038 }, { 96005, 2100 }, { 86989, 72152 },
				{ 73342, 82931 }, { 90852, 54532 }, { 61649, 18655 }, { 9506, 73692 }, { 56189, 5503 },
				{ 34939, 78765 }, { 98315, 19818 }, { 57974, 42491 }, { 5906, 8266 }, { 97215, 95437 },
				{ 48266, 87323 }, { 86578, 82992 }, { 29919, 70323 }, { 38749, 98079 }, { 10259, 27750 },
				{ 977, 39147 }, { 43625, 38229 }, { 56044, 32634 }, { 53509, 13100 }, { 59446, 68045 }, { 38379, 7712 },
				{ 87511, 62110 }, { 35456, 508 }, { 76381, 89490 }, { 73270, 55169 }, { 82004, 20887 },
				{ 11239, 24195 }, { 56561, 57161 }, { 96112, 81582 }, { 20403, 76188 }, { 77876, 61782 },
				{ 99546, 39653 }, { 68650, 57489 }, { 27952, 11410 }, { 10595, 73394 }, { 98154, 49624 },
				{ 10866, 3758 }, { 70902, 97205 }, { 43360, 93218 }, { 59119, 82709 }, { 7379, 47660 }, { 76950, 1884 },
				{ 20120, 87138 }, { 23010, 5729 }, { 96553, 12208 }, { 70423, 36052 }, { 98588, 30989 },
				{ 87447, 24694 }, { 90748, 39031 }, { 17455, 13250 }, { 49557, 4501 }, { 99624, 72185 },
				{ 24791, 99744 }, { 80458, 57635 }, { 16175, 29359 }, { 53170, 83581 }, { 95936, 39348 },
				{ 5634, 95357 }, { 58517, 73348 }, { 54861, 34521 }, { 86692, 23939 }, { 11623, 85398 }, { 7562, 4748 },
				{ 13217, 29610 }, { 52705, 67263 }, { 95277, 68332 }, { 50498, 96263 }, { 18070, 33256 },
				{ 1901, 4237 }, { 11894, 97936 }, { 22135, 34362 }, { 7698, 64698 }, { 22893, 62847 }, { 2294, 14712 },
				{ 69996, 48778 }, { 340, 93723 }, { 42138, 33976 }, { 53231, 33755 }, { 29512, 501 }, { 81773, 58971 },
				{ 19189, 20321 }, { 30220, 37726 }, { 78678, 17938 }, { 79172, 26444 }, { 67695, 39219 },
				{ 23206, 40923 }, { 5651, 8928 }, { 49333, 29553 }, { 98589, 75052 }, { 99636, 94502 },
				{ 38455, 66022 }, { 3654, 56685 }, { 42118, 65465 }, { 83831, 62461 }, { 81301, 90996 },
				{ 35209, 23863 }, { 99223, 69931 }, { 5206, 42971 }, { 2143, 97501 }, { 91454, 60002 }, { 6307, 70975 },
				{ 48194, 6557 }, { 60125, 70237 }, { 60551, 85062 }, { 58731, 86177 }, { 98064, 94854 },
				{ 63923, 51970 }, { 87687, 36064 }, { 37926, 97759 }, { 87685, 22212 }, { 62051, 7149 },
				{ 1430, 13255 }, { 55928, 48428 }, { 8319, 99922 }, { 58503, 69220 }, { 45821, 70178 },
				{ 56815, 31101 }, { 77963, 7364 }, { 28828, 65658 }, { 92037, 99306 }, { 97928, 41984 },
				{ 47086, 73658 }, { 35491, 79727 }, { 24688, 42610 }, { 32304, 18289 }, { 52770, 31966 },
				{ 96613, 96122 }, { 73643, 49573 }, { 27623, 89143 }, { 62163, 93629 }, { 41018, 53285 },
				{ 59655, 4055 }, { 80777, 17295 }, { 9744, 38601 } };
		System.out.println(findWinners(matches));
	}

	private static List<List<Integer>> findWinners(int[][] matches) {

		List<List<Integer>> result = new ArrayList<>();

		HashMap<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < matches.length; i++) {
			map.put(matches[i][0], new int[] { 0, 0 });
			map.put(matches[i][1], new int[] { 0, 0 });
		}
		for (int i = 0; i < matches.length; i++) {
			map.put(matches[i][0], new int[] { ++map.get(matches[i][0])[0], map.get(matches[i][0])[1] });
			map.put(matches[i][1], new int[] { map.get(matches[i][1])[0], ++map.get(matches[i][1])[1] });
		}

		List<Integer> notLostAnyMatches = new ArrayList<>();
		List<Integer> lostExactlyOneMatch = new ArrayList<>();
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {

			if (entry.getValue()[0] > 0 && entry.getValue()[1] == 0) {
				notLostAnyMatches.add(entry.getKey());
			}
			if (entry.getValue()[0] >= 0 && entry.getValue()[1] == 1) {
				lostExactlyOneMatch.add(entry.getKey());
			}
		}
		Collections.sort(notLostAnyMatches);
		Collections.sort(lostExactlyOneMatch);
		result.add(notLostAnyMatches);
		result.add(lostExactlyOneMatch);
		return result;
	}

}
