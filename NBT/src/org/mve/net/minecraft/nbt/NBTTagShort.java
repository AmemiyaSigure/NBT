package org.mve.net.minecraft.nbt;

public class NBTTagShort implements NBTTagElement
{
	private short value;

	public NBTTagShort(){}

	public NBTTagShort(short value)
	{
		this.value = value;
	}

	public short getValue()
	{
		return value;
	}

	public void setValue(short value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_SHORT;
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.value) + 's';
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagShort)) return false;
		NBTTagShort tag = (NBTTagShort) obj;
		return tag.value == this.value;
	}
}
