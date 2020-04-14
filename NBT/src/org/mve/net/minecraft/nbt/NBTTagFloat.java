package org.mve.net.minecraft.nbt;

public class NBTTagFloat implements NBTTagElement
{
	private float value;

	public NBTTagFloat(){}

	public NBTTagFloat(float value)
	{
		this.value = value;
	}

	public float getValue()
	{
		return value;
	}

	public void setValue(float value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_FLOAT;
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.value) + 'f';
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagFloat)) return false;
		NBTTagFloat tag = (NBTTagFloat) obj;
		return tag.value == this.value;
	}
}
