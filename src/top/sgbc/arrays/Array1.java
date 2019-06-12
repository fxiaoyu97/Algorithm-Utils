package top.sgbc.arrays;

/**
 * 自定义整型数组类
 */
public class Array1 {
    /**
     * 数组中实际存放数据的长度
     **/
    private int size;

    private Integer[] data;

    public Array1(int capacity) {
        this.size = 1;
        this.data = new Integer[capacity];
    }

    public Array1() {
        this(16);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed，index is illegal");
        }
        return data[index];
    }

    public Integer getFirst() {
        return get(0);
    }

    public Integer getLast() {
        return get(size - 1);
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public void set(int index,Integer e){
        if (index<0 || index >= size){
            throw new IllegalArgumentException("add failed，index is illegal");
        }
        data[index] = e;
    }

    public void setFirst(Integer e) {
        this.set(0,e);
    }

    public void setLast(Integer e) {
         this.set(size - 1,e);
    }
    public void add(int index, Integer e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed，index is illegal");
        }
        if (size == data.length) {
            throw new IllegalArgumentException("add failed，Array is full!");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(Integer e) {
        this.add(size-1, e);
    }

    public void addFirst(Integer e) {
        this.add(0, e);
    }

    public boolean constains(Integer e){
        for (int i = 0; i < size; i++) {
            if(e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public int find(Integer e){
        for (int i = 0; i < size; i++) {
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public Integer remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed，index is illegal");
        }
        Integer ret = data[index];
        for (int i = index; index < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        return ret;
    }

    public void removeLast() {
        this.remove(size-1);
    }

    public void removeFirst() {
        this.remove(0);
    }
    public int removeElement(Integer e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
        return index;
    }

    @Override
    public String toString() {
        return "Arrays{" +
                ", data=" + java.util.Arrays.toString(data) +
                '}';
    }
}
