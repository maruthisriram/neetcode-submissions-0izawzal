class DynamicArray {
    int[] resizableArray;
    int size;
    int lastIndex;
    public DynamicArray(int capacity) {
        this.resizableArray = new int[capacity];
        this.size = capacity;
        this.lastIndex = 0;
    }

    public int get(int i) {
        return this.resizableArray[i];
    }

    public void set(int i, int n) {
        this.resizableArray[i] = n;

    }

    public void pushback(int n) {
        if(lastIndex == this.size){
            resize();
        }
        this.resizableArray[lastIndex++] = n;
    }

    public int popback() {
        
        int last = resizableArray[lastIndex - 1];
        resizableArray[lastIndex - 1] = Integer.MIN_VALUE;
        lastIndex--;
        return last;
    }

    private void resize() {
        int[] newArray = new int[this.size * 2];
        this.size *= 2;
        for(int i=0;i<this.resizableArray.length;i++){
            newArray[i] = resizableArray[i];
        }
        this.resizableArray = newArray;
    }

    public int getSize() {
        return lastIndex;
    }

    public int getCapacity() {
        return this.resizableArray.length;
    }
}
