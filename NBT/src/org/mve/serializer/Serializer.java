package org.mve.serializer;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Serializer
{
	public static byte readByte(InputStream in) throws IOException
	{
		byte[] b = new byte[1];
		read(in, b);
		return b[0];
	}

	public static void writeByte(OutputStream out, byte b) throws IOException
	{
		byte[] bytes = {b};
		out.write(bytes);
	}

	public static short readShort(InputStream in) throws IOException
	{
		short num = 0;
		byte[] b = new byte[2];
		read(in, b);
		for (int i=1; i>-1; i--)
		{
			num ^= ((b[1-i] & 0xFF) << (8 * i));
		}
		return num;
	}

	public static void writeShort(OutputStream out, short num) throws IOException
	{
		byte[] b = new byte[2];
		for (int i=1; i>-1; i--)
		{
			b[1-i] = (byte)(num >>> (8 * i));
		}
		out.write(b);
	}

	public static int readInt(InputStream in) throws IOException
	{
		int num = 0;
		byte[] bytes = new byte[4];
		read(in, bytes);
		for (int i=3; i>-1; i--)
		{
			num ^= ((bytes[3-i] & 0xFFL) << (8 * i));
		}
		return num;
	}

	public static void writeInt(OutputStream out, int num) throws IOException
	{
		byte[] bytes = new byte[4];
		for (int i=3; i>-1; i--)
		{
			bytes[3-i] = (byte)(num >>> (8 * i));
		}
		out.write(bytes);
	}

	public static long readLong(InputStream in) throws IOException
	{
		long num = 0;
		byte[] bytes = new byte[8];
		read(in, bytes);
		for (int i=7; i>-1; i--)
		{
			num ^= ((bytes[7-i] & 0xFFL) << (8 * i));
		}
		return num;
	}

	public static void writeLong(OutputStream out, long num) throws IOException
	{
		byte[] bytes = new byte[8];
		for (int i=7; i>-1; i--)
		{
			bytes[7-i] = (byte)(num >>> (8 * i));
		}
		out.write(bytes);
	}

	public static float readFloat(InputStream in) throws IOException
	{
		return Float.intBitsToFloat(readInt(in));
	}

	public static void writeFloat(OutputStream out, float f) throws IOException
	{
		writeInt(out, Float.floatToIntBits(f));
	}

	public static double readDouble(InputStream in) throws IOException
	{
		return Double.longBitsToDouble(readLong(in));
	}

	public static void writeDouble(OutputStream out, double v) throws IOException
	{
		writeLong(out, Double.doubleToLongBits(v));
	}

	public static boolean readBoolean(InputStream in) throws IOException
	{
		byte b = readByte(in);
		return b == 1;
	}

	public static void writeBoolean(OutputStream out, boolean b) throws IOException
	{
		writeByte(out, (byte)(b ? 1 : 0));
	}

	public static char readChar(InputStream in) throws IOException
	{
		return (char) readShort(in);
	}

	public static void writeChar(OutputStream out, char c) throws IOException
	{
		writeShort(out, (short) c);
	}

	public static <T> T readObject(InputStream in, ObjectReader<T> reader) throws IOException
	{
		if (readable(in))
		{
			try
			{
				return reader.read(in);
			}
			catch (Exception e)
			{
				throw new IOException("Deserialize exception", e);
			}
		}
		return null;
	}

	public static <T> void writeObject(OutputStream out, T obj, ObjectWriter<T> writer) throws IOException
	{
		if (writable(out, obj))
		{
			try
			{
				writer.write(out, obj);
			}
			catch (Exception e)
			{
				throw new IOException("Serialize exception", e);
			}
		}
	}

	public static String readString(InputStream in) throws IOException
	{
		int length = readShort(in) & 0XFFFF;
		byte[] bytes = new byte[length];
		read(in, bytes);
		return new String(bytes, StandardCharsets.UTF_8);
	}

	public static void writeString(OutputStream out, String str) throws IOException
	{
		byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
		short length = (short) bytes.length;
		writeShort(out, length);
		out.write(bytes);
	}

	private static void read(InputStream in, byte[] bytes) throws IOException
	{
		int available = in.read(bytes, 0, bytes.length);
		if (available < 0) throw new EOFException();
	}

	private static boolean writable(OutputStream out, Object obj) throws IOException
	{
		boolean notNull = obj != null;
		writeBoolean(out, notNull);
		return notNull;
	}

	private static boolean readable(InputStream in) throws IOException
	{
		return readBoolean(in);
	}
}
