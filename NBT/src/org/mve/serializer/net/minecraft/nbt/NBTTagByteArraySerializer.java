package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagByteArray;
import org.mve.serializer.Serializer;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagByteArraySerializer
{
	public static void serialize(OutputStream o, NBTTagByteArray t) throws IOException
	{
		int l = t.length();
		Serializer.writeInt(o, l);
		for (int i = 0; i < l; i++) Serializer.writeByte(o, t.getValue(i));
	}

	public static NBTTagByteArray deserialize(InputStream in) throws IOException
	{
		int l = Serializer.readInt(in);
		byte[] b = new byte[l];
		if (in.read(b) < l) throw new EOFException();
		return new NBTTagByteArray(b);
	}
}
