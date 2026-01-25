class JVMInternalDemo {

    // Method Area
    // Stored in Method Area (Static Variables)
    static int staticVar = 100;

    public static void main(String args[]) {
        int localVar = 10; // Stored in Stack (main Frame)

        // Object Creation -> Stored in Heap
        JVMObject obj = new JVMObject(20);

        // method Call -> new Stack Frame Created
        int result = add(localVar, obj.instanceVar);

        System.out.println("Result =" + result);

        obj = null;

    }

    // Stack frame Creation
    static int add(int a, int b) {
        int sum = a + b; // Stored in STACK
        return sum; // Frame Popped after return
    }
}

class JVMObject {

    // Instance Varibales -> stored in HEAP(Inside Object)
    int instanceVar;

    // Constructor - Stack Frame Created - "This" reference points to HEAP Object
    JVMObject(int value) {
        this.instanceVar = value;
    }
}