package org.example;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class VentesMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {
        String venteAnnee[] = value.toString().split(" ");
        String villeAnnee=venteAnnee[0].substring(6)+" "+venteAnnee[1];
        double prix =Double.parseDouble(venteAnnee[3]);
        context.write(new Text(villeAnnee), new DoubleWritable(prix));

    }
}
