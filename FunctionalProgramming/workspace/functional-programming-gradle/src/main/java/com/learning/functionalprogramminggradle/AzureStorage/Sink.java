package com.learning.functionalprogramminggradle.AzureStorage;

import net.schmizz.sshj.xfer.LocalFileFilter;
import net.schmizz.sshj.xfer.LocalSourceFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
public class Sink implements LocalSourceFile {
    private String name;
    private long length;
    private InputStream inputStream;
    public Sink(String name, long length, InputStream inputStream) {
        this.name = name;
        this.length = length;
        this.inputStream = inputStream;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public long getLength() {
        return length;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        return inputStream;
    }
    @Override
    public int getPermissions() throws IOException {
        return 0644;
    }
    @Override
    public boolean isFile() {
        return true;
    }
    @Override
    public boolean isDirectory() {
        return false;
    }
    @Override
    public Iterable<? extends LocalSourceFile> getChildren(LocalFileFilter filter) throws IOException {
        throw new UnsupportedEncodingException("Not Implemented");
    }
    @Override
    public boolean providesAtimeMtime() {
        return false;
    }
    @Override
    public long getLastAccessTime() throws IOException {
        throw new UnsupportedEncodingException("Not Implemented");
    }
    @Override
    public long getLastModifiedTime() throws IOException {
        throw new UnsupportedEncodingException("Not Implemented");
    }
}
