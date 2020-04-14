package org.mve.net.minecraft.nbt;

public class NBTTagEnd implements NBTTagElement
{
	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_END;
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof NBTTagEnd;
	}
}
