package exbook3;

public class NodeInt {
	// Data fields
	private Integer data;
	private NodeInt next;

	// Constructors
	NodeInt(Integer data) {
		this.data=data;
		this.next=null;
	}
	NodeInt(Integer data, NodeInt next) {
		this.data=data;
		this.next=next;
	}

	NodeInt(NodeInt node) {
		node.data=data;
		node.next=next;
	}

	public boolean allPositive() {
		if (next==null) { // tail of list is empty
			return data>=0;
		} else {          // tail of list is not empty
			return (data>=0) && next.allPositive();
		}
	}

	public boolean allPositive2() {
		boolean result=true;
		NodeInt current = this;

		while (current!=null) {
			result = result && (data>=0);
			current = current.next;
		}

		return result;
	}

	public int size() {
		if (next==null) { // tail of list is empty
			return 1;
		} else {          // tail of list is not empty
			return 1 + next.size();
		}
	}

	public int size2() {
		int result=0;
		NodeInt current = this;

		while (current!=null) {
			result = result +1;
			current = current.next;
		}

		return result;
	}

	// Exercise 1
	public boolean isSingleton() {
		return next == null;
	}

	/**
	 * Returns a copy of the receiving list, in which each data item has been incremented by one
	 * @return Reference to the first node of the list
	 */
	public NodeInt bump() {
		if (next==null) {
			return new NodeInt(data+1);
		} else {
			return new NodeInt(data+1,next.bump());
		}
	}

	private NodeInt bump2() {
		return this.bump2(this);
	}

	public NodeInt bump2(NodeInt original) {
		if (this.next == null) {
			this.data += 1;
			return original;
		} else {
			this.data += 1;
			return this.next.bump2(original);
		}
	}

	// Exercise 2
	public boolean allEven() {
		if (data % 2 != 0) {
			return false;
		} else {
			if (next==null) {
				return true;
			} else {
				return next.allEven();
			}
		}
	}

	// Exercise 3
	public int sumL() {
		if (next==null) {
			return data;
		} else {
			return data + next.sumL();
		}
	}

	// Exercise 4
	public boolean nonDuplicates() {
		if (next==null) {
			return true;
		} else {
			int current = data;
			NodeInt checkList = next;
			while (checkList != null) {
				for (int i=0; i<checkList.size(); i++) {
					if (current == checkList.data) {
						return false;
					}
				}

				current = checkList.data;
				checkList = checkList.next;
			}

			return true;
		}
	}

	// Exercise 5
	// Review:  See code for bump

	public NodeInt copyL() {
		if (this.next==null) {
			return new NodeInt(data);
		} else {
			return new NodeInt(data,next.copyL());
		}
	}

	// Exercise 6
	private NodeInt append(NodeInt l2, NodeInt l1) {
		if (this.next == null) {
			this.next=l2;
			return l1;
		} else {
			return this.next.append(l2,l1);
		}
	}

	public NodeInt append(NodeInt l2) {
		return this.append(l2,this);
	}

	// append2 is old, functionality unknown
	public NodeInt append2(NodeInt node) {
		if (node.data == null) {
			return this;
		} else {
			NodeInt current = this;
			System.out.println(node.next);
			NodeInt n = new NodeInt(node);
			System.out.println(n);
			return current;
		}
	}

	// Exercise 7
	private Integer getLength() {
		int result = 0;
		NodeInt current = this;
		while (current != null) {
			result += 1;
			current = current.next;
		}
		return result;
	}

	private Integer getLast() {
		if (this.next == null) {
			return this.data;
		} else {
			return this.next.getLast();
		}
	}

	private NodeInt setLast(int newEntry) {
		return this.setLast(newEntry, this);
	}

	private NodeInt setLast(int newEntry, NodeInt original) {
		if (this.next == null) {
			this.data = newEntry;
			return original;
		} else {
			return this.next.setLast(newEntry, original);
		}
	}

	private NodeInt removeLast() {
		return this.removeLast(this);
	}

	private NodeInt removeLast(NodeInt original) {
		if (this.next == null) {
			return null;
		}
		if (this.next.next == null) {
			this.next = null;
			return original;
		} else {
			return this.next.removeLast(original);
		}
	}

	public NodeInt reversewc() {
		if (next==null) {
			return new NodeInt(data);
		} else {
			NodeInt current = next.reversewc();
			NodeInt head = current;
			while (current.next!=null) {
				current=current.next;
			}
			current.next = new NodeInt(data);
			return head;
		}
	}

	public NodeInt reverseip() {
		return null;

	}
	private NodeInt reverse(NodeInt original) {
		if (this.next == null) {
			return original;
		} else {
			NodeInt current = original;
			Integer last = current.getLast();
			current.setLast(current.data);
			current.data = last;
			return current.next.removeLast().reverse(original);
		}
	}

	public NodeInt reverse() {
		return this.reverse(this);
	}

	// Exercise 8
	public NodeInt doubleL() {
		return doubleL(this);
	}

	private NodeInt doubleL(NodeInt original) {
		NodeInt current = original;
		while (current != null) {
			current.data *= 2;
			current = current.next;
		}
		return original;
	}

	// Exercise 9 - not working
	public NodeInt repeatLN(Integer n) {
		if (n==0) {
			return null;
		}

		NodeInt copy = this.copyL();
		NodeInt result = this;
//		this.append(copy);
		for (int i = 0; i<n-1; i++) {
			result.append(copy);
			copy = this.copyL();
		}
		return result;
	}

	// Exercise 11
	public NodeInt removeAdjacentDuplicates() {
		return this.removeAdjacentDuplicates(this);
	}

	private NodeInt removeAdjacentDuplicates(NodeInt original) {
		if (this.next == null) {
			return original;
		} else {
			if (this.data == this.next.data) {
				this.next = this.next.next;
				return this.removeAdjacentDuplicates(original);
			} else {
				return this.next.removeAdjacentDuplicates(original);
			}
		}
	}

	// Exercise 12
	public NodeInt filterEven() {
		if (this.data % 2 == 0) {
			if (this.next==null) {
				return new NodeInt(this.data);
			} else {
				return new NodeInt(this.data,this.next.filterEven());
			}
		} else {
			if (this.next==null) {
				return null;
			} else {
				return this.next.filterEven();
			}
		}
	}

	// Exercise 13 notes: not able to do in nodeInt, have to do in Node, review video 8 on canvas.

	public String toString2() {
		if (next==null) {
			return data.toString();
		} else {
			return data.toString() + "," + next.toString();
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		NodeInt current=this;
		while(current!=null) {
			s.append(current.data.toString());
			current=current.next;
		}
		return s.toString();
	}

	public static void main(String[]  args) {
		NodeInt n1 = new NodeInt(1);
		NodeInt n2 = new NodeInt(2,n1);
		NodeInt n3 = new NodeInt(3,n2);

		NodeInt m1 = new NodeInt(4);
		NodeInt m2 = new NodeInt(5,m1);
		NodeInt m3 = new NodeInt(6,m2);

		NodeInt o1 = new NodeInt(3);
		NodeInt o2 = new NodeInt(3,o1);
		NodeInt o3 = new NodeInt(3,o2);
		NodeInt o4 = new NodeInt(1,o3);
		NodeInt o5 = new NodeInt(2,o4);
		NodeInt o6 = new NodeInt(2,o5);
		NodeInt o7 = new NodeInt(1,o6);

		System.out.println(n3.repeatLN(3));
	}
}
