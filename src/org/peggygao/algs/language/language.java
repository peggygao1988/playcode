package org.peggygao.algs.language;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class language {

    public static void main(String[] args) {

	RandomAccessFile raf = null;
	try {
	    raf = new RandomAccessFile("data2.txt", "rw");

	    FileChannel channel = raf.getChannel();
	    MappedByteBuffer buffer = channel.map(
		    FileChannel.MapMode.READ_WRITE, 0, 100);
	    for (int i = 10; i < 20; i++) {
		buffer.putInt(i);
	    }
	    // for (int i = 0; i < 11; i++) {
	    // char c = raf.readChar();
	    // System.out.println(c);
	    // }
	    //
	    // // raf.skipBytes(17);
	    // raf.seek(0);
	    buffer.flip();
	    for (int i = 0; i < 10; i++) {
		int k = buffer.getInt();
		System.out.println(k);
	    }
	    // raf.seek(40);
	    // raf.writeChars("hello,world");
	    // System.out.println(raf.length());
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    try {
		raf.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
