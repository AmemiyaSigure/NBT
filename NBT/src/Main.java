import org.mve.net.minecraft.nbt.NBT;
import org.mve.net.minecraft.nbt.NBTTagCompound;

import java.io.File;

public class Main
{
	public static void main(String[] args)
	{
//		InflaterInputStream in = new InflaterInputStream(new FileInputStream("chunk.zl"));
//		FileOutputStream out = new FileOutputStream("chunk");
//		byte[] b = new byte[1024];
//		int len;
//		while ((len = in.read(b, 0, 1024)) > -1) out.write(b, 0, len);
//		in.close();
//		out.flush();
//		out.close();
//		FileInputStream in = new FileInputStream("chunk");
//		if (in.skip(3) != 3) return;
//		NBTTagCompound compound = NBTTagCompoundSerializer.deserialize(in);
//		System.out.println(in.available());
//		FileWriter writer = new FileWriter("chunk.json");
//		writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(toJson(compound)));
//		writer.flush();
//		writer.close();
//		in.close();
		NBTTagCompound t1 = (NBTTagCompound) NBT.read(new File("level.dat"));
		NBTTagCompound t2 = (NBTTagCompound) NBT.read(new File("l.dat"));
		System.out.println(t1.equals(t2));
	}
}
