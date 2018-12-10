package com.apress.projsp;

import java.io.*;
import javax.servlet.*;

public abstract class ReplaceContentOutputStream
    extends ServletOutputStream
{
  byte[] result;
  private ByteArrayOutputStream baStream;
  private boolean closed = false;

  public ReplaceContentOutputStream() {
    baStream = new ByteArrayOutputStream();
  }

  public void write(int i) throws java.io.IOException {
    baStream.write(i);
  }

  public void close() throws java.io.IOException {
    if (!closed) {
      processStream();
      closed = true;
    }
  }

  public abstract byte[] replaceContent(byte[] inBytes)
      throws java.io.IOException;

  public void processStream() throws java.io.IOException {
    result = replaceContent(baStream.toByteArray());
  }

  public byte[] getResult() {
    return result;
  }
}
