package ReshmaApplication.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PdfController {

    @Autowired
    private StudentService service;

    @Autowired
    private PdfService pdfService;

    @PostMapping("/students/chart")
    public ResponseEntity<byte[]> getChart() throws Exception {

        List<Student> students = service.getAll();

        byte[] chart = pdfService.generateChart(students);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=chart.png")
                .body(chart);
    }
    @GetMapping("/students/pdf/{id}")
    public ResponseEntity<byte[]> getPdf(@PathVariable int id) throws Exception {

        Student student = service.getById(id);

        byte[] pdf = pdfService.generatePdf(student);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=student.pdf")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(pdf);
    }

}