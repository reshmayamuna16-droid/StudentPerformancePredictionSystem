package ReshmaApplication.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ChartService {

    private final StudentRepository repo;

    public ChartService(StudentRepository repo) {
        this.repo = repo;
    }

    public byte[] generateChart(List<Student> students) throws Exception {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Student s : students) {
            int total = s.getEnglish() + s.getHindi() + s.getPhysics()
                    + s.getMath() + s.getChemistry() + s.getScience();

            dataset.addValue(total, "Marks", s.getName());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Student Marks",
                "Students",
                "Total Marks",
                dataset
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ChartUtils.writeChartAsPNG(out, chart, 800, 600);

        return out.toByteArray();
    }
}