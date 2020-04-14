package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagInteger;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagIntegerSerializer
{
	public static void serialize(OutputStream o, NBTTagInteger t) throws IOException
	{
		Serializer.writeInt(o, t.getValue());
	}

	public static NBTTagInteger deserialize(InputStream i) throws IOException
	{
		return new NBTTagInteger(Serializer.readInt(i));
	}
}
