package hello.my_projectV1.student.repository;

import hello.my_projectV1.student.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {

    void save(StudentVo studentVo);

    void update(@Param("id") Long id, @Param("updateParam") StudentUpdateDto updateDto);

    Optional<StudentVo> findById(Long id);

    List<StudentVo> findAll(StudentSearchCond searchCond);
}
