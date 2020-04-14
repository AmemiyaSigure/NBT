package org.mve.serializer.java.util;

import org.mve.serializer.ObjectReader;
import org.mve.serializer.ObjectWriter;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class MapSerializer
{
	public static <K, V> void serialize(OutputStream out, Map<K, V> map, ObjectWriter<K> key, ObjectWriter<V> value) throws IOException
	{
		Serializer.writeObject(out, map, (o, m) ->
		{
			Serializer.writeInt(o, m.size());
			for (Map.Entry<K, V> entry : m.entrySet())
			{
				key.write(o, entry.getKey());
				value.write(o, entry.getValue());
			}
		});
	}

	public static <K, V> Map<K, V> deserialize(InputStream in, Map<K, V> empty, ObjectReader<K> key, ObjectReader<V> value) throws IOException
	{
		return Serializer.readObject(in, i ->
		{
			int size = Serializer.readInt(i);
			for (int j = 0; j < size; j++) empty.put(key.read(i), value.read(i));
			return empty;
		});
	}
}
