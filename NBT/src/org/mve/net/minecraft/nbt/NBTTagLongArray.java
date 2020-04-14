package org.mve.net.minecraft.nbt;

import java.util.Arrays;

public class NBTTagLongArray implements NBTTagElement
{
	private long[] value = new long[0];

	public NBTTagLongArray(){}

	public NBTTagLongArray(long[] value)
	{
		this.value = value;
	}

	public long getValue(int index)
	{
		return this.value[index];
	}

	public void setValue(int index, long value)
	{
		this.value[index] = value;
	}

	public void addValue(long value)
	{
		this.value = Arrays.copyOf(this.value, this.value.length+1);
		this.value[this.value.length-1] = value;
	}

	public int length()
	{
		return this.value.length;
	}

	public long[] getArray()
	{
		return this.value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_LONG_ARRAY;
	}

	@Override
	public String toString()
	{
		if (this.value.length == 0) return "[]";
		StringBuilder b = new StringBuilder().append('[');
		int end = this.value.length-1;
		for (int i = 0; i < this.value.length; i++)
		{
			b.append(this.value[i]).append('l');
			if (i == end)
			{
				b.append(']');
				break;
			}
			b.append(", ");
		}
		return b.toString();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagLongArray)) return false;
		NBTTagLongArray tag = (NBTTagLongArray) obj;
		return Arrays.equals(tag.value, this.value);
	}
}
