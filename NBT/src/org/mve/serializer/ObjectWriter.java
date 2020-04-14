package org.mve.serializer;

import java.io.IOException;
import java.io.OutputStream;

public interface ObjectWriter<T>
{
	void write(OutputStream out, T obj) throws IOException;
}
