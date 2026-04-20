package ReshmaApplication.demo;

import java.io.ByteArrayOutputStream;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public byte[] generateChart(List<Student> students) throws Exception {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Student s : students) {

            int total = s.getEnglish() + s.getHindi() + s.getPhysics()
                    + s.getMath() + s.getChemistry() + s.getScience();

            int avg = total / 6;

            dataset.addValue(avg, "Average Marks", s.getName());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Student Average Marks",
                "Student Name",
                "Marks",
                dataset
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ChartUtils.writeChartAsPNG(out, chart, 800, 600);

        return out.toByteArray();
    }

    public byte[] generatePdf(Student student) throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Create PDF
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Title
        document.add(new Paragraph("Student Report")
                .setBold()
                .setFontSize(18));

        // Student Details
        document.add(new Paragraph("ID: " + student.getId()));
        document.add(new Paragraph("Name: " + student.getName()));
        document.add(new Paragraph("Department: " + student.getDepartment()));

        document.add(new Paragraph(" ")); // space

        // Marks
        document.add(new Paragraph("Marks:"));
        document.add(new Paragraph("English: " + student.getEnglish()));
        document.add(new Paragraph("Hindi: " + student.getHindi()));
        document.add(new Paragraph("Physics: " + student.getPhysics()));
        document.add(new Paragraph("Math: " + student.getMath()));
        document.add(new Paragraph("Chemistry: " + student.getChemistry()));
        document.add(new Paragraph("Science: " + student.getScience()));

        // Average
        int total = student.getEnglish() + student.getHindi() + student.getPhysics()
                + student.getMath() + student.getChemistry() + student.getScience();

        int avg = total / 6;

        String grade = GradeUtil.grade(avg);
        String performance = GradeUtil.predict(avg);

        document.add(new Paragraph("Average: " + avg));
        document.add(new Paragraph("Grade: " + grade));
        document.add(new Paragraph("Performance: " + performance));

        document.add(new Paragraph(" ")); // space

        // CLOSE document
        document.close();

        // RETURN bytes
        return out.toByteArray();
    }
}