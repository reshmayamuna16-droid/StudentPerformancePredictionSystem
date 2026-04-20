package ReshmaApplication.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartAPI {

    @Autowired
    private ChartService chartService;

    @Autowired
    private StudentService service;

    @GetMapping("/chart")
    public ResponseEntity<byte[]> chart() throws Exception {

        byte[] img = chartService.generateChart(service.getAll());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/png")
                .body(img);
    }
}