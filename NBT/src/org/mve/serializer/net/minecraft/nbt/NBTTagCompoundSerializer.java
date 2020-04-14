package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagCompound;
import org.mve.net.minecraft.nbt.NBTTagElement;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

public class NBTTagCompoundSerializer
{
	public static void serialize(OutputStream out, NBTTagCompound tag) throws IOException
	{
		Set<String> keys = tag.getKeys();
		for (String k : keys)
		{
			NBTTagElement element = tag.get(k);
			Serializer.writeByte(out, element.getType().getTag());
			Serializer.writeString(out, k);
			NBTTagElementSerializer.serialize(out, element);
		}
		Serializer.writeByte(out, (byte) 0);
	}

	public static NBTTagCompound deserialize(InputStream in) throws IOException
	{
		NBTTagCompound t = new NBTTagCompound();
		byte tag;
		while ((tag = Serializer.readByte(in)) != 0)
		{
			String k = Serializer.readString(in);
			NBTTagElement v = NBTTagElementSerializer.deserialize(in, tag);
			t.put(k, v);
		}
		return t;
	}
}
