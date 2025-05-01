package operations;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class VarianceCoefficient implements Operation {

    String name;
    ArrayList<ArrayList<Double>> list;
    ArrayList<Double> result = new ArrayList<>();

    public VarianceCoefficient(ArrayList<ArrayList<Double>> list) {
        this.list = list;
        this.name = "Коэффициент вариации";
        calculate();
    }

    public void calculate() {
        ArrayList<DescriptiveStatistics> stats = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            stats.add(new DescriptiveStatistics());
            list.get(i).forEach(stats.get(i)::addValue);
            result.add(stats.get(i).getStandardDeviation() / stats.get(i).getMean());
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
