package org.mve.serializer.java;

import org.mve.serializer.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BoxingTypeSerializer
{
	public static Boolean readBoolean(InputStream in) throws IOException
	{
		return Serializer.readObject(in, Serializer::readBoolean);
	}

	public static void writeBoolean(OutputStream out, Boolean v) throws IOException
	{
		Serializer.writeObject(out, v, Serializer::writeBoolean);
	}

	public static Integer readInteger(InputStream in) throws IOException
	{
		return Serializer.readObject(in, Serializer::readInt);
	}

	public static void writeInteger(OutputStream out, Integer integer) throws IOException
	{
		Serializer.writeObject(out, integer, Serializer::writeInt);
	}

	public static void writeShort(OutputStream out, Short s) throws IOException
	{
		Serializer.writeObject(out, s, Serializer::writeShort);
	}

	public static Short readShort(InputStream in) throws IOException
	{
		return Serializer.readObject(in, Serializer::readShort);
	}
}
