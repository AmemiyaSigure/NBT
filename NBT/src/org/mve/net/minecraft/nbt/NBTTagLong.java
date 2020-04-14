package org.mve.net.minecraft.nbt;

public class NBTTagLong implements NBTTagElement
{
	private long value;

	public NBTTagLong(){}

	public NBTTagLong(long value)
	{
		this.value = value;
	}

	public long getValue()
	{
		return value;
	}

	public void setValue(long value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_LONG;
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.value) + 'l';
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagLong)) return false;
		NBTTagLong tag = (NBTTagLong) obj;
		return tag.value == this.value;
	}
}
