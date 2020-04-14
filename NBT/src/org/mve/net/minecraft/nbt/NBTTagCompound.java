package org.mve.net.minecraft.nbt;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class NBTTagCompound implements NBTTagElement
{
	private LinkedHashMap<String, NBTTagElement> map = new LinkedHashMap<>();

	public void put(String name, NBTTagElement value)
	{
		this.map.put(Objects.requireNonNull(name), Objects.requireNonNull(value));
	}

	public NBTTagElement get(String name)
	{
		return this.map.get(Objects.requireNonNull(name));
	}

	public Set<String> getKeys()
	{
		return map.keySet();
	}

	@Override
	public NBTTagType getType()
	{
		return NBTTagType.TAG_COMPOUND;
	}

	@Override
	public String toString()
	{
		Iterator<Map.Entry<String, NBTTagElement>> iterator = this.map.entrySet().iterator();
		if (!iterator.hasNext()) return "{}";
		StringBuilder builder = new StringBuilder().append('{');
		while (true)
		{
			Map.Entry<String, NBTTagElement> entry = iterator.next();
			String k = entry.getKey();
			NBTTagElement v = entry.getValue();
			builder.append(k).append(':').append(v);
			if (!iterator.hasNext()) return builder.append('}').toString();
			builder.append(", ");
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if(!(obj instanceof NBTTagCompound)) return false;
		NBTTagCompound tag = (NBTTagCompound) obj;
		return tag.map.equals(this.map);
	}
}
