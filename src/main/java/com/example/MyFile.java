package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFile
{
    private  FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public File open(String dir) throws MyException
    {
        File myFile = new File(dir);

        if(!myFile.exists()) {
            throw new MyException("Такого католога не существует");
        }

        return myFile;
    }

    public File open(String dir, String file) throws MyException
    {
        File myFile = new File(dir, file);

        if(!myFile.exists()) {
            throw new MyException("Такого файла не существует");
        }

        return myFile;
    }
    
    public void read( File file ) throws MyException, IOException
    {
        if( file == null ){
            throw new MyException("Переданый объект не может быть пустым!");
        }
        
        this.fileInputStream = new FileInputStream(file);
        
        int i;

        while ((i = fileInputStream.read()) != -1)
        {
            System.out.print((char)i);
        }
        System.out.println();
    }

    public void write(File file, String text) throws MyException, IOException
    {
        if( file == null ){
            throw new MyException("Переданый объект не может быть пустым!");
        }
        this.fileOutputStream = new FileOutputStream(file);
        this.fileOutputStream.write(text.getBytes());
    }

    public void write(File file, String text, boolean append) throws MyException, IOException
    {
        if( file == null ){
            throw new MyException("Переданый объект не может быть пустым!");
        }
        this.fileOutputStream = new FileOutputStream(file, append);
        this.fileOutputStream.write("\n".getBytes());
        this.fileOutputStream.write(text.getBytes());
    }

    public void close() throws MyException, IOException
    {
        if (this.fileInputStream != null) this.fileInputStream.close();
        if (this.fileOutputStream != null) this.fileOutputStream.close();
    }
}
