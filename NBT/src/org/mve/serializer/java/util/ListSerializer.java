package org.mve.serializer.java.util;

import org.mve.serializer.ObjectReader;
import org.mve.serializer.ObjectWriter;
import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class ListSerializer
{
	public static <T> void serialize(OutputStream out, List<T> list, ObjectWriter<T> action) throws IOException
	{
		Serializer.writeObject(out, list, (o, l) ->
		{
			int size = l.size();
			Serializer.writeInt(o, size);
			for (T t : l) action.write(o, t);
		});
	}

	public static <T> List<T> deserialize(InputStream in, List<T> empty, ObjectReader<T> action) throws IOException
	{
		return Serializer.readObject(in, i ->
		{
			int size = Serializer.readInt(i);
			for (int j = 0; j < size; j++) empty.add(action.read(i));
			return empty;
		});
	}
}
