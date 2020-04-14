package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagIntegerArray;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagIntegerArraySerializer
{
	public static void serialize(OutputStream o, NBTTagIntegerArray t) throws IOException
	{
		int l = t.length();
		Serializer.writeInt(o, l);
		for (int i = 0; i < l; i++) Serializer.writeInt(o, t.getValue(i));
	}

	public static NBTTagIntegerArray deserialize(InputStream i) throws IOException
	{
		NBTTagIntegerArray t = new NBTTagIntegerArray();
		int l = Serializer.readInt(i);
		for (int j = 0; j < l; j++) t.addValue(Serializer.readInt(i));
		return t;
	}
}
