package org.mve.net.minecraft.nbt;

import java.util.Arrays;

public class NBTTagByteArray implements NBTTagElement
{
	private byte[] value = new byte[0];

	public NBTTagByteArray(){}

	public NBTTagByteArray(byte[] value)
	{
		this.value = value;
	}

	public byte getValue(int index)
	{
		return value[index];
	}

	public void setValue(int index, byte b)
	{
		this.value[index] = b;
	}

	public void addValue(byte b)
	{
		this.value = Arrays.copyOf(this.value, this.value.length+1);
		this.value[this.value.length-1] = b;
	}

	public int length()
	{
		return this.value.length;
	}

	public byte[] getArray()
	{
		return this.value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_BYTE_ARRAY;
	}

	@Override
	public String toString()
	{
		if (this.value.length == 0) return "[]";
		StringBuilder builder = new StringBuilder().append('[');
		int end = value.length-1;
		for (int i = 0; i < value.length; i++)
		{
			builder.append(String.valueOf(this.value[i])).append('b');
			if (i == end)
			{
				builder.append(']');
				break;
			}
			builder.append(", ");
		}
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagByteArray)) return false;
		NBTTagByteArray tag = (NBTTagByteArray) obj;
		return Arrays.equals(this.value, tag.value);
	}
}
