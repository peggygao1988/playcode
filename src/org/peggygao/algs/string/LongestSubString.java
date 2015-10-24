package org.peggygao.algs.string;

import java.util.HashMap;

public class LongestSubString
{

	public static String lss(String input)
	{

		int resultStart = 0;
		int resultEnd = 0;
		int maxLength = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int currentStart = 0;
		int currentEnd = 0;

		for (; currentEnd < input.length(); currentEnd++)
		{
			if (map.get(input.charAt(currentEnd)) == null)
			{
				map.put(input.charAt(currentEnd), currentEnd);
				// maxLength++;
			}
			else
			{

				 if (currentEnd - currentStart > maxLength)
				 {
				
				 resultStart = currentStart;
				 resultEnd = currentEnd;
				 maxLength = currentEnd - currentStart;
				 }

				/**
				 * TODO remove passed char from hashmap
				 */
				 currentStart = map.get(input.charAt(currentEnd)) + 1 > currentStart ? map.get(input.charAt(currentEnd)) + 1
				        : currentStart;
				map.put(input.charAt(currentEnd), currentEnd);
				
				
			}

		}
		if (currentEnd - currentStart > maxLength)
		{

			resultStart = currentStart;
			resultEnd = currentEnd;
			maxLength = currentEnd - currentStart;
		}
		return input.substring(resultStart, resultEnd);
	}

	public static void main(String[] args)
	{

		System.out.println(lss("abcdabacde"));
	}

}
