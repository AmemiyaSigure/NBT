package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagFloat;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagFloatSerializer
{
	public static void serialize(OutputStream o, NBTTagFloat t) throws IOException
	{
		Serializer.writeFloat(o, t.getValue());
	}

	public static NBTTagFloat deserialize(InputStream i) throws IOException
	{
		return new NBTTagFloat(Serializer.readFloat(i));
	}
}
