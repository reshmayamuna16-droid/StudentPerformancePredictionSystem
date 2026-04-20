package ReshmaApplication.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final ChartService chartService;
    private final StudentService service;

    public StudentController(ChartService chartService, StudentService service) {
        this.chartService = chartService;
        this.service = service;
    }

    //  CHART API (FIXED)
    @PostMapping("/students/chart")
    public ResponseEntity<byte[]> getChart() throws Exception {

        List<Student> students = service.getAll();

        ChartService pdfService = null;
        byte[] chart = pdfService.generateChart(students);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=chart.png")
                .body(chart);
    }
    // ADD STUDENT
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student Added";
    }

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Deleted";
    }

    // UPDATE NAME
    @PutMapping("/updateName/{id}/{name}")
    public String updateName(@PathVariable int id, @PathVariable String name) {
        service.updateName(id, name);
        return "Updated";
    }

    // TOPPER
    @GetMapping("/topper")
    public Student getTopper() {
        return service.getTopper();
    }
}