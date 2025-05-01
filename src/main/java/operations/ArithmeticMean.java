package operations;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class ArithmeticMean implements Operation {

    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Double> result = new ArrayList<>();

    public ArithmeticMean(ArrayList<ArrayList<Double>> list) {
        this.list = list;
        this.name = "Среднее арифметическое";
        calculate();
    }

    @Override
    public void calculate() {
        ArrayList<DescriptiveStatistics> stats = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            stats.add(new DescriptiveStatistics());
            list.get(i).forEach(stats.get(i)::addValue);
            result.add(stats.get(i).getMean());
        }
    }

    @Override
    public ArrayList<Double> getResult() {
        return result;
    }

    public String getName() {
        return name;
    }
}
