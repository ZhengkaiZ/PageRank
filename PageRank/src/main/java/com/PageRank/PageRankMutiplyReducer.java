/**
 * 
 */
package com.PageRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author Zhengkai Zhang
 *
 */
public class PageRankMutiplyReducer extends Reducer<Text, Text, Text, DoubleWritable> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		List<String> toStringList = new ArrayList<String>();
		Double constant = 0.0;
		for (Text value : values) {
			String temp = value.toString();
			if (temp.length() > 1) {
				toStringList.add(temp);
			} else {
				constant = Double.valueOf(temp);
			}
		}

		for (String s : toStringList) {
			String[] stringArray = s.split("=");
			Double tempDouble = Double.valueOf(stringArray[1]) * constant;
			context.write(new Text(stringArray[0]), new DoubleWritable(tempDouble));
		}
	}
}
