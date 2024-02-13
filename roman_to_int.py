class Solution:
    def romantoint(self, s):
        Roman_dict = {'I':1,'V':5, 'X':10, 'L':50, 'C':100, 'D': 500, 'M':1000 }
        # to check if it even is a valid roman no
        # consider it is then:
        #       for loop and check every letter
        res = 0
        for i in range(0, len(s)):
            if(s[i] in Roman_dict):
                if ((i+1 < len(s)) and (Roman_dict[s[i]] < Roman_dict[s[i+1]])):
                    res -= Roman_dict[s[i]]     
                else:
                    res += Roman_dict[s[i]]          
            else:          
                print("invalid string. please enter valid input")
        return res # indentation of this res can cause some pain in the ass fr

s1 = Solution()
num = s1.romantoint("MCMXCIV")
print(num)

