/**
 * 
 */
package com.yuandu.common.serializer;

import java.io.*;

/**
 * java 标准序列化
 */
public class JavaSerializer implements Serializer {

	@Override
	public String name() {
		return "java";
	}
	
	@Override
	public byte[] serialize(Object obj) throws IOException {
		ObjectOutputStream oos = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			return baos.toByteArray();
		} finally {
			if(oos != null)
			try {
				oos.close();
			} catch (IOException e) {}
		}
	}

	@Override
	public Object deserialize(byte[] bits) throws IOException {
		if(bits == null || bits.length == 0)
			return null;
		ObjectInputStream ois = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bits);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			if(ois != null)
			try {
				ois.close();
			} catch (IOException e) {}
		}
	}
	
}
