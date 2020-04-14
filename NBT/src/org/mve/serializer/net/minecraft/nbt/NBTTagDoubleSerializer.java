package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagDouble;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagDoubleSerializer
{
	public static void serialize(OutputStream o, NBTTagDouble t) throws IOException
	{
		Serializer.writeDouble(o, t.getValue());
	}

	public static NBTTagDouble deserialize(InputStream i) throws IOException
	{
		return new NBTTagDouble(Serializer.readDouble(i));
	}
}
