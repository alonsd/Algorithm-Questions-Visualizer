package com.alqoview.data.source

import com.alqoview.model.AlgorithmicProblem

val leetcode13 = AlgorithmicProblem(
    problemId = 13,
    questionNumber = 13,
    title = "Roman to Integer",
    problemDescription = "Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.\n\n" +
            "Symbol       Value\n" +
            "   I                  1\n" +
            "   V                 5\n" +
            "   X                10\n" +
            "   L                50\n" +
            "   C               100\n" +
            "   D                500\n" +
            "   M               1000\n\n" +
            "For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.\n" +
            "\n" +
            "Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:\n" +
            "\n" +
            "I can be placed before V (5) and X (10) to make 4 and 9. \n" +
            "X can be placed before L (50) and C (100) to make 40 and 90. \n" +
            "C can be placed before D (500) and M (1000) to make 400 and 900.\n" +
            "Given a roman numeral, convert it to an integer.",
    solution = AlgorithmicProblem.Solution(
        solutionCode = "" +
                "val romanToIntegerMap = hashMapOf(\n" +
                "    \"I\" to 1,\n" +
                "    \"V\" to 5,\n" +
                "    \"X\" to 10,\n" +
                "    \"L\" to 50,\n" +
                "    \"C\" to 100,\n" +
                "    \"D\" to 500,\n" +
                "    \"M\" to 1000\n" +
                ")\n" +
                "\n" +
                "fun romanToInt(string: String): Int {\n" +
                "\n" +
                "    var result = 0\n" +
                "    val size = string.toCharArray().size - 1\n" +
                "    string.forEachIndexed { index, char ->\n" +
                "        val currentChar = char.toString()\n" +
                "        if (index + 1 <= size\n" +
                "            && romanToIntegerMap[currentChar]!! <\n" +
                "            romanToIntegerMap[string[index + 1].toString()]!!\n" +
                "        ) {\n" +
                "            result -= romanToIntegerMap[currentChar]!!\n" +
                "        } else {\n" +
                "            result += romanToIntegerMap[currentChar]!!\n" +
                "        }\n" +
                "    }\n" +
                "    return result\n" +
                "}",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "One Pass Hash Map",
            explanationDescription = "Mapping all roman letters with a hashmap, we can run though the String and search for cases where a" +
                    " smaller valued letter is followed by a greater one, decreasing the total sum",
            coreConcepts = emptyList(),
            timeComplexity = "O(n)",
            spaceComplexity = "O(1)"
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "s = \"III\"",
            output = "3",
            explanation = "III = 3."
        ),
        AlgorithmicProblem.Example(
            input = "s = \"LVIII\"",
            output = "58",
            explanation = "L = 50, V= 5, III = 3."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)

val leetcode14 = AlgorithmicProblem(
    problemId = 14,
    questionNumber = 14,
    title = "Longest Common Prefix",
    problemDescription = "Write a function to find the longest common prefix string amongst an array of strings." +
            "\n" +
            "If there is no common prefix, return an empty string \"\".",
    solution = AlgorithmicProblem.Solution(
        solutionCode = "",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "",
            explanationDescription = "",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "", ""
                )
            ),
            timeComplexity = "",
            spaceComplexity = ""
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "strs = [\"flower\",\"flow\",\"flight\"]",
            output = "\"fl"
        ),
        AlgorithmicProblem.Example(
            input = "strs = [\"dog\",\"racecar\",\"car\"]",
            output = "",
            explanation = "There is no common prefix among the input strings."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)