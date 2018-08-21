class Item {
    public String s;

    public Item( String s) 
    {
        this.s = s;
    }
}

public class Queue {

    private int length;
    private Element head;

    private static class Element 
    {
        private Item data;
        private Element next;

        Element( Item it, Element elem) 
        {
            this.data = it;
            this.next = elem;
        }
    }

    public void enqueue( Item item ) 
    {
        length++;
        Element newHead = new Element(item, head);
        this.head = newHead;
    }

    public Item dequeue() 
    {
        if( !isEmpty() ) 
        {
            Element node = head;
            Element temp;
            if( getLength() == 1 ) 
            {
                head = null;
                length = 0;
                return node.data;
            }

            for( int i = 0; i < (length - 2); i++ ) 
            {
                node = node.next;
            }

            temp = node.next;
            node.next = null;
            length --;
            return temp.data;
        } 
        else 
        {
            return null;
        }
    }

    public boolean isEmpty() 
    {
        return getLength() == 0;
    }

    public int getLength() 
    {
        return length;
    }

    public static void main(String[] args) 
    {
        Queue q = new Queue();
        for( int i = 0; i < 10; i++ )
        {
            Item it = new Item("string" + Integer.toString(i));
            q.enqueue(it);
        }
        for( int i = 0; i < 10; i++ )
        {
            Item it = q.dequeue();
            assert it.s == ("string" + Integer.toString(i));
        }
    }
}
