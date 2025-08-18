class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def addTwoNumbers(l1, l2):
    ''' ex takes: 1->2->3 and 4->9->3 gives- 6->1->6
        that is starts from end value (so need to access last one first)
        adds with other if less than 10 adds to last of a new l3
        else adds 1 to next number and adds dig at 1s place to the node

    '''
    l1a = []
    l2a = []
    
    # 1) goal is to loop and store one by one from last till first
    # l1.val
    # l1.next.val
    # l1.next.next.val
    l1End = False
    while(l1End == False):
        
        if(l1.next != None):
            l1a.append(l1.val)   
            l1 = l1.next
        if(l1.next == None):
            l1a.append(l1.val)
            l1End = True
        # t1 = t1.next

    l2End = False
    while(l2End == False):
        if (l2.next != None):
            l2a.append(l2.val)
            l2 = l2.next
        if(l2.next == None):
            l2a.append(l2.val)
            l2End = True
        # l2a = l2a.next
    
    # return l1a, l2a
    # now I have arrays
    sol = []
    lenl1 = len(l1a)
    lenl2 = len(l2a)
    t1a = l1a
    t2a = l2a
    
    # print(l1a)
    # print(l2a)
    # print("log begins")
    for i in range(0, max(lenl1,lenl2)):
        if(lenl1 != lenl2 ):
            # print(f'l1a: {len(l1a)} {l1a} \n ;l2a: {len(l2a)} {l2a}')
            # diff lengths of LL ex: 9999999 , 9999 ii)  [8, 9, 9, 9, 9, 9, 10]
            if(i <= min(lenl1, lenl2)-1): # will work till the length of smaller arr
                if(l1a[i]+ l2a[i] <= 9):
                    sol.append(l1a[i]+ l2a[i])
                else: # 942 , 9465 -> 10407 -> [] if > 9
                    if(lenl1>lenl2):
                        #991 , 1 -> 002
                        l1a[i+1] += 1
                        sol.append((l1a[i]+ l2a[i])%10)                         
                    if(lenl2>lenl1):
                        l2a[i+1] += 1
                        sol.append((l1a[i]+ l2a[i])%10)
                        # 0 1 2 3
                        #     +1+1+1
                        # 5 6 4 9 l1
                        # 2 4 9   l2
                        # 7 0 4 0 1
            
            if(i > min(lenl1, lenl2)-1): # +1
                if(lenl1>lenl2):       # +1 +1
                    if(i<len(l1a)-1):  # 9 9 1 , 1 ->  
                        if(l1a[i]>9):
                            l1a[i+1]+=1
                            sol.append(l1a[i]%10)
                        else:
                            sol.append(l1a[i])
                            
                    if(i==lenl1-1 and l1a[i]<=9):
                        sol.append(l1a[i])
                    if(i==lenl1-1 and l1a[i]>9):
                        sol.extend([l1a[i]%10, 1])  # jo bi bada uska ith val                        
                        
                if(lenl2>lenl1):
                    if(i<len(l2a)-1):  # 9 9 1 , 1 ->  
                        if(l2a[i]>9):
                            l2a[i+1]+=1
                            sol.append(l2a[i]%10)
                        else:
                            sol.append(l2a[i])
                    if(i==lenl2-1 and l2a[i]<=9):
                        sol.append(l2a[i])
                    if(i==lenl2-1 and l2a[i]>9):
                        sol.extend([l2a[i]%10, 1])
        else:
            #---- works dont touch---
            #same length of LL ex: 243 , 564
            # print(f'l1a: {len(l1a)} {l1a} \n ;l2a: {len(l2a)} {l2a}')  # 5, 5 -> 01
            if(l1a[i]+l2a[i] <= 9):
                # print("else0>if1")
                sol.append(l1a[i]+l2a[i])
            else:
                # print("else0>if2")
                # sol.append((l1a[i]+l2a[i]) % 10)
                if(i < lenl1-1):
                    l1a[i+1]+=1
                    sol.append((l1a[i]+l2a[i]) % 10)
                if(i==lenl1-1):
                    sol.extend([(l1a[i]+l2a[i]) % 10, 1])

    # return sol
    # print(sol)
    # I have solution arr, now I mus loop and creat ListNode with (sol[i], next)
    # sol = 7 0 8 
    
    nodes = [ListNode(sol[-1], None)] # 8
    for j in range(len(sol)-2,-1,-1): # 
        # if(j<len(sol_r)-1):
           # ListNode(sol_r[j],None)
        nodes.append(ListNode(sol[j], nodes[-1]))
        # else:
        #    # ListNode(sol_r[j], ListNode(ListNode))
        #    nodes.append(ListNode(nodes[-1],))
    return nodes[-1] # ListNode object pointing to next
    


    

n1 = ListNode(3, None)
m1 = ListNode(4, n1)
l1 = ListNode(2, m1)
tt = l1
# l1 - 2->4->3 : 342

o2 = ListNode(7, None)
n2 = ListNode(4, o2)
m2 = ListNode(6, n2)
l2 = ListNode(5, m2)
# l2 - 5->6->4->7 : 7465

r = ListNode(9, None)
q = ListNode(4, r)
p = ListNode(2, q)

# l1 - 2->4->3 : 342

i = ListNode(9, None)
h = ListNode(4, i)
g = ListNode(6, h)
f = ListNode(5, g)
# ex 2

a1 = ListNode(0, None)
a2 = ListNode(0, None)

# ex 3

v7 = ListNode(9,None)
v6 = ListNode(9,v7)
v5 = ListNode(9,v6)
v4 = ListNode(9,v5)
v3 = ListNode(9,v4)
v2 = ListNode(9,v3)
v1 = ListNode(9,v2)

s4 = ListNode(9,None)
s3 = ListNode(9,s4)
s2 = ListNode(9,s3)
s1 = ListNode(9,s2)




# node_l1l2 = addTwoNumbers(l1,l2)
# node_l1l2 = addTwoNumbers(f,p)

# for item in node_l1l2:
#     print(item.val)
# print(node_l1l2.val)

# 249 & 5649 -> 70401
# node_l1l2 = addTwoNumbers(l1,l2)
# print(node_l1l2.val)
# print(node_l1l2.next.val)
# print(node_l1l2.next.next.val)
# print(node_l1l2.next.next.next.val)

# 9999999 & 9999 -> 89990001
# node_l1l2 = addTwoNumbers(v1,s1)
# print(node_l1l2.val)
# print(node_l1l2.next.val)
# print(node_l1l2.next.next.val)
# print(node_l1l2.next.next.next.val)
# print(node_l1l2.next.next.next.next.val)
# print(node_l1l2.next.next.next.next.next.val)
# print(node_l1l2.next.next.next.next.next.next.val)
# print(node_l1l2.next.next.next.next.next.next.next.val)

# 991 & 1
ab3 = ListNode(1, None)
ab2 = ListNode(9, ab3)
ab1 = ListNode(9, ab2)
cd1 = ListNode(1, None)
# node_l1l2 = addTwoNumbers(ab1,cd1)
# print(node_l1l2.val)
# print(node_l1l2.next.val)
# print(node_l1l2.next.next.val)
# print(node_l1l2.next.next.next.val)

yc = ListNode(6,None)
yb = ListNode(1,yc)
ya = ListNode(9,yb)
node_l1l2 = addTwoNumbers(ya,a1)
print(node_l1l2.val)
print(node_l1l2.next.val)
print(node_l1l2.next.next.val)

# 5, 5 -> 01
# xa = ListNode(5, None) 
# xb = ListNode(5, None) 
# node_l1l2 = addTwoNumbers(xa,xb)
# print(node_l1l2.val)
# print(node_l1l2.next.val)
# addTwoNumbers(a2,a1)

# sol = addTwoNumbers(f,p)
# print(f'sol array: ,  {sol}')



