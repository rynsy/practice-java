public class Tester {
    public static void main(String[] args) {
        MyGenericQueue<String> test = new MyGenericQueue<String>();
        test.enqueue("DUDE");
        test.enqueue("INCREDIBLE");
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
    }
}
