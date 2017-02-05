package org.apache.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyWordCount {
	public static class TokenizerMapper extends Mapper<Object,Text,Text,IntWritable>{

		@Override
		protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			super.map(key, value, context);
		}
		
		
		
	}
}
