package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagByte;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagByteSerialize
{
	public static void serialize(OutputStream o, NBTTagByte t) throws IOException
	{
		Serializer.writeByte(o, t.getValue());
	}

	public static NBTTagByte deserialize(InputStream i) throws IOException
	{
		return new NBTTagByte(Serializer.readByte(i));
	}
}
