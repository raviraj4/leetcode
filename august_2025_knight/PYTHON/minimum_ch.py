# Minimum Changes To Make Alternating Binary String
class Solution(object):
    def minOperations(self, s: str)-> int:
        """
        :type s: str
        :rtype: int
        """
        count = 0   # no of operation
        for i in range(len(s)):
            if i % 2:
                # odd
                count += 1 if s[i] == "0" else 0  
            else:
                # even
                count += 1 if s[i] == "1" else 0  
                
        return min(count, len(s)- count)
    
sol = Solution()
a = sol.minOperations('00100')
print(a)
    