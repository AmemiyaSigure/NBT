package org.mve.net.minecraft.nbt;

public class NBTTagString implements NBTTagElement
{
	private String value;

	public NBTTagString(){}

	public NBTTagString(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_STRING;
	}

	@Override
	public String toString()
	{
		StringBuilder stringbuilder = new StringBuilder("\"");

		for (int i = 0; i < this.value.length(); ++i)
		{
			char c0 = this.value.charAt(i);

			if (c0 == '\\' || c0 == '"')
			{
				stringbuilder.append('\\');
			}

			stringbuilder.append(c0);
		}

		return stringbuilder.append('"').toString();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (!(obj instanceof NBTTagString)) return false;
		NBTTagString tag = (NBTTagString) obj;
		return tag.value.equals(this.value);
	}
}
