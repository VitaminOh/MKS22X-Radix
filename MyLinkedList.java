import java.util.*;

public class MyLinkedList<E> {
  private class Node<E> {
    private E data;
    private Node next,prev;

    @SuppressWarnings("unchecked")
    public Node(E element, Node prevNode, Node nextNode){
      data = element;
      prev = prevNode;
      next = nextNode;
    }
    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public void setNext(Node other){
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
    }
    public E getData(){
      return data;
    }
    @SuppressWarnings("unchecked")
    public E setData(E value){
      E oldData = data;
      data = value;
      return oldData;
    }
    public String toString(){
      return data + "";
    }
  }

  private int length;
  private Node start,end;
  public MyLinkedList() {
    Node start1 = new Node(null,null,null);
    start = start1;
    end = start1;
    length = 0;
  }

  public int size() {
    return length;
  }

  public void clear() {
    Node newStart = new Node(null,null,null);
    start = newStart;
    end = newStart;
    length = 0;
  }
  public String toString() {
    Node current = start;
    String ans = "";
    while (current != null){
      ans += current.getData();
      if (current.next() != null){
        ans += ", ";
      }
      if (current.next() != null){
        current = current.next();
      } else {
        return ans;
      }
    }
    return ans;
  }
  @SuppressWarnings("unchecked")
  public boolean add(E element) {
    if (length == 0){
      start.setData(element);
      length++;
      return true;
    }
    if (length == 1){
      Node toAdd = new Node(element,null,null);
      end = toAdd;
      start.setNext(end);
      end.setPrev(start);
      length++;
      return true;
    }
    Node addToEnd = new Node(element,null,null);
    end.setNext(addToEnd);
    addToEnd.setPrev(end);
    end = addToEnd;
    length++;
    return true;
  }
  @SuppressWarnings("unchecked")
  public void extend (MyLinkedList<E> other) {
    if(other.size() == 0){
      return;
    }
    if(size() == 0){
      this.start = other.start;
      this.end = other.end;
      this.length = other.length;
      other.clear();
    }else{
      Node startOfOtherList = other.start;
      end.setNext(startOfOtherList);
      startOfOtherList.setPrev(end);
      end = other.end;
      length += other.size();
      other.clear();
    }
  }
  public E removeFront() {
    Node next = start.next();
    E oldData = (E) start.getData();
    start.setNext(null);
    start = next;
    return oldData;
  }

  public static void main(String[] args) {
    MyLinkedList<Integer> data = new MyLinkedList();
    data.add(5);
    System.out.println(data);
  }
}
