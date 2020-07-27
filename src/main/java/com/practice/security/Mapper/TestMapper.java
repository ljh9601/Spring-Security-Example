package com.practice.security.Mapper;

import java.util.List;
import com.practice.security.Dto.TestDto;
import org.springframework.stereotype.Repository;
 
@Repository
public interface TestMapper {
 
    public List<TestDto> getAll() throws Exception;
    
}
