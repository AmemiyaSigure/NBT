package org.mve.serializer;

import java.io.IOException;
import java.io.InputStream;

public interface ObjectReader<T>
{
	T read(InputStream in) throws IOException;
}
