package top.sgbc.arrays;

/**
 * 在第一版的基上增加泛型
 * @param <E>
 */
public class Array2<E> {
    /**集合长度，默认值为0 **/
    private int size;

    /**自定义泛型集合**/
    private E[] data;

    public Array2(){
        size = 0;
        data = (E[])new Object[16];
    }

    /**
     * 获取集合中元素的数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取集合的容量大小
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取指定位置上的元素
     * @param index
     * @return
     */
    public E get(int index){
        illegalArgument(index);
        return data[index];
    }

    /**
     * 获得第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得最后一个元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    public void set(int index,E e){
        illegalArgument(index);
        data[index] = e;
    }

    public void setFirst(E e) {
        this.set(0,e);
    }

    public void setLast(E e) {
        this.set(size - 1,e);
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public void add(int index,E e){
        illegalArgument(index);
        if (size == data.length) {
            throw new IllegalArgumentException("add failed，Array is full!");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public void addFirst(E e) {
        this.add(0, e);
    }


    /**
     * 查找该元素出现的所有位置
     * @param e
     * @return
     */
    public int[] findAll(E e){
        int[] sites = new int[size];
        int len = 0;
        for (int i = 0;i < size;i++){
            if(e.equals(data[i])){
                len++;
                sites[len] = i;
            }
        }
        sites[0] = len;
        return sites;
    }

    public E remove(int index){
        illegalArgument(index);
        E e = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[size-1]=null;
        size--;
        return e;
    }

    /**
     * 删除指定位置上的元素
     * @param sites
     */
    private void removeAll(int[] sites){
        int step = 1;
        int index = 2;

        for (int i = sites[index-1]; i < size-step; i++) {
            if (i == sites[index]-1){
                index++;
                step++;
            }
            if(i+step == sites[index]){
                i--;
                index++;
                step++;
                continue;
            }
            if (i+step>=size){
                break;
            }
            data[i] = data[i+step];
        }
        for (int i = size-sites[0];i<size;i++){
            data[i] = null;
        }
        size=size-sites[0];
    }

    public void removeLast() {
        this.remove(size-1);
    }

    public void removeFirst() {
        this.remove(0);
    }

    /**
     * 移除指定元素
     * @param e
     * @return
     */
    public int removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
        return index;
    }

    public void removeAllElement(E e){
        int[] sites = findAll(e);
        if (sites[0] != 0){
            removeAll(sites);
        }
    }

    public boolean constains(E e){
        for (int i = 0; i < size; i++) {
            if(e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断index是否合法
     * @param index
     */
    private void illegalArgument(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed，index is illegal");
        }
    }
    @Override
    public String toString() {
        return "Arrays{" +size+
                ", data=" + java.util.Arrays.toString(data) +
                '}';
    }
}
