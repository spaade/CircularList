public class Main {
    public static void main(String[] args) {
        CircularList circularList = new CircularList();

        circularList.push(60);
        circularList.push(66);
        circularList.push(63);
        circularList.remove(63);
        circularList.contains(60);
        circularList.print();

    }
}
