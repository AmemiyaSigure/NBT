package org.mve.net.minecraft.nbt;

public class NBTTagByte implements NBTTagElement
{
	private byte value;

	public NBTTagByte(){}

	public NBTTagByte(byte value)
	{
		this.value = value;
	}

	public byte getValue()
	{
		return value;
	}

	public void setValue(byte value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_BYTE;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagByte)) return false;
		NBTTagByte tag = (NBTTagByte) obj;
		return tag.value == this.value;
	}

	@Override
	public String toString()
	{
		return this.value+"b";
	}
}
