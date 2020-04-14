package org.mve.net.minecraft.nbt;

public class NBTTagDouble implements NBTTagElement
{
	private double value;

	public NBTTagDouble(){}

	public NBTTagDouble(double value)
	{
		this.value = value;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_DOUBLE;
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.value) + 'd';
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagDouble)) return false;
		NBTTagDouble tag = (NBTTagDouble) obj;
		return tag.value == this.value;
	}
}
