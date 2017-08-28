package com.bjsxt;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.yarn.server.resourcemanager.webapp.dao.NewApplication;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		final IntWritable ONE = new IntWritable(1);
		String line = value.toString();
		String[] wordsStrings = line.split(" ");
		for(String word :wordsStrings){
			//context.write(new Text(word), new IntWritable(1));
			context.write(new Text(word), ONE );
		}
	}

}
