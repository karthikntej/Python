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
        print "List is empty"
    else:
        n = self.head
        while n is not None:
            print n.item,
            n = n.next


def insert_at_start (self, data):
    new_node = Node(data)
    new_node.next = self.head
    self.head = new_node


ll = LinledList()
insert_at_start(ll, 5)
insert_at_start(ll, 4)
insert_at_start(ll, 3)
insert_at_start(ll, 2)
insert_at_start(ll, 1)

traverse_list(ll)
