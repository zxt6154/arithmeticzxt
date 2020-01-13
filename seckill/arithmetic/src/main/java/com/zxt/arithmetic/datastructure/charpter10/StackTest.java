package com.zxt.arithmetic.datastructure.charpter10;

/*数组实现栈
 * first in last out
 * 出栈pop
 * 入栈push
 * */
public class StackTest {
    private int size = 8;
    private Object[] arrays = new Object[size];
    //top为指向此数组不为空的最后一个元素的下标，开始无数组，置为-1
    int top = -1;


    public <T> void push(T object) {
        top++;
        // 0 1 2 3 4 5 6 7 8            9
        for (int i = top; i < arrays.length; i++) {
            if (arrays[arrays.length - 2] != null) {
                Object[] newarrays = new Object[arrays.length*2];
                //将原数组元素的值赋给扩容数组
                //源数组src:arrays;从源数组的0坐标开始复制,目标数组:newarrays,从目标数组的0坐标开始；长度为源数组的长度
                System.arraycopy(arrays,0,newarrays,0,arrays.length);
                arrays = newarrays;
                arrays[top] = object;
                System.out.println(arrays.length);
                break;
            } else {
                arrays[top] = object;
                break;
              }
            }
    }


    public <T> T pop(){
        //删除数组最后一个不为空的值
        T temp = (T) arrays[top];
        arrays[top] = null;
        top--;
        return temp;
    }

    public static void main(String[] args) {
        StackTest test = new StackTest();
        test.push("Alice");
        test.push("Bily");
        test.push("Cinderella");
        test.push("Diana");
        test.push("Elsa");
        test.push("Flank");
        test.push("Glace");
        test.push("helthy");
        test.push("illy");
        test.push("joke");
        test.push("k");
        test.push("lily");

        //String popStr = test.pop();
        for (Object array :test.arrays) {
            System.out.print(array + " ");
        }
        System.out.println(test.arrays.length);
        System.out.println("--------------------------split---------------------------");
        Object strpopone = test.pop();
        Object strpoptwo = test.pop();
        System.out.println("one "+strpopone +" two "+strpoptwo);
        for (Object array :test.arrays) {
            System.out.print(array + " ");
        }
        System.out.println(test.arrays.length);
    }
}
