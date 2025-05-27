package DataStructures;
class Node{

	Node next;
	int data;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

public class LinkedList {
	Node head;

	public void add(int data) {
		Node newNode=new Node(data);
		Node temp=head;
		if(head==null) {
			head=newNode;
		}else {
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
		
	}
	
	void addFirst(int data) {
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
	}
	void print() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print(" ");
	}
	
	Node LastElem() {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}
	
	Node FirstElem() {
		return head;
	}
	
	int search(int data) {
		Node temp=head;
		int count=1;
		while(temp.data!=data) {
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	void update(int index,int data) {
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
			
			
		}
		temp.data=data;
	}
	
	int get(int index) {
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
			
		}
		return temp.data;
	}
	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.addFirst(11);
		ll.addFirst(19);
		ll.print();
		System.out.println();
		System.out.println("First Element");
		System.out.println(ll.FirstElem().data);
		System.out.println("Last Element");
		System.out.println(ll.LastElem().data);
		System.out.println("Index");
		System.out.println(ll.search(4));
		System.out.println("Update");
		ll.update(3,10);
		ll.print();
		
		
	}

}
