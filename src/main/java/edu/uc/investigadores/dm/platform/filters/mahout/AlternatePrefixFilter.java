/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform.filters.mahout;

import com.google.common.io.Closeables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.mahout.common.iterator.FileLineIterable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import org.apache.mahout.text.ChunkedWriter;
import org.apache.mahout.text.PrefixAdditionFilter;
import org.apache.mahout.text.SequenceFilesFromDirectoryFilter;

/**
 * Alternate parser for parsing text into sequence files.
 *
 * @author cuent
 */
public final class AlternatePrefixFilter extends SequenceFilesFromDirectoryFilter {

    public AlternatePrefixFilter(Configuration conf,
            String keyPrefix,
            Map<String, String> options,
            ChunkedWriter writer,
            Charset charset,
            FileSystem fs) throws IOException {
        super(conf, keyPrefix, options, writer);
    }

    public FileSystem getFs() {
        return fs;
    }

    public ChunkedWriter getWriter() {
        return writer;
    }

    public String getPrefix() {
        return prefix;
    }

    public Charset getCharset() {
        return charset;
    }

    @Override
    protected void process(FileStatus fst, Path current) throws IOException {
        FileSystem fs = getFs();
        ChunkedWriter writer = getWriter();
        if (fst.isDir()) {
            String dirPath = getPrefix() + Path.SEPARATOR + current.getName() + Path.SEPARATOR + fst.getPath().getName();
            fs.listStatus(fst.getPath(),
                    new PrefixAdditionFilter(getConf(), dirPath, getOptions(), getWriter()));
        } else {
            InputStream in = null;
            try {
                in = fs.open(fst.getPath());

                StringBuilder file = new StringBuilder();
                for (String aFit : new FileLineIterable(in, getCharset(), false)) {
                    file.append(aFit).append('\n');
                }
                String name = current.getName().equals(fst.getPath().getName())
                        ? current.getName()
                        : current.getName() + Path.SEPARATOR + fst.getPath().getName();
                writer.write(getPrefix() + Path.SEPARATOR + name, file.toString());
            } finally {
                Closeables.close(in, false);
            }
        }
    }

}
