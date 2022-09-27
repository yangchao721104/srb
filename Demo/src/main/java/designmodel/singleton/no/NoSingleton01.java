package designmodel.singleton.no;

import java.io.*;

/**
 * 测试用序列化破坏单例模式
 * @author yang
 * @date 2022/8/7 12:40
 */
public class NoSingleton01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writeObjectFile();
        readObjectFile();
        readObjectFile();
    }
    //1从文件读取数据对象
    public static void readObjectFile() throws IOException, ClassNotFoundException {
        //创建对象输入流
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\a.txt"));
        //读取对象
        Object readObject = inputStream.readObject();
        System.out.println(readObject);

        inputStream.close();
    }
    //解决序列化破坏单例


    //2创建对象输出流对象
    public static void writeObjectFile() throws IOException {
        //获取singleton对象
        Singleton07 instance = Singleton07.getInstance();
        //创建对象输出流对象
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\a.txt"));
        //写对象
        outputStream.writeObject(instance);
        //释放资源
        outputStream.close();

    }
}
