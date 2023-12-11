"""
给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
输入：word1 = "abc", word2 = "pqr"
输出："apbqcr"
"""
def mergeAlternately(word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        解法：双指针，使用append方法，在list后面加字符，使用while循环，当指针小于word的长度时，在答案后面加字符
        最后使用join方法改为string
        list_of_strings = ['Hello', 'World']
        sentence = ' '.join(list_of_strings)
        print(sentence)  Output: 'Hello World'
        """
        m, n = len(word1), len(word2)
        i = j = 0

        ans = list()
        while i < m or j < n:
            if i < m:
                ans.append(word1[i])
                i += 1
            if j < n:
                ans.append(word2[j])
                j += 1
        
        return "".join(ans)

word1 = "abc"
word2 = "pqr"
answer = mergeAlternately(word1,word2)
print(answer)
