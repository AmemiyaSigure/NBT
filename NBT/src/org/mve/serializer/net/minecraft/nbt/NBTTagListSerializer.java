package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagList;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagListSerializer
{
	public static void serialize(OutputStream o, NBTTagList t) throws IOException
	{
		Serializer.writeByte(o, t.getComponentType());
		int l = t.length();
		Serializer.writeInt(o, l);
		for (int i = 0; i < l; i++) NBTTagElementSerializer.serialize(o, t.getValue(i));
	}

	public static NBTTagList deserialize(InputStream i) throws IOException
	{
		byte componentType = Serializer.readByte(i);
		NBTTagList list = new NBTTagList(componentType);
		int len = Serializer.readInt(i);
		for (int j = 0; j < len; j++) list.addValue(NBTTagElementSerializer.deserialize(i, componentType));
		return list;
	}
}
