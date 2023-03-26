import java.util.*;
public class Stack <Item>{
    private class Node{
        Item value;
        Node nextNode;
        Node (Item value){
            this.value=value;
        }
    }
    private Node node;
    Stack(){
        node=null;
    }
    public Item top(){
        return node.value;
    }
    public void push(Item valuee) {
        Node temp= new Node(valuee);
        temp.nextNode= node;
        node = temp;
    }
    public Item pop() {
        if (node!=null) {
            Item val= node.value;
            node= node.nextNode;
            return val;
        }
        return null;
    }
    public boolean isEmpty(){
        return node== null;
    }

    public static void main(String args[]){
        Stack<String> stack = new Stack<String>();
        stack.push("lmaolmaolmao");;
        stack.push("xaoxanghaotrungcua");
        stack.pop();
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("stack not empty");
        }

    }
}