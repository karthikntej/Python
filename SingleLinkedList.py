#Python 2.7
#Single linked list
class Node:
    def __init__(self, data):
        self.item = data
        self.next = None

class LinledList:
    def __init__(self):
        self.head = None


def traverse_list(self):
    if (self.head is None):
        print "List is empty\n"
    else:
        n = self.head
        while n is not None:
            print n.item,
            n = n.next
    print ("")

#Insert at begining of the ll
def insert_at_start (self, data):
    new_node = Node(data)
    new_node.next = self.head
    self.head = new_node


#Insert at end of the ll
def insert_at_end (self, data):
    new_node = Node(data)

    if (self.head is None):
        self.head = new_node
    else:
        n = self.head
        while (n.next != None):
            n = n.next

        n.next = new_node

#Insert at index
def insert_at_index (self, data, index):
    new_node = Node(data)
    
    if (index == 1):
        insert_at_start(self, data)
        return
    
    if (self.head is None):
        print ("Index not found!\n")
        return
    else:
        cur = self.head.next
        pre = self.head
        index = index - 2
        while (index > 0):
            pre = cur
            cur = cur.next
            index = index -1
        if (index > 0):
            print("Index not found!")
            return
        new_node.next = cur
        pre.next = new_node


print (
"""1. Insert at front
2. Insert at end
3. Insert at index
4. Travesr""")

ll = LinledList()

while (True):
    choice = int(raw_input("Enter your choice: "))
    if (choice == 1):
        insert_at_start(ll, int(raw_input("Enter data: ")))
    elif (choice == 2):
        insert_at_end(ll, int(raw_input("Enter data: ")))
    elif (choice == 3):
        data = int(raw_input("Enter data: "))
        index = int(raw_input("Enter index: "))
        insert_at_index(ll, data, index)
    elif (choice == 4):
        traverse_list(ll)
    elif (choice == 0):
        break



"""
insert_at_start(ll, 5)
insert_at_start(ll, 4)
insert_at_start(ll, 3)
insert_at_start(ll, 2)
insert_at_start(ll, 1)
insert_at_end(ll, 6)
insert_at_end(ll, 7)
traverse_list(ll)"""
