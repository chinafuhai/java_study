package com.whp;

import java.nio.IntBuffer;

public class BufferTest {
	public static void main(String[] args) {
		//����ָ�����ȵĻ�����
		IntBuffer buffer = IntBuffer.allocate(10);
		int[] array = new int[]{3,5,1};
		//ʹ������������һ����������ͼ
		buffer = buffer.wrap(array);
		//�Ի�������ָ��λ�õ�Ԫ�ؽ����޸�
		buffer.put(0, 7);
		System.out.println("�������������£�");
		//����������������
		for(int i=0;i<buffer.limit();i++){
			System.out.print(buffer.get()+"\t");
		}
		System.out.println("\nԭʼ�����������£�");
		//�޸ĺ������˫���ı仯
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		//buffer.flip();//�Ի��������з�ת��
		//������ʱjava.nio.HeapIntBuffer[pos=3 lim=3 cap=3]
		//���ú�java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		//�����pos����Ϊ0��Ȼ�����ԭ����ֵ�����lim�����ޣ����������Զ�ԭ����������������в�����
		buffer.clear();//java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		
		System.out.println(buffer);
		IntBuffer buff2 = buffer.duplicate();//�Ի��������и��ơ�����һ���µĻ�������
		System.out.println(buff2);
	}
}