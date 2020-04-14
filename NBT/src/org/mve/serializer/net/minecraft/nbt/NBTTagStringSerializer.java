package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagString;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagStringSerializer
{
	public static void serialize(OutputStream o, NBTTagString t) throws IOException
	{
		Serializer.writeString(o, t.getValue());
	}

	public static NBTTagString deserialize(InputStream i) throws IOException
	{
		return new NBTTagString(Serializer.readString(i));
	}
}
