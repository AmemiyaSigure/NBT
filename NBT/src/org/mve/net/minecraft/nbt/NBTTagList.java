package org.mve.net.minecraft.nbt;

import java.util.Arrays;
import java.util.Objects;

public class NBTTagList implements NBTTagElement
{
	private byte type;
	private NBTTagElement[] value = new NBTTagElement[0];

	public NBTTagList(byte type)
	{
		this.type = type;
	}

	public NBTTagList(byte type, NBTTagElement[] value)
	{
		this.type = type;
		this.value = Objects.requireNonNull(value);
	}

	public byte getComponentType()
	{
		return type;
	}

	public NBTTagElement getValue(int index)
	{
		return this.value[index];
	}

	public void setValue(int index, NBTTagElement value)
	{
		this.value[index] = value;
	}

	public void addValue(NBTTagElement value)
	{
		if (value.getType().getTag() != this.type) return;
		this.value = Arrays.copyOf(this.value, this.value.length+1);
		this.value[this.value.length-1] = value;
	}

	public int length()
	{
		return this.value.length;
	}

	public NBTTagElement[] getArray()
	{
		return this.value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_LIST;
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
		if (!(obj instanceof NBTTagList)) return false;
		NBTTagList tag = (NBTTagList) obj;
		if (tag.type != this.type) return false;
		return Arrays.equals(tag.value, this.value);
	}
}
