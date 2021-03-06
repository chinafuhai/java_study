package com.whp;

import java.nio.IntBuffer;

public class BufferTest {
	public static void main(String[] args) {
		//创建指定长度的缓冲区
		IntBuffer buffer = IntBuffer.allocate(10);
		int[] array = new int[]{3,5,1};
		//使用数组来创建一个缓冲区视图
		buffer = buffer.wrap(array);
		//对缓冲区上指定位置的元素进行修改
		buffer.put(0, 7);
		System.out.println("缓冲区数据如下：");
		//遍历缓冲区的数据
		for(int i=0;i<buffer.limit();i++){
			System.out.print(buffer.get()+"\t");
		}
		System.out.println("\n原始数组数据如下：");
		//修改后会引起双方的变化
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		//buffer.flip();//对缓冲区进行反转。
		//不调用时java.nio.HeapIntBuffer[pos=3 lim=3 cap=3]
		//调用后：java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		//它会把pos设置为0，然后把它原来的值输入给lim（上限），这样可以对原来操作过的区域进行操作。
		buffer.clear();//java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		
		System.out.println(buffer);
		IntBuffer buff2 = buffer.duplicate();//对缓冲区进行复制。返回一个新的缓冲区。
		System.out.println(buff2);
	}
}
