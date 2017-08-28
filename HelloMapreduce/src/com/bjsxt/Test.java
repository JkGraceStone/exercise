package com.bjsxt;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Test {
	public static void main(String[] args) throws Exception{
		Configuration configuration  = new Configuration();
		
		//这个是在远程操作要加入的代码--开始
		configuration.set("fs.defalutFS","hdfs://master:9000");
		configuration.set("mapreduce.job.jar", "wc.jar");
		configuration.set("mapreduce.framework.name", "yarn");
		configuration.set("yarn.resourcemanager.hostname", "master");
		configuration.set("mapreduce.app-submission.cross-platform", "ture");
		//这个是在远程操作要加入的代码--结束
		
		Job job = Job.getInstance(configuration);
		
		job.setMapperClass(WordMapper.class);
		job.setReducerClass(WordReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		
		
		/*FileInputFormat.setInputPaths(job, "d:/test.txt");
		FileOutputFormat.setOutputPath(job, new Path("d:/out/"));*/
		FileInputFormat.setInputPaths(job, "hdfs://master:9000/wcinput/");
		FileOutputFormat.setOutputPath(job, new Path("hdfs://master:9000/wcoutput1"));
		
		System.out.println("hello!");
		job.waitForCompletion(true);
		
	}

}
