import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HelloHDFS {

	public static void main(String[] args) throws Exception {
		/*URL url = new URL("http://www.baidu.com");
		InputStream in = url.openStream();
		org.apache.hadoop.io.IOUtils.copyBytes(in, System.out, 4096, true);*/
		
		/*URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		URL url = new URL("hdfs://192.168.56.100:9000/hello.txt");
		InputStream in = url.openStream();
		org.apache.hadoop.io.IOUtils.copyBytes(in, System.out, 4096, true);*/
		
		Configuration configuration = new Configuration();
		configuration.set("fs.defaultFS", "hdfs://192.168.56.100:9000");
		FileSystem fileSystem = FileSystem.get(configuration);
		
		//boolean success = fileSystem.mkdirs(new Path("/msb"));
		//System.out.println(success);
		/*boolean success = fileSystem.exists(new Path("/msb"));
		System.out.println(success);
		
		success = fileSystem.mkdirs(new Path("/msb"));
		System.out.println(success);
		
		success = fileSystem.delete(new Path("/msb"),true);
		System.out.println(success);
		*/
		FSDataOutputStream out = fileSystem.create(new Path("/test.data"),true);
		FileInputStream fis = new FileInputStream("c:/CrackCaptcha.log");
		IOUtils.copyBytes(fis, out, 4096,true);
		
		FileStatus[] statuses = fileSystem.listStatus(new Path("/"));
		for(FileStatus status :statuses){
			System.out.println(status.getPath());
			System.out.println(status.getPermission());
			System.out.println(status.getReplication());
		}
	}
}
