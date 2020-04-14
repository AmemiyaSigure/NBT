package org.mve.serializer.net.minecraft.nbt;

import org.mve.net.minecraft.nbt.NBTTagByte;
import org.mve.net.minecraft.nbt.NBTTagByteArray;
import org.mve.net.minecraft.nbt.NBTTagCompound;
import org.mve.net.minecraft.nbt.NBTTagDouble;
import org.mve.net.minecraft.nbt.NBTTagElement;
import org.mve.net.minecraft.nbt.NBTTagFloat;
import org.mve.net.minecraft.nbt.NBTTagInteger;
import org.mve.net.minecraft.nbt.NBTTagIntegerArray;
import org.mve.net.minecraft.nbt.NBTTagList;
import org.mve.net.minecraft.nbt.NBTTagLong;
import org.mve.net.minecraft.nbt.NBTTagLongArray;
import org.mve.net.minecraft.nbt.NBTTagShort;
import org.mve.net.minecraft.nbt.NBTTagString;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NBTTagElementSerializer
{
	public static void serialize(OutputStream out, NBTTagElement element) throws IOException
	{
		byte tag = element.getType().getTag();
		switch (tag)
		{
			case 0:
			{
				Serializer.writeByte(out, (byte) 0);
				break;
			}
			case 1:
			{
				NBTTagByteSerialize.serialize(out, (NBTTagByte) element);
				break;
			}
			case 2:
			{
				NBTTagShortSerializer.serialize(out, (NBTTagShort) element);
				break;
			}
			case 3:
			{
				NBTTagIntegerSerializer.serialize(out, (NBTTagInteger) element);
				break;
			}
			case 4:
			{
				NBTTagLongSerializer.serialize(out, (NBTTagLong) element);
				break;
			}
			case 5:
			{
				NBTTagFloatSerializer.serialize(out, (NBTTagFloat) element);
				break;
			}
			case 6:
			{
				NBTTagDoubleSerializer.serialize(out, (NBTTagDouble) element);
				break;
			}
			case 7:
			{
				NBTTagByteArraySerializer.serialize(out, (NBTTagByteArray) element);
				break;
			}
			case 8:
			{
				NBTTagStringSerializer.serialize(out, (NBTTagString) element);
				break;
			}
			case 9:
			{
				NBTTagListSerializer.serialize(out, (NBTTagList) element);
				break;
			}
			case 10:
			{
				NBTTagCompoundSerializer.serialize(out, (NBTTagCompound) element);
				break;
			}
			case 11:
			{
				NBTTagIntegerArraySerializer.serialize(out, (NBTTagIntegerArray) element);
				break;
			}
			case 12:
			{
				NBTTagLongArraySerializer.serialize(out, (NBTTagLongArray) element);
				break;
			}
		}
	}

	public static NBTTagElement deserialize(InputStream i, byte tag) throws IOException
	{
		switch (tag)
		{
			case 1: return NBTTagByteSerialize.deserialize(i);
			case 2: return NBTTagShortSerializer.deserialize(i);
			case 3: return NBTTagIntegerSerializer.deserialize(i);
			case 4: return NBTTagLongSerializer.deserialize(i);
			case 5: return NBTTagFloatSerializer.deserialize(i);
			case 6: return NBTTagDoubleSerializer.deserialize(i);
			case 7: return NBTTagByteArraySerializer.deserialize(i);
			case 8: return NBTTagStringSerializer.deserialize(i);
			case 9: return NBTTagListSerializer.deserialize(i);
			case 10: return NBTTagCompoundSerializer.deserialize(i);
			case 11: return NBTTagIntegerArraySerializer.deserialize(i);
			case 12: return NBTTagLongArraySerializer.deserialize(i);
			default: throw new NBTFormatException("Invalid tag type "+tag);
		}
	}
}
