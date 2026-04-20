package ReshmaApplication.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student s){
        return repo.save(s);
    }

    public List<Student> getAll(){
        return repo.findAll();
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public Student updateName(int id, String name){
        Student s = repo.findById(id).orElse(null);

        if(s != null){
            s.setName(name);
            return repo.save(s);
        }
        return null;
    }

    public Student addMarks(int id, Student marks){
        Student s = repo.findById(id).orElse(null);

        if(s != null){
            s.setEnglish(marks.getEnglish());
            s.setHindi(marks.getHindi());
            s.setPhysics(marks.getPhysics());
            s.setMath(marks.getMath());
            s.setChemistry(marks.getChemistry());
            s.setScience(marks.getScience());

            return repo.save(s);
        }
        return null;
    }
    public Student getTopper() {
        return repo.findAll()
                .stream()
                .max((s1, s2) -> {
                    int total1 = s1.getEnglish() + s1.getHindi() + s1.getPhysics() + s1.getMath() + s1.getChemistry() + s1.getScience();
                    int total2 = s2.getEnglish() + s2.getHindi() + s2.getPhysics() + s2.getMath() + s2.getChemistry() + s2.getScience();
                    return Integer.compare(total1, total2);
                })
                .orElse(null);
    }

    public Student getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
}