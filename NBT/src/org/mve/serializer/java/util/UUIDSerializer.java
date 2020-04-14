package org.mve.serializer.java.util;

import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class UUIDSerializer extends Serializer
{
	public static void serialize(OutputStream out, UUID uuid) throws IOException
	{
		writeObject(out, uuid, (v1, v2) ->
		{
			writeLong(v1, v2.getMostSignificantBits());
			writeLong(v1, v2.getLeastSignificantBits());
		});
	}

	public static UUID deserialize(InputStream in) throws IOException
	{
		return readObject(in, (stream) -> new UUID(readLong(stream), readLong(stream)));
	}
}
