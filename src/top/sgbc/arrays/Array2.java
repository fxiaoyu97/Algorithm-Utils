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
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }
}
