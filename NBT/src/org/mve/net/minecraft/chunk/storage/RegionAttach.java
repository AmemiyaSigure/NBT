package org.mve.net.minecraft.chunk.storage;

import org.mve.net.minecraft.nbt.NBTTagCompound;
import org.mve.serializer.net.minecraft.nbt.NBTTagCompoundSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class RegionAttach
{
	private final int[] offset = new int[1024];
	private final int[] chunkTimestamps = new int[1024];
	private NBTTagCompound[] nbt;
	private boolean[] sectorFree;

	public RegionAttach(File mca) throws IOException
	{
		int count = (int) (mca.length() / 4096 - 2);
		this.nbt = new NBTTagCompound[count];
		this.sectorFree = new boolean[count];
		Arrays.fill(sectorFree, true);

		DataInputStream mcaInput = new DataInputStream(new FileInputStream(mca));

		for (int i = 0; i < 1024; i++) this.offset[i] = mcaInput.readInt();
		for (int i = 0; i < 1024; i++) this.chunkTimestamps[i] = mcaInput.readInt();

		for (int i = 0; i < count; i++)
		{
			int alignedDataLength = (this.offset[i] & 0XFF) * 4096;
			byte[] chunkAlignedData = new byte[alignedDataLength];
			if (mcaInput.read(chunkAlignedData) < alignedDataLength) throw new EOFException();
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(chunkAlignedData));
			int length = in.readInt() - 1;
			byte compressType = in.readByte();
			byte[] chunkCompressedData = new byte[length];
			if (in.read(chunkCompressedData) < length) throw new EOFException();
			in.close();
			InputStream uncompresser;
			switch (compressType)
			{
				case 1:
				{
					uncompresser = new GZIPInputStream(new ByteArrayInputStream(chunkCompressedData));
					break;
				}
				case 2:
				{
					uncompresser = new InflaterInputStream(new ByteArrayInputStream(chunkCompressedData));
					break;
				}
				default:
				{
					uncompresser = new ByteArrayInputStream(new byte[0]);
					break;
				}
			}
			ByteArrayOutputStream chunkDataBuffer = new ByteArrayOutputStream(uncompresser.available());
			byte[] b = new byte[128];
			int len;
			while ((len = uncompresser.read(b, 0, 128)) > -1) chunkDataBuffer.write(b, 0, len);
			uncompresser.close();
			chunkDataBuffer.flush();
			chunkDataBuffer.close();
			byte[] chunkData = chunkDataBuffer.toByteArray();
			ByteArrayInputStream chunkDataInput = new ByteArrayInputStream(chunkData);
			if (chunkDataInput.skip(3) != 3) throw new EOFException();
			NBTTagCompound chunkNBT = NBTTagCompoundSerializer.deserialize(chunkDataInput);
			this.nbt[i] = chunkNBT;
		}
		mcaInput.close();
	}

	public NBTTagCompound getChunkNBT(int x, int z)
	{
	}
}
