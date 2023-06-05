package hello.my_projectV1.subjectcode.controller;


import hello.my_projectV1.subjectcode.service.SubjectCodeService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjectCode")
@RequiredArgsConstructor
public class SubjectCodeController {

    private final SubjectCodeService subjectCodeService;

    /**
     * 생성
     */
    @PostMapping
    public int createSubject(@Param("subjectName") String subjectName) {
        return subjectCodeService.createSubject(subjectName);
    }

    /**
     * 수정
     */
    @PatchMapping
    public int updateSubjectNameBySeq(int subjectSeq, String subjectName) {
        return subjectCodeService.updateSubjectNameBySeq(subjectSeq, subjectName);
    }

    @DeleteMapping
    public int deleteSubjectBySeq(int subjectSeq) {
        return subjectCodeService.deleteSubjectBySeq(subjectSeq);
    }

}
