package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagLongArray;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagLongArraySerializer
{
	public static void serialize(OutputStream o, NBTTagLongArray t) throws IOException
	{
		int l = t.length();
		Serializer.writeInt(o, l);
		for (int i = 0; i < l; i++) Serializer.writeLong(o, t.getValue(i));
	}

	public static NBTTagLongArray deserialize(InputStream i) throws IOException
	{
		NBTTagLongArray t = new NBTTagLongArray();
		int l = t.length();
		for (int j = 0; j < l; j++) t.addValue(Serializer.readLong(i));
		return t;
	}
}
