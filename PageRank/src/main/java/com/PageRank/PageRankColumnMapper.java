/**
 * 
 */
package com.PageRank;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author Zhengkai Zhang
 *
 */
public class PageRankColumnMapper extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] input = value.toString().split("\t");
		context.write(new Text(input[0]), new Text(input[1]));
	}

}
