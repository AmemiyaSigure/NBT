package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagShort;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagShortSerializer
{
	public static void serialize(OutputStream o, NBTTagShort t) throws IOException
	{
		Serializer.writeShort(o, t.getValue());
	}

	public static NBTTagShort deserialize(InputStream i) throws IOException
	{
		return new NBTTagShort(Serializer.readShort(i));
	}
}
