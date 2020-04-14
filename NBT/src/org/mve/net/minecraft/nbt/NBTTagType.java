package org.mve.net.minecraft.nbt;

public enum NBTTagType
{
	TAG_END(0),
	TAG_BYTE(1),
	TAG_SHORT(2),
	TAG_INT(3),
	TAG_LONG(4),
	TAG_FLOAT(5),
	TAG_DOUBLE(6),
	TAG_BYTE_ARRAY(7),
	TAG_STRING(8),
	TAG_LIST(9),
	TAG_COMPOUND(10),
	TAG_INT_ARRAY(11),
	TAG_LONG_ARRAY(12);

	private final byte tag;

	private NBTTagType(int tag)
	{
		this.tag = (byte) tag;
	}

	public byte getTag()
	{
		return tag;
	}

	public static NBTTagType getType(int tag)
	{
		switch (tag)
		{
			case 0: return TAG_END;
			case 1: return TAG_BYTE;
			case 2: return TAG_SHORT;
			case 3: return TAG_INT;
			case 4: return TAG_LONG;
			case 5: return TAG_FLOAT;
			case 6: return TAG_DOUBLE;
			case 7: return TAG_BYTE_ARRAY;
			case 8: return TAG_STRING;
			case 9: return TAG_LIST;
			case 10: return TAG_COMPOUND;
			case 11: return TAG_INT_ARRAY;
			case 12: return TAG_LONG_ARRAY;
			default: return null;
		}
	}

	public static NBTTagType getType(NBTTagElement element)
	{
		if (element instanceof NBTTagEnd) return TAG_END;
		else if (element instanceof NBTTagByte) return TAG_BYTE_ARRAY;
		else if (element instanceof NBTTagShort) return TAG_SHORT;
		else if (element instanceof NBTTagInteger) return TAG_INT;
		else if (element instanceof NBTTagLong) return TAG_LONG;
		else if (element instanceof NBTTagFloat) return TAG_FLOAT;
		else if (element instanceof NBTTagDouble) return TAG_DOUBLE;
		else if (element instanceof NBTTagByteArray) return TAG_BYTE_ARRAY;
		else if (element instanceof NBTTagString) return TAG_STRING;
		else if (element instanceof NBTTagList) return TAG_LIST;
		else if (element instanceof NBTTagCompound) return TAG_COMPOUND;
		else if (element instanceof NBTTagIntegerArray) return TAG_INT_ARRAY;
		else if (element instanceof NBTTagLongArray) return TAG_LONG_ARRAY;
		else return null;
	}
}
