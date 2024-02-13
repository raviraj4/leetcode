import re
class Solution:
    def isPalindrome(self, x):
        self.x = x
        list_x = [digit for digit in str(x)]
        rev_list_x = reversed(list_x)
        str_rev_x = "".join(rev_list_x)
        # rev_x = int(str_rev_x)
        # self.x == str_rev_x
        pattern = r"-"
        if re.search(pattern, str_rev_x):
            return False
        else:
            if  self.x == int(str_rev_x):
                return True
            else:
                return False
  
pal = Solution()
print(pal.isPalindrome(-121))     

# runtime - 35 ms