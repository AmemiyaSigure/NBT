package org.mve.net.minecraft.nbt;

public class NBTTagInteger implements NBTTagElement
{
	private int value;

	public NBTTagInteger(){}

	public NBTTagInteger(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_INT;
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.value);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagInteger)) return false;
		NBTTagInteger tag = (NBTTagInteger) obj;
		return tag.value == this.value;
	}
}
