package org.mve.net.minecraft.nbt;

import java.util.Arrays;

public class NBTTagIntegerArray implements NBTTagElement
{
	private int[] value = new int[0];

	public NBTTagIntegerArray(){}

	public NBTTagIntegerArray(int[] value)
	{
		this.value = value;
	}

	public int getValue(int index)
	{
		return this.value[index];
	}

	public void setValue(int index, int value)
	{
		this.value[index] = value;
	}

	public void addValue(int value)
	{
		this.value = Arrays.copyOf(this.value, this.value.length+1);
		this.value[this.value.length-1] = value;
	}

	public int length()
	{
		return this.value.length;
	}

	public int[] getArray()
	{
		return this.value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_INT_ARRAY;
	}

	@Override
	public String toString()
	{
		return Arrays.toString(this.value);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagIntegerArray)) return false;
		NBTTagIntegerArray tag = (NBTTagIntegerArray) obj;
		return Arrays.equals(tag.value, this.value);
	}
}
