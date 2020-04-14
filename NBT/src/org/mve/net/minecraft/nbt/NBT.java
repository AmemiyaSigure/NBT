package org.mve.net.minecraft.nbt;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.mve.serializer.Serializer;
import org.mve.serializer.net.minecraft.nbt.NBTTagCompoundSerializer;
import org.mve.serializer.net.minecraft.nbt.NBTTagElementSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBT
{
	public static NBTTagElement read(File file)
	{
		InputStream in = null;
		try (InputStream i = new FileInputStream(file))
		{
			in = i;
			GZIPInputStream gzin = new GZIPInputStream(in);
			ByteArrayOutputStream bout = new ByteArrayOutputStream(gzin.available());
			byte[] b = new byte[1024];
			int len;
			while ((len = gzin.read(b, 0, 1024)) > -1) bout.write(b, 0, len);
			bout.flush();
			bout.close();
			ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
			byte tag = Serializer.readByte(bin);
			if (bin.skip(2) < 2) throw new EOFException();
			return NBTTagElementSerializer.deserialize(bin, tag);
		}
		catch (IOException e)
		{
			return new NBTTagCompound();
		}
		finally
		{
			if (in != null) try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void write(NBTTagElement element, File file)
	{
		OutputStream out = null;
		try (OutputStream o = new GZIPOutputStream(new FileOutputStream(file)))
		{
			out = o;
			Serializer.writeByte(out, element.getType().getTag());
			Serializer.writeShort(out, (short) 0);
			NBTTagElementSerializer.serialize(out, element);
			Serializer.writeByte(out, (byte) 0);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (out != null) try
			{
				out.flush();
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static JsonElement toJson(NBTTagElement element)
	{
		byte type = element.getType().getTag();
		switch (type)
		{
			case 1: return new JsonPrimitive(((NBTTagByte)element).getValue());
			case 2: return new JsonPrimitive(((NBTTagShort)element).getValue());
			case 3: return new JsonPrimitive(((NBTTagInteger)element).getValue());
			case 4: return new JsonPrimitive(((NBTTagLong)element).getValue());
			case 5: return new JsonPrimitive(((NBTTagFloat)element).getValue());
			case 6: return new JsonPrimitive(((NBTTagDouble)element).getValue());
			case 7:
			{
				JsonArray arr = new JsonArray();
				NBTTagByteArray tag = (NBTTagByteArray) element;
				for (int i = 0; i < tag.length(); i++) arr.add(new JsonPrimitive(tag.getValue(i)));
				return arr;
			}
			case 8: return new JsonPrimitive(((NBTTagString)element).getValue());
			case 9:
			{
				NBTTagList tag = (NBTTagList) element;
				JsonArray arr = new JsonArray();
				for (int i = 0; i < tag.length(); i++) arr.add(toJson(tag.getValue(i)));
				return arr;
			}
			case 10:
			{
				JsonObject json = new JsonObject();
				NBTTagCompound tag = (NBTTagCompound) element;
				Set<String> keys = tag.getKeys();
				for (String str : keys) json.add(str, toJson(tag.get(str)));
				return json;
			}
			case 11:
			{
				JsonArray arr = new JsonArray();
				NBTTagIntegerArray tag = (NBTTagIntegerArray) element;
				for (int i = 0; i < tag.length(); i++) arr.add(new JsonPrimitive(tag.getValue(i)));
				return arr;
			}
			case 12:
			{
				JsonArray arr = new JsonArray();
				NBTTagLongArray tag = (NBTTagLongArray) element;
				for (int i = 0; i < tag.length(); i++) arr.add(new JsonPrimitive(tag.getValue(i)));
				return arr;
			}
			default: return null;
		}
	}
}
