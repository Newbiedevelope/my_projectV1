package hello.my_projectV1.subjectcode.controller;


import hello.my_projectV1.subjectcode.service.SubjectCodeService;
import hello.my_projectV1.subjectcode.vo.SubjectCodeVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-code")
@RequiredArgsConstructor
public class SubjectCodeController {

    private final SubjectCodeService subjectCodeService;

    /**
     * 과목 생성
     */
    @PostMapping
    public int createSubject(@Param("subjectName") String subjectName) {
        return subjectCodeService.createSubject(subjectName);
    }

    /**
     * 과목 코드&과목명 조회
     */
    @GetMapping
    public List<SubjectCodeVo> selectSubjectCode() {
        return subjectCodeService.selectSubjectCode();
    }

    /**
     * 과목 이름 변경
     */
    @PatchMapping
    public SubjectCodeVo updateSubjectNameBySeq(@Param("subjectSeq") int subjectSeq, @Param("subjectName") String subjectName) {
        return subjectCodeService.updateSubjectNameBySeq(subjectSeq, subjectName);
    }

    /**
     * 과목 삭제
     */
    @DeleteMapping
    public int deleteSubjectBySeq(int subjectSeq) {
        return subjectCodeService.deleteSubjectBySeq(subjectSeq);
    }

}
