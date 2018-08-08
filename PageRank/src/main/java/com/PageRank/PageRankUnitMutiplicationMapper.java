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
public class PageRankUnitMutiplicationMapper extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] stringSplit = value.toString().split("\t");
		String from = stringSplit[0];
		String[] to = stringSplit[1].split(",");
		double length = to.length;
		for (int i = 0; i < length; i++) {
			context.write(new Text(from), new Text(to[i] + "=" + Double.toString(1/length)));
		}
	}
}
