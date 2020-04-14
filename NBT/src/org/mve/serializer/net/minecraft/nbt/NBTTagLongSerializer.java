package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagLong;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagLongSerializer
{
	public static void serialize(OutputStream o, NBTTagLong t) throws IOException
	{
		Serializer.writeLong(o, t.getValue());
	}

	public static NBTTagLong deserialize(InputStream i) throws IOException
	{
		return new NBTTagLong(Serializer.readLong(i));
	}
}
