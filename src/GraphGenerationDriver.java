//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.io.File;
//import java.io.IOException;
//
//import javax.swing.*;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;

public class GraphGenerationDriver
//        extends JFrame
{

//	public GraphGenerationDriver() {
//		super("XY Line Chart Example with JFreechart");
//
//		JPanel chartPanel = createChartPanel();
//		add(chartPanel, BorderLayout.CENTER);
//
//		setSize(640, 480);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//	}
//
//	private JPanel createChartPanel() {
//		String chartTitle = "Accuracy (%) v/s m";
//		String xAxisLabel = "accuracy in %";
//		String yAxisLabel = "m value";
//
////		DriverPart2.main(new String[]{""});
//
////		XYDataset dataset = createDatasetPart2();
//		XYDataset dataset = createDatasetPart3();
//
//		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
//				xAxisLabel, yAxisLabel, dataset, PlotOrientation.HORIZONTAL, true, true, false);
//
//		customizeChart(chart);
//
//		// saves the chart as an image files
//		File imageFile = new File("XYLineChart.png");
//		int width = 640;
//		int height = 480;
//
//		try {
//			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
//		} catch (IOException ex) {
//			System.err.println(ex);
//		}
//
//		return new ChartPanel(chart);
//	}
//
//	private XYDataset createDatasetPart2() {
//
//		XYSeriesCollection dataset = new XYSeriesCollection();
//
//		XYSeries series1 = new XYSeries("min", false, true);
//		XYSeries series2 = new XYSeries("avg", false, true);
//		XYSeries series3 = new XYSeries("max", false, true);
//
//		series1.add(DriverPart2.minAccurancyArray[0], 5.0);
//		series1.add(DriverPart2.minAccurancyArray[1], 10.0);
//		series1.add(DriverPart2.minAccurancyArray[2], 20.0);
//		series1.add(DriverPart2.minAccurancyArray[3], 50.0);
//		series1.add(DriverPart2.minAccurancyArray[4], 100.0);
//
//		series2.add(DriverPart2.avgAccurancyArray[0], 5.0);
//		series2.add(DriverPart2.avgAccurancyArray[1], 10.0);
//		series2.add(DriverPart2.avgAccurancyArray[2], 20.0);
//		series2.add(DriverPart2.avgAccurancyArray[3], 50.0);
//		series2.add(DriverPart2.avgAccurancyArray[4], 100.0);
//
//		series3.add(DriverPart2.maxAccurancyArray[0], 5.0);
//		series3.add(DriverPart2.maxAccurancyArray[1], 10.0);
//		series3.add(DriverPart2.maxAccurancyArray[2], 20.0);
//		series3.add(DriverPart2.maxAccurancyArray[3], 50.0);
//		series3.add(DriverPart2.maxAccurancyArray[4], 100.0);
//
//		dataset.addSeries(series1);
//		dataset.addSeries(series2);
//		dataset.addSeries(series3);
//
//		return dataset;
//	}
//
//	private XYDataset createDatasetPart3() {
//
//		XYSeriesCollection dataset = new XYSeriesCollection();
//
//		XYSeries series1 = new XYSeries("heart", false, true);
//		XYSeries series2 = new XYSeries("diabetes", false, true);
//
//		Driver.main(new String[]{"heart_train.arff", "heart_test.arff", "2"});
//		series1.add(Driver.accurracy, 2.0);
//		Driver.main(new String[]{"heart_train.arff", "heart_test.arff", "5"});
//		series1.add(Driver.accurracy, 5.0);
//		Driver.main(new String[]{"heart_train.arff", "heart_test.arff", "10"});
//		series1.add(Driver.accurracy, 10.0);
//		Driver.main(new String[]{"heart_train.arff", "heart_test.arff", "20"});
//		series1.add(Driver.accurracy, 20.0);
//
//		Driver.main(new String[]{"diabetes_train.arff", "diabetes_test.arff", "2"});
//		series2.add(Driver.accurracy, 2.0);
//		Driver.main(new String[]{"diabetes_train.arff", "diabetes_test.arff", "5"});
//		series2.add(Driver.accurracy, 5.0);
//		Driver.main(new String[]{"diabetes_train.arff", "diabetes_test.arff", "10"});
//		series2.add(Driver.accurracy, 10.0);
//		Driver.main(new String[]{"diabetes_train.arff", "diabetes_test.arff", "20"});
//		series2.add(Driver.accurracy, 20.0);
//
//		dataset.addSeries(series1);
//		dataset.addSeries(series2);
//
//		return dataset;
//	}
//
//	private void customizeChart(JFreeChart chart) {
//
//		XYPlot plot = chart.getXYPlot();
//		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//
//		// sets renderer for lines
//		plot.setRenderer(renderer);
//
//		// sets plot background
//		plot.setBackgroundPaint(Color.BLACK);
//
//		// sets paint color for the grid lines
//		plot.setRangeGridlinesVisible(true);
//		plot.setRangeGridlinePaint(Color.BLACK);
//
//		plot.setDomainGridlinesVisible(true);
//		plot.setDomainGridlinePaint(Color.BLACK);
//
//	}
//
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				new GraphGenerationDriver().setVisible(true);
//			}
//		});
//	}
}